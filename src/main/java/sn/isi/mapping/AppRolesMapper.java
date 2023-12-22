package sn.isi.mapping;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import sn.isi.dto.AppRoles;
import sn.isi.entities.AppRolesEntity;

@Mapper
@Service
public interface AppRolesMapper {
    AppRoles toAppRoles(AppRolesEntity appRolesEntity);
    AppRolesEntity fromAppRoles(AppRoles appRoles);
}
