package employeeservice.role.controller;

import employeeservice.role.dto.CreateRoleCommand;
import employeeservice.role.dto.RoleDto;
import employeeservice.role.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public List<RoleDto> findAll() {
        return roleService.findAllRoles();
    }

    @GetMapping("/{id}")
    public RoleDto findById(@PathVariable("id") long id) {
        return roleService.findRoleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "creates a role")
    public RoleDto createRole(@RequestBody CreateRoleCommand command) {
        return roleService.createRole(command);
    }


}
