package com.codingschool.repairWeb.Controllers;

import com.codingschool.repairWeb.Model.LoginForm;
import com.codingschool.repairWeb.Services.UserServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final String LOGIN_FORM = "loginForm";
    private static final String FULL_NAME = "fullName";
    private static final String FLAG = "flag";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(HttpSession session,Model model, @RequestParam(name = "error", required = false) String error) {
        if (error != null) {
            LOG.error("User not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(!auth.getPrincipal().equals("anonymousUser")){
            System.out.println(auth.getPrincipal().toString());
            System.out.println("Ein auth twra");
        }
        model.addAttribute(FLAG, !auth.getPrincipal().equals("anonymousUser"));

        model.addAttribute(LOGIN_FORM, new LoginForm());
        if(session.getAttribute("fullName")!=null)
            model.addAttribute(FULL_NAME, session.getAttribute("fullName"));
        else
            model.addAttribute(FULL_NAME, null);
        return "index";
    }

}
