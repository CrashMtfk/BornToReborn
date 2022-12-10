package CSB.BornToReborn.controller;

import CSB.BornToReborn.model.UsersModel;
import CSB.BornToReborn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest",new UsersModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest",new UsersModel());
        return "login_page";
    }

    @GetMapping("/index")
    public String getIndex(Model model){
        model.addAttribute("indexRequest",new UsersModel());
        return "index_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel) {
        System.out.println("Register request: " + usersModel);
        UsersModel registeredUser = userService.registerUser(usersModel.getFullName(),usersModel.getUsername(),usersModel.getEmail(),usersModel.getPassword(),usersModel.getCountry(),usersModel.getAge(),usersModel.getGender());
        return registeredUser == null ? "register_page" : "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model) {
        System.out.println("Login request: " + usersModel);
        UsersModel authenticated = userService.authenticate(usersModel.getUsername(),usersModel.getPassword());
        if(authenticated != null) {
            model.addAttribute("userName",authenticated.getUsername());
            return "profile_page";
        }
        else {
            return "login_page";
        }
    }
}
