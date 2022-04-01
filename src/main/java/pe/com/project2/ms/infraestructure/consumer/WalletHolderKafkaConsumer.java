package pe.com.project2.ms.infraestructure.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.com.project2.ms.application.CreateWalletHolderUseCase;
import pe.com.project2.ms.infraestructure.event.WalletAccountCreatedEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletHolderKafkaConsumer {

    private final CreateWalletHolderUseCase createWalletHolderUseCase;

    @KafkaListener(topics = {"WALLET-ACCOUNT-CREATED"}, groupId = "WALLET")
    public void consume(WalletAccountCreatedEvent walletAccountCreated) {
        createWalletHolderUseCase.save(walletAccountCreated).subscribe(c -> log.debug(c.toString()));
    }

}
