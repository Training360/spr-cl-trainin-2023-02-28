package frontendservice.employeesgateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bff-service")
@Data
public class EmployeeGatewayProperties {

    private String employeeServiceUrl;
}
