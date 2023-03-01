package mentoring.mentoringgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DummyEmployeeController {

    @GetMapping("/dummy/api/employees")
    public Flux<EmployeeDto> employees() {
        return Flux.just(new EmployeeDto(1L, "Dummy Employee", new RoleDto(1L, "Dummy Role")));
    }

    @GetMapping("/dummy/api/roles")
    public Flux<RoleDto> roles() {
        return Flux.just(new RoleDto(1L, "Dummy Role"));
    }

}
