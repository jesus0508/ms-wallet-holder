package pe.com.project2.ms.application.repository;

import pe.com.project2.ms.domain.WalletHolder;
import reactor.core.publisher.Mono;

public interface WalletHolderRepository {
    Mono<WalletHolder> save(WalletHolder walletHolder);
    Mono<WalletHolder> findByPhoneNumber(String phoneNumber);
    Mono<WalletHolder> findByDocumentNumber(String documentNumber);
}
