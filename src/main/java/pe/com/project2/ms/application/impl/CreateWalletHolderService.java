package pe.com.project2.ms.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.project2.ms.application.CreateWalletHolderUseCase;
import pe.com.project2.ms.application.repository.WalletHolderRepository;
import pe.com.project2.ms.domain.WalletHolder;
import pe.com.project2.ms.infraestructure.event.WalletAccountCreatedEvent;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateWalletHolderService implements CreateWalletHolderUseCase {

    private final WalletHolderRepository walletHolderRepository;

    @Override
    public Mono<WalletHolder> save(WalletAccountCreatedEvent walletAccountCreatedEvent) {
        return walletHolderRepository.save(walletAccountCreatedEvent.toWalletHolder());
    }

}
