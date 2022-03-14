package uz.paynet.qulaypul.ofdservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.paynet.qulaypul.ofdservice.domain.MobileQr;
import uz.paynet.qulaypul.ofdservice.domain.ProviderServicesFdo;
import uz.paynet.qulaypul.ofdservice.dto.*;
import uz.paynet.qulaypul.ofdservice.enumiration.TranStatus;
import uz.paynet.qulaypul.ofdservice.enumiration.TranType;
import uz.paynet.qulaypul.ofdservice.repository.MobileQrRepository;
import uz.paynet.qulaypul.ofdservice.repository.ProviderServicesFdoRepository;
import uz.paynet.qulaypul.ofdservice.services.mapper.MobileQrMapper;
import uz.paynet.qulaypul.ofdservice.type.ReceiptType;
import uz.paynet.qulaypul.ofdservice.type.Refund;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class QrServiceKafkaImpl implements QrServiceKafka {

    private final ProviderServicesFdoRepository providerServicesFdoRepository;

    private final MobileQrRepository mobileQrRepository;

    private final RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Value("${request.host}")
    private String requestUrl;

    @Value("${request.terminal}")
    private String terminal;

    @Value("${app.version}")
    private String appVersion;

    @Value("${payment.vat}")
    private Double vatComission;

    private final MobileQrMapper mobileQrMapper;

    public MobileQrDto getQr(MobileTranDto theMobileTranDto) {
        MobileTranDto mobileTranDto = theMobileTranDto;

        String date7 = timeFormatter(mobileTranDto.getTranDate7());
        if(date7==""){
            logger.error("Error date7 parse: {}", mobileTranDto);
        }

        if (mobileTranDto == null) {
            return new MobileQrDto();
        }
        this.logger.info("MOBILE_TRAN_DTO :{}", mobileTranDto);

        Long comission = (mobileTranDto.getAmount() - mobileTranDto.getPurchasedAmount());
        this.logger.info("COMISSION :{}", comission);
        Long providerPayment = mobileTranDto.getPurchasedAmount();
        this.logger.info("PROVIDER_PAYMENT :{}", providerPayment);
        Double vat = Double.valueOf(0.0D);

        ProviderServicesFdo productCode = this.providerServicesFdoRepository.findByServiceId(mobileTranDto.getServiceId());
        char isNDS = '0';
        if (productCode != null)
            isNDS = productCode.getIsNds();
        Double vatt = 0.0D;
        Integer vattPercent = 0;

        if (isNDS == '1') {
            vattPercent = vatComission.intValue();
            vatt = mobileTranDto.getAmount() * vatComission / (100 + vatComission);
        }

        this.logger.info("PRODUCT CODE :{}", productCode);
        MobileQr qrCode = new MobileQr();
        qrCode.setTranId(mobileTranDto.getTranId());
        AtomicReference<Long> totalVat = new AtomicReference<>(0L);
        if (productCode != null && productCode.getBarcode() != null) {
            List<ItemDto> items = new ArrayList<>();
            LocationDto locationDto = LocationDto.builder().latitude(41.31898D).longitude(69.24141D).build();
            GetQrDto.GetQrDtoBuilder getQrBuilder = GetQrDto.builder()
                    .transactionId(mobileTranDto.getTranId())
                    .transactionStatusTime(date7)
                    .receivedCash(0L)
                    .receivedCard(mobileTranDto.getAmount())
                    .time(date7)
                    .isRefund(mobileTranDto.getTranStatus() == TranStatus.OK ? Refund.FALSE : Refund.TRUE)
                    .receiptType((mobileTranDto.getTranMerchantHash().equals("4915") || mobileTranDto.getTranMerchantHash().equals("829")) ? ReceiptType.AVANS
                            : (mobileTranDto.getTranType() == TranType.DEBIT) ? ReceiptType.SELL : ReceiptType.CREDIT)
                    .location(locationDto);

            ItemDto.ItemDtoBuilder itemPriseBuilder = ItemDto.builder()
                    .name(mobileTranDto.getMerchantName())
                    .barcode("")
                    .label("")
                    .productCode(productCode.getBarcode())
                    .units(25)
                    .goodPrice(0L)
                    .price(mobileTranDto.getAmount())
                    .amount(1L)
                    .vat(vatt.longValue())
                    .vatPercent(vattPercent)
                    .discount(0L)
                    .other(0L);
            items.add(itemPriseBuilder.build());

            if (comission.intValue() > 0) {
                vat = comission * vatComission / (100 + vatComission);
                CommissionInfoDTO commissionInfoDTO = CommissionInfoDTO.builder().tin("205916449").build();

                ItemDto.ItemDtoBuilder commissionItemBuilder = ItemDto.builder()
                        .name("Paynet")
                        .barcode("")
                        .label("")
                        .productCode(productCode.getBarcode())
                        .units(25)
                        .goodPrice(0L)
                        .price(comission)
                        .amount(1L)
                        .vat(vat.longValue())
                        .vatPercent(this.vatComission.intValue())
                        .discount(0L)
                        .other(0L)
                        .commissionInfo(commissionInfoDTO);
                items.add(commissionItemBuilder.build());
            }
            items.forEach(i -> {
                totalVat.updateAndGet(v -> v + i.getVat());
            });
            getQrBuilder.totalVAT(totalVat.get());
            getQrBuilder.items(items);
            this.logger.info("REQUEST : {}", getQrBuilder.build());
            ResultDto result = null;
            try {
                logger.info("===>>>> {}", new ObjectMapper().writeValueAsString(getQrBuilder.build()));
                result = postRequest(getQrBuilder.build());
            } catch (Exception e) {
                this.logger.debug("Service throw error : {}", e.getCause());
            }
            if (result != null) {
                qrCode.setCode(result.getReceivedCheque().getCode());
                qrCode.setMessage(result.getReceivedCheque().getMessage());
                qrCode.setTerminalId(result.getReceivedCheque().getTerminalID());
                qrCode.setCheckId(result.getReceivedCheque().getChequeId());
                qrCode.setProductCode(productCode.getBarcode());//-------

                qrCode.setServiceId(productCode.getServiceId());
                qrCode.setInn(productCode.getInn());
                qrCode.setPinfl(productCode.getPinfl());
                qrCode.setIsNds(productCode.getIsNds());

                qrCode.setFiscalSign(result.getReceivedCheque().getFiscalSign());
                qrCode.setQrCodeUrl(result.getReceivedCheque().getQrcodeURL());
                qrCode.setTotalAmount(mobileTranDto.getAmount());
                qrCode.setPaynetComission(comission.intValue());
                qrCode.setProviderPayment(providerPayment);
                qrCode.setVat(totalVat.get());
            }
        }
        if (qrCode.getQrCodeUrl() != null) {

            qrCode = this.mobileQrRepository.save(qrCode);  // (MATLAB) may needed to add some fields to the db*

        }
        MobileQrDto qrDto = mobileQrMapper.fromMobileQr(qrCode, mobileTranDto.getTranType(), appVersion);
        return qrDto;
    }

    public ResultDto postRequest(GetQrDto getQr) {
        HttpEntity<GetQrDto> request = new HttpEntity(getQr);
        return this.restTemplate.postForObject(this.requestUrl + "v1/fdo/send/" + this.terminal, request, ResultDto.class, new Object[0]);
    }

    //parse String ZonedDateTime to formatted string ZonedDateTime (because we are getting string value from mobileTran.date7)
    public String timeFormatter(String zonedDateTimeFormat) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
            ZonedDateTime date7 = ZonedDateTime.parse(zonedDateTimeFormat);
            String formattedString = date7.format(formatter);
            return formattedString;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return "";
        }
    }

}
