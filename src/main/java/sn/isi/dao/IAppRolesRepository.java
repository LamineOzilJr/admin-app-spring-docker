package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.AppRolesEntity;

public interface IAppRolesRepository extends JpaRepository<AppRolesEntity, Integer> {
}
