package uz.paynet.qulaypul.ofdservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommissionInfoDTO {

    @JsonProperty("TIN")
    private String tin;

    @JsonProperty("PINFL")
    private String pinfl;
}
