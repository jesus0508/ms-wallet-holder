package pe.com.project4.ms.infrastructure.persistence.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.com.project4.ms.infrastructure.persistence.model.WalletHolderDao;
import reactor.core.publisher.Mono;

public interface IWalletHolderReactiveMongoRepository extends ReactiveMongoRepository<WalletHolderDao, String> {
    Mono<WalletHolderDao> findByPhoneNumber(String phoneNumber);

    Mono<WalletHolderDao> findByDocumentNumber(String documentNumber);
}
