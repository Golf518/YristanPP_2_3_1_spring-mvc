package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiesImp;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiesImp userServiesImp;

    public UserController(UserServiesImp userServiesImp) {
        this.userServiesImp = userServiesImp;
    }

    @RequestMapping("/")
    public String printUsers(Model model) {
        List<User> users = userServiesImp.getAllUser();
        model.addAttribute("users", users);

        return "users";
    }
    @RequestMapping("/addNewUsers")
    public String addNewUsers(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user info";

    }


}
