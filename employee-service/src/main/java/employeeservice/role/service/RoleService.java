package employeeservice.role.service;

import employeeservice.NotFoundException;
import employeeservice.role.dto.CreateRoleCommand;
import employeeservice.role.dto.RoleDto;
import employeeservice.role.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    private RoleMapper roleMapper;

    public RoleDto createRole(CreateRoleCommand command) {
        var role = new Role(command.getName());
        roleRepository.save(role);
        return roleMapper.toDto(role);
    }

    public List<RoleDto> findAllRoles() {
        return roleMapper.toDto(roleRepository.findAll());
    }

    public RoleDto findRoleById(long id) {
        return roleMapper.toDto(roleRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Role not found with id: " + id)));
    }

}
