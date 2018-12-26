package ua.com.owu.springdemofull.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.owu.springdemofull.dao.UserDAO;
import ua.com.owu.springdemofull.models.Email;
import ua.com.owu.springdemofull.models.User;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserDAO  userDAO;
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("users", userDAO.findAll());
        return "index";
    }

    // PostMapping saves data
    @PostMapping("/saveUser")
                    // in case the name of String var is the same "userName" it may not be written in annotation brackets
    public String saveUser(@RequestParam("username") String username,
                           Model model,
                           @RequestParam("email") String email){
        System.out.println(username);
        User user = new User();
        user.setUsername(username);

        Email email1 = new Email();
        email1.setEmail(email);
        email1.setUser(user);

        List<Email> emailList = new ArrayList<>();
        emailList.add(email1);

        user.setEmails(emailList);
        userDAO.save(user);
        System.out.println(user);

        model.addAttribute("allUsers", userDAO.findAll());
        return "userSaveDone";
    }
    // {xxx} - pathVariable
    @GetMapping("/user-{xxx}")             //might be String here
    public String singleUser(@PathVariable("xxx") int id, Model model){

        model.addAttribute("currentUser", userDAO.findById(id).get());// gives object Optional

        return "singleUser";
    }
    
    @PostMapping("/saveUserX")     // if param from index.html coinsides with the field we may not type it
    public String saveUserX(User user){
        System.out.println("user: "+user);
        userDAO.save(user);
        return "redirect:/";
    }
}
