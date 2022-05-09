package com.example.curs13springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;


@RestController
public class HomeController {

    @Autowired
    TimeZoneService timeZoneService;

    @Autowired
    HarryPotterService harryPotter;

    @Autowired
    MathService mathService;

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

    @GetMapping(value="/time")
    public LocalDateTime currentHour(@RequestParam(name = "timeZone") String timeZone) {
        return timeZoneService.getTimeByZone(timeZone);
    }

    @GetMapping(value="/harry-potter")
    public String harryPotter() {
        return harryPotter.getName();
    }

    @PostMapping(value="/math-service")
    public String harryPotter(@RequestBody MathServiceDto mathServiceDto) {
        return "result: " + mathService.getResult(mathServiceDto);
    }
}
