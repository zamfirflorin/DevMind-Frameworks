package devmind.curs12;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Home page requested, locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("User Page Requested");
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("emailAddress", user.getEmailAddress());
        model.addAttribute("birthDate", user.getBirthDate());
        model.addAttribute("phoneNumber", user.getPhoneNumber());
        return "user";
    }

    @RequestMapping(value = "/about", method = RequestMethod.POST)
    public String about(@Validated User user, Model model) {
        System.out.println("My Page Requested");
        return "about";
    }

}
