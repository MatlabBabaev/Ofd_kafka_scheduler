package uz.paynet.qulaypul.ofdservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.paynet.qulaypul.ofdservice.type.ReceiptType;
import uz.paynet.qulaypul.ofdservice.type.Refund;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@Builder
public class GetQrDto {

    private Long transactionId;

    private Long receivedCash;

    private Long receivedCard;

    private String time;

    private Long totalVAT;

    private Refund isRefund;

    private ReceiptType receiptType;

    private List<ItemDto> items;

    private LocationDto location;

    private TaxiInfo taxiInfo;

    private String transactionStatusTime;




}

