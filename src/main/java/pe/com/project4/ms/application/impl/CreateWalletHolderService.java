package pe.com.project4.ms.application.impl;

import lombok.RequiredArgsConstructor;
import pe.com.project4.ms.application.CreateWalletHolderUseCase;
import pe.com.project4.ms.application.repository.WalletHolderRepository;
import pe.com.project4.ms.domain.WalletHolder;
import pe.com.project4.ms.infrastructure.event.WalletAccountCreatedEvent;

import org.springframework.stereotype.Service;

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
