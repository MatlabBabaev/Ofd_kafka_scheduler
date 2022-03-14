package uz.paynet.qulaypul.ofdservice.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uz.paynet.qulaypul.ofdservice.domain.MobileQr;
import uz.paynet.qulaypul.ofdservice.dto.MobileQrDto;
import uz.paynet.qulaypul.ofdservice.enumiration.TranType;

@Mapper(componentModel = "spring")
public interface MobileQrMapper {

    @Mappings({
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "tranId", source = "entity.tranId"),
            @Mapping(target = "terminalId", source = "entity.terminalId"),
            @Mapping(target = "checkId", source = "entity.checkId"),
            @Mapping(target = "fiscalSign", source = "entity.fiscalSign"),
            @Mapping(target = "qrCodeUrl", source = "entity.qrCodeUrl"),
            @Mapping(target = "totalAmount", expression = "java(entity.getTotalAmount() == null  ? null : entity.getTotalAmount()/100)"),
            @Mapping(target = "paynetComission", expression = "java(entity.getPaynetComission() == null ? null : entity.getPaynetComission()/100)"),
            @Mapping(target = "providerPayment", expression = "java(entity.getProviderPayment() == null ? null : entity.getProviderPayment()/100)"),
            @Mapping(target = "vat", expression = "java(entity.getVat() == null ? 0.0 : (double)entity.getVat()/100)"),
            @Mapping(target = "paymentType", source = "tran"),
            @Mapping(target = "cash", constant = "0"),
            @Mapping(target = "card", expression = "java(entity.getTotalAmount() == null ? null : entity.getTotalAmount()/100)"),
            @Mapping(target = "remains", constant = "0"),
            @Mapping(target = "fiscalNumber", source = "entity.terminalId"),
            @Mapping(target = "virtualKassNumber", source = "softVersion"),
            @Mapping(target = "productCode", source = "entity.productCode"),
            @Mapping(target = "agentAddress", constant = "Узбекистан, г. Ташкент, ул. Фурката, 10"),})
    MobileQrDto fromMobileQr(MobileQr entity, TranType tran, String softVersion);

}
