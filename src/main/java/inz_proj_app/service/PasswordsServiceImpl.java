package inz_proj_app.service;

import inz_proj_app.dto.PasswordsDto;
import inz_proj_app.model.Passwords;
import inz_proj_app.model.User;
import inz_proj_app.repository.PasswordsRepository;
import inz_proj_app.repository.UserRepository;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordsServiceImpl implements PasswordsService{

    @Autowired
    PasswordsRepository passwordsRepository;

    @Autowired
    UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<PasswordsDto> findAllByUrl(String url) {
        return passwordsRepository.findAllByUrlIsContainingIgnoreCase(url)
                .stream()
                .map(this::loadPassword)
                .collect(Collectors.toList());
    }

    @Override
    public List<PasswordsDto> findAllByEmail(String email) {
        return passwordsRepository.findAllByEmail(email)
                .stream()
                .map(this::loadPassword)
                .collect(Collectors.toList());
    }

    @Override
    public List<PasswordsDto> findAll() {
        return passwordsRepository.findAll()
                .stream()
                .map(this::loadPassword)
                .collect(Collectors.toList());
    }

    @Override
    public void saveNewPassword(PasswordsDto passwordsDto) {

        Passwords passwords = new Passwords();
        passwords.setUrl(passwordsDto.getUrl());
        passwords.setPasswordHash(passwordEncoder.encode(passwordsDto.getPasswordHash()));
        passwords.setEmail(passwordsDto.getEmail());
        passwords.setLastChange(LocalDateTime.now());


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user;
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();

           user = repository.findByEmail(username);
            passwords.setUser(user);
        } else {
            String username = principal.toString();
        }


        passwordsRepository.save(passwords);
    }

    private PasswordsDto loadPassword(Passwords password) {
        // TUTAJ BĘDZIE ODCZYT HASHOWANEGO HASŁA
        PasswordsDto passwordsDto = new PasswordsDto();
        passwordsDto.setEmail(password.getEmail());
        passwordsDto.setPasswordHash(password.getPasswordHash());
        passwordsDto.setUrl(password.getUrl());
        passwordsDto.setLastChange(password.getLastChange());

        return passwordsDto;
    }

    private Passwords createPasswordsFromDto(PasswordsDto dto){
        Passwords passwords = new Passwords();
        passwords.setEmail(dto.getEmail());
        passwords.setLastChange(LocalDateTime.now());
        passwords.setPasswordHash(dto.getPasswordHash());
        passwords.setUrl(dto.getUrl());
        return passwords;
    }
}

