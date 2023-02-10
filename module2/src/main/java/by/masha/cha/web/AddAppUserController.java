package by.masha.cha.web;

import by.masha.cha.model.AppUser;
import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.service.AppUserService;
import by.masha.cha.service.BodyTypeService;
import by.masha.cha.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddAppUserController {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private CarService carService;

    @GetMapping("/reg-appUser.html")
    public ModelAndView showAddUserPage() {
        List<AppUser> appUsers = appUserService.getAll();
        return new ModelAndView(
                "add_appUser",
                Map.of("appUsers", appUsers)
        );
    }

    @PostMapping("/reg-appUser.html")
    public ModelAndView addAppUser(AppUser appUser) {
        System.out.println("Call addAppUser: " + appUser);
        if (appUserService.isAlreadyExists(appUser) == 1) {
            appUserService.add(appUser);
            return new ModelAndView("index");
        } else if (appUserService.isAlreadyExists(appUser) == 2) {
            ModelAndView modelAndView = new ModelAndView("error_appUser2");
            modelAndView.addAllObjects(Map.of("appUser", appUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(appUser) == 3) {
            ModelAndView modelAndView = new ModelAndView("error_appUser3");
            modelAndView.addAllObjects(Map.of("appUser", appUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(appUser) == 4) {
            ModelAndView modelAndView = new ModelAndView("error_appUser4");
            modelAndView.addAllObjects(Map.of("appUser", appUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(appUser) == 5) {
            ModelAndView modelAndView = new ModelAndView("error_appUser5");
            modelAndView.addAllObjects(Map.of("appUser", appUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(appUser) == 6) {
            ModelAndView modelAndView = new ModelAndView("error_appUser6");
            modelAndView.addAllObjects(Map.of("appUser", appUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(appUser) == 7) {
            ModelAndView modelAndView = new ModelAndView("error_appUser7");
            modelAndView.addAllObjects(Map.of("appUser", appUser));
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error_appUser8");
            modelAndView.addAllObjects(Map.of("appUser", appUser));
            return modelAndView;
        }
    }
}
