package uz.paynet.qulaypul.ofdservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TaxiInfo {

    @JsonProperty("TIN")
    private String tin;

    @JsonProperty("PINFL")
    private String pinfl;

    @JsonProperty("CardNumber")
    private String carNumber;
}
