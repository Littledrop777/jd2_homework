package by.academy.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "homePage";
    }


    @RequestMapping(value = {"/contactus"}, method = RequestMethod.GET)
    public String contactusPage(Model model) {
        model.addAttribute("address", "Minsk, Lenina 22");
        model.addAttribute("phone", "+375-29-1234567");
        model.addAttribute("email", "company@mail.com");
        return "contactusPage";
    }
}
