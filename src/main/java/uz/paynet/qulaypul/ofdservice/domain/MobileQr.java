package uz.paynet.qulaypul.ofdservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "MOBILE_QR", schema = "test_2")
public class    MobileQr{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "MOBILE_V2.MOBILE_QR.TRG_BI_MOBILE_QR", allocationSize = 1)
    private Long id;

    @Column(name = "TRAN_ID")
    private Long tranId;

    @Column(name = "CODE")
    private Integer code;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "TERMINAL_ID")
    private String terminalId;

    @Column(name = "CHEQUE_ID")
    private Integer checkId;

    @Column(name = "FISCAL_SIGN")
    private String fiscalSign;

    @Column(name = "QR_CODE_URL")
    private String qrCodeUrl;

    @Column(name = "total_amount")
    private Long totalAmount;

    @Column(name = "paynet_comission")
    private Integer paynetComission;

    @Column(name = "provider_payment")
    private Long providerPayment;

    @Column(name = "TRAN_TYPE")
    private String tranType;

    @Column(name = "vat")
    private Long vat;

    @Column(name = "SERVICE_ID")
    private Integer serviceId;

    @Column(name = "BARCODE")
    private String productCode;

    @Column(name = "PINFL")
    private String pinfl;

    @Column(name = "INN")
    private String inn;

    @Column(name = "ISNDS")
    private char isNds;

    @Override
    public String toString() {
        return "MobileQr{" +
                "id=" + id +
                ", tranId=" + tranId +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", checkId=" + checkId +
                ", fiscalSign='" + fiscalSign + '\'' +
                ", qrCodeUrl='" + qrCodeUrl + '\'' +
                ", totalAmount=" + totalAmount +
                ", paynetComission=" + paynetComission +
                ", providerPayment=" + providerPayment +
                ", vat=" + vat +
                ", serviceId=" + serviceId +
                ", productCode='" + productCode + '\'' +
                ", pinfl='" + pinfl + '\'' +
                ", inn='" + inn + '\'' +
                ", isNds=" + isNds +
                '}';
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTranId() {
        return this.tranId;
    }

    public void setTranId(Long tranId) {
        this.tranId = tranId;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTerminalId() {
        return this.terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getCheckId() {
        return this.checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getFiscalSign() {
        return this.fiscalSign;
    }

    public void setFiscalSign(String fiscalSign) {
        this.fiscalSign = fiscalSign;
    }

    public String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public Long getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPaynetComission() {
        return this.paynetComission;
    }

    public void setPaynetComission(Integer paynetComission) {
        this.paynetComission = paynetComission;
    }

    public Long getProviderPayment() {
        return this.providerPayment;
    }

    public void setProviderPayment(Long providerPayment) {
        this.providerPayment = providerPayment;
    }

    public Long getVat() {
        return this.vat;
    }

    public void setVat(Long vat) {
        this.vat = vat;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPinfl() {
        return pinfl;
    }

    public void setPinfl(String pinfl) {
        this.pinfl = pinfl;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public char getIsNds() {
        return isNds;
    }

    public void setIsNds(char isNds) {
        this.isNds = isNds;
    }
}

