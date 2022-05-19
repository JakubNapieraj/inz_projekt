package inz_proj_app.repository;

import inz_proj_app.model.Passwords;
import inz_proj_app.model.Role;
import inz_proj_app.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class PasswordsRepositoryTest {

    @Mock
    PasswordsRepository repository;

    @Test
    void shouldFindOnePassword(){
        User user = buildNewUser();
        List<Passwords> passwords = Collections.singletonList(buildNewPasswords(user));
        when(repository.findAll()).thenReturn(passwords);

        assertEquals(repository.findAll(), passwords);
    }

    private User buildNewUser(){
        User user = new User();
        user.setEmail("test@test.pl");
        user.setPassword("password");
        user.setFirstName("imie");
        user.setLastName("nazwisko");
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
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
}