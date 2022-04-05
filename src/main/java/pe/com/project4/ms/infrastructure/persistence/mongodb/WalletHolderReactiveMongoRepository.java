package pe.com.project4.ms.infrastructure.persistence.mongodb;

import lombok.RequiredArgsConstructor;
import pe.com.project4.ms.application.repository.WalletHolderRepository;
import pe.com.project4.ms.domain.WalletHolder;
import pe.com.project4.ms.infrastructure.persistence.model.WalletHolderDao;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class WalletHolderReactiveMongoRepository implements WalletHolderRepository {

    private final IWalletHolderReactiveMongoRepository walletHolderReactiveMongoRepository;

    @Override
    public Mono<WalletHolder> save(WalletHolder walletHolder) {
        return walletHolderReactiveMongoRepository.save(new WalletHolderDao(walletHolder))
                .map(WalletHolderDao::toWalletHolder);
    }

    @Override
    public Mono<WalletHolder> findByPhoneNumber(String phoneNumber) {
        return walletHolderReactiveMongoRepository.findByPhoneNumber(phoneNumber)
                .map(WalletHolderDao::toWalletHolder);
    }

    @Override
    public Mono<WalletHolder> findByDocumentNumber(String documentNumber) {
        return walletHolderReactiveMongoRepository.findByDocumentNumber(documentNumber)
                .map(WalletHolderDao::toWalletHolder);
    }
}
