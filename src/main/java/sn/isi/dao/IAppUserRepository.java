package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.AppUserEntity;

//Spring boot enable the CRUD with JpaRepository by saying
// that the interface herits JpaRepository and we pass the entity and also
// the id ref
public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    AppUserEntity findByEmail(String email);
}
