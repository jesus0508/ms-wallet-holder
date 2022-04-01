package pe.com.project2.ms.infraestructure.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.com.project2.ms.infraestructure.event.WalletAccountCreatedEvent;

@Component
@Slf4j
public class WalletHolderKafkaProducer {

    private final KafkaTemplate<String, WalletAccountCreatedEvent> kafkaTemplate;
    private final String topicName;

    public WalletHolderKafkaProducer(KafkaTemplate<String, WalletAccountCreatedEvent> kafkaTemplate, @Value("${spring.kafka.consumer.topic.name}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(WalletAccountCreatedEvent walletAccountCreatedEvent) {
        log.debug("Producing message {}", walletAccountCreatedEvent.toString());
        this.kafkaTemplate.send(topicName, walletAccountCreatedEvent);
    }

}
