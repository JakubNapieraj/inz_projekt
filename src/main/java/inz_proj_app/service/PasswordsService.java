package inz_proj_app.service;

import inz_proj_app.model.Passwords;

import java.util.List;

public interface PasswordsService {

    public List<Passwords> findAllByUrl(String url);

    public List<Passwords> findAllByEmail(String email);

    public List<Passwords> findAll();
}

