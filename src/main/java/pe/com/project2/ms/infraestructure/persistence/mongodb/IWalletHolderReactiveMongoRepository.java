package pe.com.project2.ms.infraestructure.persistence.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.project2.ms.infraestructure.persistence.model.WalletHolderDao;
import reactor.core.publisher.Mono;

public interface IWalletHolderReactiveMongoRepository extends ReactiveMongoRepository<WalletHolderDao, String> {
    Mono<WalletHolderDao> findByPhoneNumber(String phoneNumber);

    Mono<WalletHolderDao> findByDocumentNumber(String documentNumber);
}
