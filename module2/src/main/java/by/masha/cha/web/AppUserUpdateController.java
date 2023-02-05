package by.masha.cha.web;

import by.masha.cha.model.AppUser;
import by.masha.cha.model.CarFilter;
import by.masha.cha.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AppUserUpdateController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/update-appUser.html")
    public ModelAndView showUpdateAppUser(AppUser appUser) {
        return new ModelAndView("update_appUser");
    }

    @PostMapping("/update-appUser.html")
    public ModelAndView addFilter(AppUser appUser) {
        System.out.println("Call updateUser: " + appUser);
        appUserService.update(appUser);
        return new ModelAndView("appUser_info",
                Map.of("appUser",
                        appUser));

    }
}
