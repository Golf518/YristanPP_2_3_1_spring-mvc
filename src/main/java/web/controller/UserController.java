package web.controller;

import web.model.User;
import web.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @RequestMapping("/")
    public String printUsers(Model model) {

        List<User> allUsers = userService.getAllUser();
        model.addAttribute("allUs", allUsers);
        return "users";
    }

    @RequestMapping ("/addNewUsers")
    public String addNewUsers(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "users_info";
    }

    @RequestMapping("/saveUsers")
    public String saveUsers(@ModelAttribute("user") User user) {
        userService.saveUsers(user);
        return "redirect:/";
    }

    @RequestMapping("edit/{id}")
    public String updateUserGet(@PathVariable("id") int id, Model model) {
        model.addAttribute(userService.getUsers(id));
        return "edit";
    }

    @RequestMapping("/edit")
    public String updateInfo(@ModelAttribute("user") User user){
        userService.updateUsers(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUsers")
    public String deleteUsers(@RequestParam("userId") int id) {
        userService.deleteUsers(id);
        return "redirect:/";
    }

}
