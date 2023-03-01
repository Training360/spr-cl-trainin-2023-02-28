package frontendservice.employeegateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@Slf4j
public class ValidationFilter implements ExchangeFilterFunction {

    private ClassPathResource classPathResource;

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
                return next.exchange(request)
                .flatMap(response -> response.bodyToMono(String.class)
                        .map(body -> {
                            var clonedResponse = response.mutate().body(body).build();
                            // Extract the response body as a String
                            log.debug("Response Body: " + body);
                            return clonedResponse;
                        })
                );
    }
}
