package employeeservice.role.service;

import employeeservice.role.dto.RoleDto;
import employeeservice.role.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    List<RoleDto> toDto(List<Role> role);

}
