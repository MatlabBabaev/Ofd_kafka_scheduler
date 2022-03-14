package uz.paynet.qulaypul.ofdservice.dto;

import uz.paynet.qulaypul.ofdservice.enumiration.TranType;

public class MobileQrDto {

    private Long id;
    private Long tranId;
    private String terminalId;
    private Integer checkId;
    private String fiscalSign;
    private String qrCodeUrl;
    private Long totalAmount;
    private Integer paynetComission;
    private Long providerPayment;
    private Double vat;
    private TranType paymentType;
    private Integer cash;
    private Long card;
    private Integer remains;
    private String agentAddress;

    private String fiscalNumber;
    private String virtualKassNumber;
    private String productCode;

    @Override
    public String toString() {
        return "MobileQrDto{" +
                "id=" + id +
                ", tranId=" + tranId +
                ", terminalId='" + terminalId + '\'' +
                ", checkId=" + checkId +
                ", fiscalSign='" + fiscalSign + '\'' +
                ", qrCodeUrl='" + qrCodeUrl + '\'' +
                ", totalAmount=" + totalAmount +
                ", paynetComission=" + paynetComission +
                ", providerPayment=" + providerPayment +
                ", vat=" + vat +
                ", paymentType=" + paymentType +
                ", cash=" + cash +
                ", card=" + card +
                ", remains=" + remains +
                ", agentAddress='" + agentAddress + '\'' +
                ", fiscalNumber='" + fiscalNumber + '\'' +
                ", virtualKassNumber='" + virtualKassNumber + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public void setFiscalSign(String fiscalSign) {
        this.fiscalSign = fiscalSign;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaynetComission(Integer paynetComission) {
        this.paynetComission = paynetComission;
    }

    public void setProviderPayment(Long providerPayment) {
        this.providerPayment = providerPayment;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public void setPaymentType(TranType paymentType) {
        this.paymentType = paymentType;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public void setCard(Long card) {
        this.card = card;
    }

    public void setRemains(Integer remains) {
        this.remains = remains;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MobileQrDto))
            return false;
        MobileQrDto other = (MobileQrDto) o;
        if (!other.canEqual(this))
            return false;
        Object this$id = getId(), other$id = other.getId();
        if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id))
            return false;
        Object this$tranId = getTranId(), other$tranId = other.getTranId();
        if ((this$tranId == null) ? (other$tranId != null) : !this$tranId.equals(other$tranId))
            return false;
        Object this$checkId = getCheckId(), other$checkId = other.getCheckId();
        if ((this$checkId == null) ? (other$checkId != null) : !this$checkId.equals(other$checkId))
            return false;
        Object this$totalAmount = getTotalAmount(), other$totalAmount = other.getTotalAmount();
        if ((this$totalAmount == null) ? (other$totalAmount != null) : !this$totalAmount.equals(other$totalAmount))
            return false;
        Object this$paynetComission = getPaynetComission(), other$paynetComission = other.getPaynetComission();
        if ((this$paynetComission == null) ? (other$paynetComission != null) : !this$paynetComission.equals(other$paynetComission))
            return false;
        Object this$providerPayment = getProviderPayment(), other$providerPayment = other.getProviderPayment();
        if ((this$providerPayment == null) ? (other$providerPayment != null) : !this$providerPayment.equals(other$providerPayment))
            return false;
        Object this$vat = getVat(), other$vat = other.getVat();
        if ((this$vat == null) ? (other$vat != null) : !this$vat.equals(other$vat))
            return false;
        Object this$paymentType = getPaymentType(), other$paymentType = other.getPaymentType();
        if ((this$paymentType == null) ? (other$paymentType != null) : !this$paymentType.equals(other$paymentType))
            return false;
        Object this$cash = getCash(), other$cash = other.getCash();
        if ((this$cash == null) ? (other$cash != null) : !this$cash.equals(other$cash))
            return false;
        Object this$card = getCard(), other$card = other.getCard();
        if ((this$card == null) ? (other$card != null) : !this$card.equals(other$card))
            return false;
        Object this$remains = getRemains(), other$remains = other.getRemains();
        if ((this$remains == null) ? (other$remains != null) : !this$remains.equals(other$remains))
            return false;
        Object this$terminalId = getTerminalId(), other$terminalId = other.getTerminalId();
        if ((this$terminalId == null) ? (other$terminalId != null) : !this$terminalId.equals(other$terminalId))
            return false;
        Object this$fiscalSign = getFiscalSign(), other$fiscalSign = other.getFiscalSign();
        if ((this$fiscalSign == null) ? (other$fiscalSign != null) : !this$fiscalSign.equals(other$fiscalSign))
            return false;
        Object this$qrCodeUrl = getQrCodeUrl(), other$qrCodeUrl = other.getQrCodeUrl();
        if ((this$qrCodeUrl == null) ? (other$qrCodeUrl != null) : !this$qrCodeUrl.equals(other$qrCodeUrl))
            return false;
        Object this$agentAddress = getAgentAddress(), other$agentAddress = other.getAgentAddress();
        return !((this$agentAddress == null) ? (other$agentAddress != null) : !this$agentAddress.equals(other$agentAddress));
    }

    protected boolean canEqual(Object other) {
        return other instanceof MobileQrDto;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = getId();
        result = result * 59 + (($id == null) ? 43 : $id.hashCode());
        Object $tranId = getTranId();
        result = result * 59 + (($tranId == null) ? 43 : $tranId.hashCode());
        Object $checkId = getCheckId();
        result = result * 59 + (($checkId == null) ? 43 : $checkId.hashCode());
        Object $totalAmount = getTotalAmount();
        result = result * 59 + (($totalAmount == null) ? 43 : $totalAmount.hashCode());
        Object $paynetComission = getPaynetComission();
        result = result * 59 + (($paynetComission == null) ? 43 : $paynetComission.hashCode());
        Object $providerPayment = getProviderPayment();
        result = result * 59 + (($providerPayment == null) ? 43 : $providerPayment.hashCode());
        Object $vat = getVat();
        result = result * 59 + (($vat == null) ? 43 : $vat.hashCode());
        Object $paymentType = getPaymentType();
        result = result * 59 + (($paymentType == null) ? 43 : $paymentType.hashCode());
        Object $cash = getCash();
        result = result * 59 + (($cash == null) ? 43 : $cash.hashCode());
        Object $card = getCard();
        result = result * 59 + (($card == null) ? 43 : $card.hashCode());
        Object $remains = getRemains();
        result = result * 59 + (($remains == null) ? 43 : $remains.hashCode());
        Object $terminalId = getTerminalId();
        result = result * 59 + (($terminalId == null) ? 43 : $terminalId.hashCode());
        Object $fiscalSign = getFiscalSign();
        result = result * 59 + (($fiscalSign == null) ? 43 : $fiscalSign.hashCode());
        Object $qrCodeUrl = getQrCodeUrl();
        result = result * 59 + (($qrCodeUrl == null) ? 43 : $qrCodeUrl.hashCode());
        Object $agentAddress = getAgentAddress();
        return result * 59 + (($agentAddress == null) ? 43 : $agentAddress.hashCode());
    }

    public Long getId() {
        return this.id;
    }

    public Long getTranId() {
        return this.tranId;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public Integer getCheckId() {
        return this.checkId;
    }

    public String getFiscalSign() {
        return this.fiscalSign;
    }

    public String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public Long getTotalAmount() {
        return this.totalAmount;
    }

    public Integer getPaynetComission() {
        return this.paynetComission;
    }

    public Long getProviderPayment() {
        return this.providerPayment;
    }

    public Double getVat() {
        return this.vat;
    }

    public TranType getPaymentType() {
        return this.paymentType;
    }

    public Integer getCash() {
        return this.cash;
    }

    public Long getCard() {
        return this.card;
    }

    public Integer getRemains() {
        return this.remains;
    }

    public String getAgentAddress() {
        return this.agentAddress;
    }

    public String getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(String fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public String getVirtualKassNumber() {
        return virtualKassNumber;
    }

    public void setVirtualKassNumber(String virtualKassNumber) {
        this.virtualKassNumber = virtualKassNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}
