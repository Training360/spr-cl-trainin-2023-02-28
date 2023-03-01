package frontendservice.employeegateway;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@EnableConfigurationProperties(EmployeeGatewayProperties.class)
public class EmployeeClientConfig {

    @Bean
    public EmployeeClient employeeClient(WebClient.Builder builder, EmployeeGatewayProperties properties) {
        var client = builder
                .baseUrl(properties.getEmployeeServiceUrl())
                .filter(new ValidationFilter(new ClassPathResource("openapi/openapi.json")))
                .build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(EmployeeClient.class);
    }
}
