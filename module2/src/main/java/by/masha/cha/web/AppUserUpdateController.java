package by.masha.cha.web;

import by.masha.cha.model.AppUser;
import by.masha.cha.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AppUserUpdateController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/update-appUser.html")
    public ModelAndView showUpdateAppUser(String appUserId) {
        AppUser appUser = appUserService.findById(appUserId);
        return new ModelAndView("update_appUser",
                Map.of("appUser", appUser));
    }

    @PostMapping("/update-appUser.html")
    public ModelAndView updateAppUser(AppUser updatedAppUser,
                                      String appUserId) {
        ModelAndView modelAndView = new ModelAndView("personal_info_updated");
        AppUser appUser = appUserService.findById(appUserId);
        modelAndView.addAllObjects(Map.of("username", appUser.getUsername()));
        modelAndView.addAllObjects(Map.of("birthDate", appUser.getBirthDate()));
        modelAndView.addAllObjects(Map.of("gender", appUser.getGender()));
        if (appUserService.isAlreadyExists(updatedAppUser, appUserId) == 1) {
            appUserService.update(updatedAppUser, appUserId);
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(updatedAppUser, appUserId) == 2) {
            ModelAndView modelAndView2 = new ModelAndView("error_appUser2");
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(updatedAppUser, appUserId) == 3) {
            ModelAndView modelAndView2 = new ModelAndView("error_appUser3");
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(updatedAppUser, appUserId) == 4) {
            ModelAndView modelAndView2 = new ModelAndView("error_appUser4");
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(updatedAppUser, appUserId) == 5) {
            ModelAndView modelAndView2 = new ModelAndView("error_appUser5");
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(updatedAppUser, appUserId) == 6) {
            ModelAndView modelAndView2 = new ModelAndView("error_appUser6");
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        } else if (appUserService.isAlreadyExists(updatedAppUser, appUserId) == 7) {
            ModelAndView modelAndView2 = new ModelAndView("error_appUser7");
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        } else {
            ModelAndView modelAndView2 = new ModelAndView("error_appUser8");
            modelAndView.addAllObjects(Map.of("appUser", updatedAppUser));
            return modelAndView;
        }
    }

}

