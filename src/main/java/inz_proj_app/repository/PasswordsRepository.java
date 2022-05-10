package inz_proj_app.repository;

import inz_proj_app.model.Passwords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PasswordsRepository extends JpaRepository <Passwords, Long > {
    List<Passwords> findAll();
    Passwords findByNazwaStrony(String nazwaStriny);
    Passwords findById(String Id);
    Passwords save();
    Passwords deleteById(String Id);
}