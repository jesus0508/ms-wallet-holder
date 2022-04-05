package pe.com.project4.ms.application;

import pe.com.project4.ms.domain.WalletHolder;
import pe.com.project4.ms.infrastructure.event.WalletAccountCreatedEvent;
import reactor.core.publisher.Mono;

public interface CreateWalletHolderUseCase {
    Mono<WalletHolder> save(WalletAccountCreatedEvent walletAccountCreatedEvent);
}
