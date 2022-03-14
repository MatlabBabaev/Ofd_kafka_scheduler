package uz.paynet.qulaypul.ofdservice.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReceiptType {
    SELL((byte)0), AVANS((byte)1), CREDIT((byte)2);

    private Byte value;

    ReceiptType(Byte value) {
        this.value = value;
    }

    @JsonCreator
    public static ReceiptType fromValue(Byte key){
        if(key != null){
            for(ReceiptType type: values()){
                if(type.value.equals(key))
                    return type;
            }
        }
        return null;
    }

    @JsonValue
    public Byte toValue(){
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
