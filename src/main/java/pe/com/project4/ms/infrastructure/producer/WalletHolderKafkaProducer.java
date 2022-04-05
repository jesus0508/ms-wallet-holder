package pe.com.project4.ms.infrastructure.producer;

import lombok.extern.slf4j.Slf4j;
import pe.com.project4.ms.infrastructure.event.WalletAccountCreatedEvent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WalletHolderKafkaProducer {

    private final KafkaTemplate<String, WalletAccountCreatedEvent> kafkaTemplate;
    private final String topic;

    public WalletHolderKafkaProducer(KafkaTemplate<String, WalletAccountCreatedEvent> kafkaTemplate,
                                     @Value("${spring.kafka.consumer.topic.name}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(WalletAccountCreatedEvent walletAccountCreatedEvent) {
        log.debug("Producing message {}", walletAccountCreatedEvent.toString());
        kafkaTemplate.send(topic, walletAccountCreatedEvent);
    }

}
