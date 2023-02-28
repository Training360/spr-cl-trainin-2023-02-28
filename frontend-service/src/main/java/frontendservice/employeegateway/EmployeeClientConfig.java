package frontendservice.employeegateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class EmployeeClientConfig {

    @Bean
    public EmployeeClient employeeClient(WebClient.Builder builder) {
        var client = builder
                .baseUrl("http://localhost:8081")
                .build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(EmployeeClient.class);
    }
}
