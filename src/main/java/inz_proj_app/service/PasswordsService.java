package inz_proj_app.service;

import inz_proj_app.dto.PasswordsDto;
import inz_proj_app.model.Passwords;

import java.util.List;

public interface PasswordsService {

    public List<PasswordsDto> findAllByUrl(String url);

    public List<PasswordsDto> findAllByEmail(String email);

    public List<PasswordsDto> findAll();

    public void saveNewPassword(PasswordsDto passwordsDto);
}

