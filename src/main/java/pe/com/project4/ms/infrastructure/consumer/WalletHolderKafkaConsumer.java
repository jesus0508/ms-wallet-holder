package pe.com.project4.ms.infrastructure.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.project4.ms.application.CreateWalletHolderUseCase;
import pe.com.project4.ms.infrastructure.event.WalletAccountCreatedEvent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletHolderKafkaConsumer {

    private final CreateWalletHolderUseCase createWalletHolderUseCase;

    @KafkaListener(topics = {"WALLET-ACCOUNT-CREATED"}, groupId = "WALLET")
    public void consume(WalletAccountCreatedEvent walletAccountCreated) {
        log.debug("Consuming Message {}", walletAccountCreated);
        createWalletHolderUseCase.save(walletAccountCreated).subscribe(c -> log.debug(c.toString()));
    }

}
