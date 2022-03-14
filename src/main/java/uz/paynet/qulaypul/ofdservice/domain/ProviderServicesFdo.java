package uz.paynet.qulaypul.ofdservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "provider_services_test")
public class ProviderServicesFdo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SERVICE_ID")
    private Integer serviceId;

    @Column(name = "BARCODE")
    private String barcode;

    @Column(name = "PINFL")
    private String pinfl;

    @Column(name = "INN")
    private String inn;

    @Column(name = "NDS")
    private char isNds;

    @Override
    public String toString() {
        return "ProviderServicesFdo{" +
                "serviceId=" + serviceId +
                ", barcode='" + barcode + '\'' +
                ", pinfl='" + pinfl + '\'' +
                ", inn='" + inn + '\'' +
                ", isNds=" + isNds +
                '}';
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

    public Integer getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
