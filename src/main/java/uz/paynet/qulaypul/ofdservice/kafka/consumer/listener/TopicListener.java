package uz.paynet.qulaypul.ofdservice.kafka.consumer.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import uz.paynet.qulaypul.ofdservice.dto.MobileQrDto;
import uz.paynet.qulaypul.ofdservice.dto.MobileTranDto;
import uz.paynet.qulaypul.ofdservice.services.QrServiceKafka;


@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {

    private final QrServiceKafka qrService;

    @Value("${kafka.consumer_topic_name}")
    private static String TOPIC_NAME;

    @KafkaListener(topics = "QT_SERVICE", containerFactory = "mobileTranKafkaListenerContainerFactory")
        public void mobileQrService(ConsumerRecord<String, MobileTranDto> mobileTranDto){

        log.info("KAFKA CONSUME PARAMS: mobileTranDto - {}", mobileTranDto.toString());
        MobileQrDto result = this.qrService.getQr(mobileTranDto.value());
        log.info("RESULT: {}", result);
    }

}