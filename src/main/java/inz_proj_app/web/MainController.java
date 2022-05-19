package inz_proj_app.web;

import inz_proj_app.service.PasswordsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private PasswordsServiceImpl passwordsService;

    public MainController(PasswordsServiceImpl passwordsService) {
        this.passwordsService = passwordsService;
    }

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("passwordsDto", passwordsService.findPasswordsByUser());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
