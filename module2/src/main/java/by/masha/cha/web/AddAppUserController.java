package by.masha.cha.web;

import by.masha.cha.model.AppUser;
import by.masha.cha.model.BodyType;
import by.masha.cha.service.AppUserService;
import by.masha.cha.service.BodyTypeService;
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

    @GetMapping("/reg-appUser.html")
    public ModelAndView showAddUserPage() {
        List<AppUser> appUsers = appUserService.getAll();
        return new ModelAndView(
                "add_appUser",
                Map.of("appUsers", appUsers)
        );
    }

    @PostMapping("/reg-appUser.html")
    public String addAppUser(AppUser appUser) {
        System.out.println("Call addAppUser: " + appUser);
        appUserService.add(appUser);
        return "redirect:/index.html";
    }
}
