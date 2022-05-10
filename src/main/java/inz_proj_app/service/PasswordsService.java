package inz_proj_app.service;

import inz_proj_app.model.Passwords;
import inz_proj_app.model.Role;
import inz_proj_app.repository.PasswordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordsService {


    @Autowired
    PasswordsRepository passwordsRepository;

    public Passwords findById(String Id) {
        return passwordsRepository.findById(Id);
    }

    public List<Passwords> findAll() {
        return passwordsRepository.findAll()
                .stream()
                .map(this::loadPassword)
                .collect(Collectors.toList());
    }

    // Przede wszystkim potrzebujemy tutaj:
    // 1. Zapisać nową pozycję
    // 2. Usunąć pozycję
    // 3. Załadować pozycję (chyba wszystkie)
    // Zapisałem poniżej "wstępy" do powyższych punktów

    public Passwords save() {
        Passwords password = new Passwords();
        password.setPasswordHash("");
        return passwordsRepository.save(password);
    }

    public Passwords deleteById() {
        Passwords password = new Passwords();
        passwordsRepository.deleteById(password.getId());
        return password;
    }

    private Passwords loadPassword(Passwords password) {
        Passwords loadPassword = new Passwords();
        loadPassword.setEmail(password.getEmail());
        loadPassword.setPasswordHash(password.getPasswordHash());
        loadPassword.setNazwaStrony(password.getNazwaStrony());
        loadPassword.setId(password.getId());
        loadPassword.setLastChange(password.getLastChange());

        return loadPassword;
    }
}
