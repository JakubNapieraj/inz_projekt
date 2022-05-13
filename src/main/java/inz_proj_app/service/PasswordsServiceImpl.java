package inz_proj_app.service;

import inz_proj_app.dto.PasswordsDto;
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

    private PasswordsDto loadPassword(Passwords password) {
        PasswordsDto passwordsDto = new PasswordsDto();
        passwordsDto.setEmail(password.getEmail());
        passwordsDto.setPasswordHash(decrypt(password.getPasswordHash()));
        passwordsDto.setUrl(password.getUrl());
        passwordsDto.setId(password.getId());
        passwordsDto.setLastChange(password.getLastChange());

        return passwordsDto;
    }

    private String decrypt(String password){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        return textEncryptor.decrypt(password);
    }
}

