package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AppUserListController {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppOrderService appOrderService;

    @GetMapping("/appUser-list.html")
    public ModelAndView showAppUserList() {
        List<AppOrder> appOrders
                = appOrderService.getAll();
        List<AppUser> appUsers = appUserService.getAll();
        ModelAndView modelAndView = new ModelAndView("appUsers_list");
        modelAndView.addAllObjects(Map.of("appUsers", appUsers));
        modelAndView.addAllObjects(Map.of("appOrders", appOrders));
        return modelAndView;
    }


}
