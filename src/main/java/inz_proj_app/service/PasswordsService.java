package inz_proj_app.service;

import inz_proj_app.dto.PasswordsDto;

import java.util.List;

public interface PasswordsService {

    public List<PasswordsDto> findAllByUrl(String url);

    public List<PasswordsDto> findAllByEmail(String email);

    public List<PasswordsDto> findAll();

    public void saveNewPassword(PasswordsDto passwordsDto);

    public List<PasswordsDto> findPasswordsByUser();

    public void deletePassword(Long id);

    public void updatePassword(PasswordsDto passwordsDto);
    public PasswordsDto findPasswordById(Long id);
}

