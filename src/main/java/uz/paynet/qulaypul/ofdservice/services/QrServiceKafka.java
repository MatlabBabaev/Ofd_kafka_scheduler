package uz.paynet.qulaypul.ofdservice.services;
import uz.paynet.qulaypul.ofdservice.dto.MobileQrDto;
import uz.paynet.qulaypul.ofdservice.dto.MobileTranDto;

public interface QrServiceKafka {
    MobileQrDto getQr(MobileTranDto mobileTranDto);
}
