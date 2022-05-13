package inz_proj_app.service;

import inz_proj_app.model.Passwords;
import inz_proj_app.repository.PasswordsRepository;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordsServiceImpl implements PasswordsService{

    @Autowired
    PasswordsRepository passwordsRepository;

    @Override
    public List<Passwords> findAllByUrl(String url) {
        return passwordsRepository.findAllByUrlIsContainingIgnoreCase(url)
                .stream()
                .map(this::loadPassword)
                .collect(Collectors.toList());
    }

    @Override
    public List<Passwords> findAllByEmail(String email) {
        return passwordsRepository.findAllByEmail(email)
                .stream()
                .map(this::loadPassword)
                .collect(Collectors.toList());
    }

    @Override
    public List<Passwords> findAll() {
        return passwordsRepository.findAll()
                .stream()
                .map(this::loadPassword)
                .collect(Collectors.toList());
    }

    private Passwords loadPassword(Passwords password) {
        Passwords loadPassword = new Passwords();
        loadPassword.setEmail(password.getEmail());
        loadPassword.setPasswordHash(decrypt(password.getPasswordHash()));
        loadPassword.setUrl(password.getUrl());
        loadPassword.setId(password.getId());
        loadPassword.setLastChange(password.getLastChange());

        return loadPassword;
    }

    private String decrypt(String password){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        return textEncryptor.decrypt(password);
    }
}

