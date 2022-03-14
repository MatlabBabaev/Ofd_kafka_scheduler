package uz.paynet.qulaypul.ofdservice.kafka.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import uz.paynet.qulaypul.ofdservice.dto.MobileTranDto;

import java.util.Map;

@EnableKafka
@Configuration
public class ConfigConsumer {

    @Bean
    public ConsumerFactory<String, MobileTranDto> getMobileTranConsumerFactory(){
        JsonDeserializer<MobileTranDto> deserializer = new JsonDeserializer<>(MobileTranDto.class);
        deserializer.setUseTypeMapperForKey(true);

        Map<String, Object> config = Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092",
                ConsumerConfig.GROUP_ID_CONFIG, "QR_SERVICE",
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest",
                ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false,
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer
        );

        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(deserializer)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MobileTranDto> mobileTranKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, MobileTranDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(getMobileTranConsumerFactory());
        return factory;
    }

}
