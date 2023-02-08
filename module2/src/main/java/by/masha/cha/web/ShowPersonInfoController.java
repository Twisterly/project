package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ShowPersonInfoController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/personal-info.html")
    public ModelAndView showPersonalInfo() {
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView("personal_info");
        String id = principal.getUserId();
        AppUser appUser = appUserService.findById(id);
        modelAndView.addAllObjects( Map.of("appUser", appUser));
        return modelAndView;
    }



}
