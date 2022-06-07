package inz_proj_app.repository;

import inz_proj_app.model.Passwords;
import inz_proj_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordsRepository extends JpaRepository <Passwords, Long > {
    List<Passwords> findAll();
    List<Passwords> findAllByUrlIsContainingIgnoreCaseAndUserEquals(String url, User user);
    List<Passwords> findAllByUrlIsContainingIgnoreCase(String url);
    List<Passwords> findAllByEmail(String email);
    List<Passwords> findPasswordsByUser(User user);
}
