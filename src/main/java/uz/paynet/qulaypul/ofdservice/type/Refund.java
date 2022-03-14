package uz.paynet.qulaypul.ofdservice.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Refund {
    TRUE((byte)1), FALSE((byte)0);  //Done

    private Byte value;

    Refund(Byte value) {
        this.value = value;
    }

    @JsonCreator
    public static Refund fromValue(Byte key){
        if(key != null){
            for(Refund type: values()){
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
