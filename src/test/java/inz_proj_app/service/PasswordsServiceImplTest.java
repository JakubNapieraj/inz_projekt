package inz_proj_app.service;

import inz_proj_app.dto.PasswordsDto;
import inz_proj_app.model.Passwords;
import inz_proj_app.model.Role;
import inz_proj_app.model.User;
import inz_proj_app.repository.PasswordsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class PasswordsServiceImplTest {

    @Mock
    PasswordsServiceImpl passwordsService;

    @Mock
    PasswordsRepository repository;

    @Test
    void findAllByUrl() {
        //given
        User user = buildNewUser();
        Passwords passwords = buildNewPasswords(user);
        List<PasswordsDto> expectedList = Collections.singletonList(buildDto(passwords));

        repository.save(passwords);

        when(passwordsService.findAllByUrl(passwords.getUrl())).thenReturn(expectedList);

        //whenThen
        assertEquals(passwordsService.findAllByUrl(passwords.getUrl()), expectedList);
    }

    @Test
    void findAllByEmail() {
        //given
        User user = buildNewUser();
        Passwords passwords = buildNewPasswords(user);
        List<PasswordsDto> expectedList = Collections.singletonList(buildDto(passwords));

        repository.save(passwords);

        when(passwordsService.findAllByEmail(user.getEmail())).thenReturn(expectedList);

        //whenThen
        assertEquals(passwordsService.findAllByEmail(user.getEmail()), expectedList);
    }

    @Test
    void findAll() {
        //given
        User user = buildNewUser();
        Passwords passwords = buildNewPasswords(user);
        List<PasswordsDto> expectedList = Collections.singletonList(buildDto(passwords));

        repository.save(passwords);

        when(passwordsService.findAll()).thenReturn(expectedList);

        //whenThen
        assertEquals(passwordsService.findAll(), expectedList);
    }

    @Test
    void findPasswordsByUser() {
        //given
        User user = buildNewUser();
        Passwords passwords = buildNewPasswords(user);
        List<PasswordsDto> expectedList = Collections.singletonList(buildDto(passwords));

        repository.save(passwords);

        when(passwordsService.findPasswordsByUser()).thenReturn(expectedList);

        //whenThen
        assertEquals(passwordsService.findPasswordsByUser(), expectedList);
    }

    @Test
    void saveNewPassword() {
//        //given
//        User user = buildNewUser();
//        Passwords password = buildNewPasswords(user);
//        List<PasswordsDto> expectedList = Collections.singletonList(buildDto(password));
//        repository.save(password);
//
//        //when
//        when(passwordsService.saveNewPassword(buildDto(password))).thenReturn(expectedList);
//
//        //then
//        assertEquals(passwordsService.saveNewPassword(password), expectedList);
    }

    private User buildNewUser(){
        User user = new User();
        user.setEmail("test@test.pl");
        user.setPassword("password");
        user.setFirstName("imie");
        user.setLastName("nazwisko");
        user.setRoles(Collections.singletonList(new Role("ROLE_USER")));
        return user;
    }

    private Passwords buildNewPasswords(User user){
        Passwords passwords = new Passwords();
        passwords.setEmail("email");
        passwords.setPasswordHash("password");
        passwords.setUrl("url");
        passwords.setLastChange(LocalDateTime.now());
        passwords.setUser(user);
        return passwords;
    }

    private PasswordsDto buildDto(Passwords passwords){
        PasswordsDto dto = new PasswordsDto();
        dto.setEmail(passwords.getEmail());
        dto.setPasswordHash(passwords.getPasswordHash());
        dto.setLastChange(passwords.getLastChange());
        dto.setUrl(passwords.getUrl());
        return dto;
    }
}