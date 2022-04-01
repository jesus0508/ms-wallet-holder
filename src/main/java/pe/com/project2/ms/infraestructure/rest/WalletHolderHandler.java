package pe.com.project2.ms.infraestructure.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.com.project2.ms.infraestructure.event.WalletAccountCreatedEvent;
import pe.com.project2.ms.infraestructure.producer.WalletHolderKafkaProducer;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletHolderHandler {

    private final WalletHolderKafkaProducer walletHolderKafkaProducer;

    public Mono<ServerResponse> postWalletHolder(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(WalletAccountCreatedEvent.class)
                .map(walletAccountCreatedEvent -> {
                    walletHolderKafkaProducer.sendMessage(walletAccountCreatedEvent);
                    return walletAccountCreatedEvent;
                })
                .then(ServerResponse.noContent().build());
    }

}
