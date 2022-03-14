package uz.paynet.qulaypul.ofdservice.dto;

public class ReceivedCheque {
    private Integer code;

    private String message;

    private String terminalID;

    private Integer chequeId;

    private String fiscalSign;

    private String qrcodeURL;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public void setChequeId(Integer chequeId) {
        this.chequeId = chequeId;
    }

    public void setFiscalSign(String fiscalSign) {
        this.fiscalSign = fiscalSign;
    }

    public void setQrcodeURL(String qrcodeURL) {
        this.qrcodeURL = qrcodeURL;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReceivedCheque))
            return false;
        ReceivedCheque other = (ReceivedCheque)o;
        if (!other.canEqual(this))
            return false;
        Object this$code = getCode(), other$code = other.getCode();
        if ((this$code == null) ? (other$code != null) : !this$code.equals(other$code))
            return false;
        Object this$chequeId = getChequeId(), other$chequeId = other.getChequeId();
        if ((this$chequeId == null) ? (other$chequeId != null) : !this$chequeId.equals(other$chequeId))
            return false;
        Object this$message = getMessage(), other$message = other.getMessage();
        if ((this$message == null) ? (other$message != null) : !this$message.equals(other$message))
            return false;
        Object this$terminalID = getTerminalID(), other$terminalID = other.getTerminalID();
        if ((this$terminalID == null) ? (other$terminalID != null) : !this$terminalID.equals(other$terminalID))
            return false;
        Object this$fiscalSign = getFiscalSign(), other$fiscalSign = other.getFiscalSign();
        if ((this$fiscalSign == null) ? (other$fiscalSign != null) : !this$fiscalSign.equals(other$fiscalSign))
            return false;
        Object this$qrcodeURL = getQrcodeURL(), other$qrcodeURL = other.getQrcodeURL();
        return !((this$qrcodeURL == null) ? (other$qrcodeURL != null) : !this$qrcodeURL.equals(other$qrcodeURL));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ReceivedCheque;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $code = getCode();
        result = result * 59 + (($code == null) ? 43 : $code.hashCode());
        Object $chequeId = getChequeId();
        result = result * 59 + (($chequeId == null) ? 43 : $chequeId.hashCode());
        Object $message = getMessage();
        result = result * 59 + (($message == null) ? 43 : $message.hashCode());
        Object $terminalID = getTerminalID();
        result = result * 59 + (($terminalID == null) ? 43 : $terminalID.hashCode());
        Object $fiscalSign = getFiscalSign();
        result = result * 59 + (($fiscalSign == null) ? 43 : $fiscalSign.hashCode());
        Object $qrcodeURL = getQrcodeURL();
        return result * 59 + (($qrcodeURL == null) ? 43 : $qrcodeURL.hashCode());
    }

    public String toString() {
        return "ReceivedCheque(code=" + getCode() + ", message=" + getMessage() + ", terminalID=" + getTerminalID() + ", chequeId=" + getChequeId() + ", fiscalSign=" + getFiscalSign() + ", qrcodeURL=" + getQrcodeURL() + ")";
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTerminalID() {
        return this.terminalID;
    }

    public Integer getChequeId() {
        return this.chequeId;
    }

    public String getFiscalSign() {
        return this.fiscalSign;
    }

    public String getQrcodeURL() {
        return this.qrcodeURL;
    }
}
