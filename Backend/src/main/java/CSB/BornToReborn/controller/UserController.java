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

    @GetMapping("/signup")
    public String getSignupPage(Model model){
        model.addAttribute("signupRequest",new UsersModel());
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest",new UsersModel());
        return "login";
    }

    @GetMapping("/index")
    public String getIndexPage(Model model){
        model.addAttribute("indexRequest",new UsersModel());
        return "index";
    }

    @GetMapping("/recycle_points")
    public String getRecyclePointsPage(Model model) {
        model.addAttribute("recyclePointsRequest",new UsersModel());
        return "recycle_points";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model) {
        model.addAttribute("profileRequest",new UsersModel());
        return "profile";
    }

    @GetMapping("/articles")
    public String getArticlesPage(Model model){
        model.addAttribute("articlesRequest",new UsersModel());
        return "articles";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UsersModel usersModel) {
        System.out.println("Sign-up request: " + usersModel);
        UsersModel registeredUser = userService.registerUser(usersModel.getFullName(),usersModel.getUsername(),usersModel.getEmail(),usersModel.getPassword(),usersModel.getCountry(),usersModel.getAge(),usersModel.getGender());
        return registeredUser == null ? "signup" : "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model) {
        System.out.println("Login request: " + usersModel);
        UsersModel authenticated = userService.authenticate(usersModel.getUsername(),usersModel.getPassword());
        if(authenticated != null) {
            model.addAttribute("userName",authenticated.getUsername());
            return "profile";
        }
        else {
            return "login";
        }
    }
}
