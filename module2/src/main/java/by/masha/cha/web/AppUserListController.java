package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/appUsers-list.html")
    public ModelAndView showAppUserList(String pageNumber) {
        Integer page= 0;
        if(pageNumber != null){page = Integer.valueOf(pageNumber);}
        List<AppUser> appUsers = appUserService.getPage(2, page);
        Long appUserCount = appUserService.getCount();
        int pageCount = (int) Math.ceil((double)appUserCount/2);
        ModelAndView modelAndView = new ModelAndView("appUsers_list");
        modelAndView.addAllObjects(Map.of("appUsers", appUsers));
        modelAndView.addAllObjects(Map.of("pageCount", pageCount));
        modelAndView.addAllObjects(Map.of("currentPage", page));
        return modelAndView;
    }


}
