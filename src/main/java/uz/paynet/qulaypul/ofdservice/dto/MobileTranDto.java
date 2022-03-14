package uz.paynet.qulaypul.ofdservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;
import uz.paynet.qulaypul.ofdservice.enumiration.TranStatus;
import uz.paynet.qulaypul.ofdservice.enumiration.TranType;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class MobileTranDto {

    private Long tranId;
    private Integer serviceId;
    private Long paynetTranId;
    private Long amount;
    private Long purchasedAmount;
    private String merchantName;
    private TranType tranType;
    private String tranDate7;
    private TranStatus tranStatus;
    private String tranMerchantHash;

}
