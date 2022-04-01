package pe.com.project2.ms.application;

import pe.com.project2.ms.domain.WalletHolder;
import pe.com.project2.ms.infraestructure.event.WalletAccountCreatedEvent;
import reactor.core.publisher.Mono;

public interface CreateWalletHolderUseCase {
    Mono<WalletHolder> save(WalletAccountCreatedEvent walletAccountCreatedEvent);
}
