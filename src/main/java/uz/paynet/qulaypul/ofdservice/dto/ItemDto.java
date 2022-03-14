package uz.paynet.qulaypul.ofdservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {

    private String name;

    private String barcode;

    private String label;

    private String productCode;

    private Integer units;

    private Long goodPrice;

    private Long price;

    private Long amount;

    private Long vat;

    private Integer vatPercent;

    private Long discount;

    private Long other;

    private CommissionInfoDTO commissionInfo;
}
