package com.amos.controller.admin;

import com.amos.entity.User;
import com.amos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Amos
 * @date 2020-10-28 20:34
 */
public class LoginController {


    @Autowired
    private UserService userService;


    /**
     * Restful login
     * @return
     */
    @GetMapping
    public  String loginPage()
    {
        return "admin/login";
    }


    /**
     * Restful api
     * @param username
     * @param password
     * @param session
     * @param attributes
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes)
    {
        User user = userService.checkUser(username, password);
        if(user != null)
        {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }
        else
        {
           attributes.addFlashAttribute("message","username or password wrong");
           return "redirect:/admin";
        }
    }


    /**
     * RestfulApi
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        return "redirect/:admin";
    }
}
