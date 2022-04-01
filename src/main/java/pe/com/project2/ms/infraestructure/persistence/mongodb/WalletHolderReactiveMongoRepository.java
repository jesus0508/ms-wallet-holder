package pe.com.project2.ms.infraestructure.persistence.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.com.project2.ms.application.repository.WalletHolderRepository;
import pe.com.project2.ms.domain.WalletHolder;
import pe.com.project2.ms.infraestructure.persistence.model.WalletHolderDao;
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
