package frontendservice.employeegateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "frontend-service")
@Data
public class EmployeeGatewayProperties {

    private String employeeServiceUrl;
}
