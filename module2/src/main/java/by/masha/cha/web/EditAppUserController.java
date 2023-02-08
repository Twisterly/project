package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.AppUserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class EditAppUserController {

    @Autowired
    private AppUserService appUserService;


    @GetMapping("edit-appUser-info.html")
    public ModelAndView showEditAppUserPage(String appUserId) {
        AppUser appUser = appUserService.findById(appUserId);
        ModelAndView modelAndView = new ModelAndView("edit_appUser");
        modelAndView.addAllObjects(Map.of("appUser", appUser));
        return modelAndView;
    }

//    @PostMapping("car/edit-appUser-info.html")
//    @SneakyThrows
//    public String editAppUser(String appUserId) {
//        AppUser appUser = appUserService.findById(appUserId);
//        System.out.println("Call editAppUser: " + appUser);
//        appUserService.update(appUser);
//        return "redirect:/person-info.html";
//    }

    @PostMapping("edit-appUser-info.html")
    @SneakyThrows
    public String editAppUser(String appUserId) {
        AppUser appUser = appUserService.findById(appUserId);
        System.out.println("Call editAppUser: " + appUser);
        appUserService.update(appUser);
        return "redirect:/person-info.html";
    }

}



