package inz_proj_app.controller;

import inz_proj_app.dto.PasswordsDto;
import inz_proj_app.dto.UserRegistrationDto;
import inz_proj_app.model.Passwords;
import inz_proj_app.service.PasswordsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class PasswordController {

    private PasswordsServiceImpl passwordsService;

    public PasswordController(PasswordsServiceImpl passwordsService) {
        this.passwordsService = passwordsService;
    }

    @GetMapping("/password/add")
    public String preaperNewPassword(Model model) {
        model.addAttribute("password", new PasswordsDto());
        return "addNewPassword";
    }

    @PostMapping("/password/add")
    public RedirectView addPassword(@ModelAttribute("password") @Valid PasswordsDto passwordsDto) {
        passwordsService.saveNewPassword(passwordsDto);
        return new RedirectView("/");
    }

    @PostMapping("/password/delete/{id}")
    public RedirectView deletePassword(@PathVariable Long id) {
        passwordsService.deletePassword(id);
        return new RedirectView("/");
    }

    @PostMapping("/password/update/{id}")
    public String preparePasswordForUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("password", passwordsService.findPasswordById(id));
        return "updatePassword";
    }

    @PostMapping("/password/update/save/{id}")
    public RedirectView updatePassword(@PathVariable Long id, @ModelAttribute("passwords") @Valid PasswordsDto passwordsDto) {
        passwordsService.updatePassword(id, passwordsDto);
        return new RedirectView("/");
    }


    @RequestMapping(path = {"/", "/search"})
    public String home(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("passwordsDto", passwordsService.findAllByEmailOrUrl(keyword));
        } else {
            model.addAttribute("passwordsDto", passwordsService.findPasswordsByUser());
        }
        return "index";
    }
}
