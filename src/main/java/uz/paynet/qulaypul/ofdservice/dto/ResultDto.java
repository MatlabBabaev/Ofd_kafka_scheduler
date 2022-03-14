package uz.paynet.qulaypul.ofdservice.dto;

import java.util.Objects;

public class ResultDto {
    private SendCheque sentCheque;

    private ReceivedCheque receivedCheque;

    public void setSentCheque(SendCheque sentCheque) {
        this.sentCheque = sentCheque;
    }

    public void setReceivedCheque(ReceivedCheque receivedCheque) {
        this.receivedCheque = receivedCheque;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResultDto))
            return false;
        ResultDto other = (ResultDto) o;
        if (!other.canEqual(this))
            return false;
        Object this$sentCheque = getSentCheque(), other$sentCheque = other.getSentCheque();
        if (!Objects.equals(this$sentCheque, other$sentCheque))
            return false;
        Object this$receivedCheque = getReceivedCheque(), other$receivedCheque = other.getReceivedCheque();
        return !(!Objects.equals(this$receivedCheque, other$receivedCheque));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResultDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $sentCheque = getSentCheque();
        result = result * 59 + (($sentCheque == null) ? 43 : $sentCheque.hashCode());
        Object $receivedCheque = getReceivedCheque();
        return result * 59 + (($receivedCheque == null) ? 43 : $receivedCheque.hashCode());
    }

    public String toString() {
        return "ResultDto(sentCheque=" + getSentCheque() + ", receivedCheque=" + getReceivedCheque() + ")";
    }

    public SendCheque getSentCheque() {
        return this.sentCheque;
    }

    public ReceivedCheque getReceivedCheque() {
        return this.receivedCheque;
    }
}
