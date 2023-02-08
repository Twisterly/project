package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.AppOrderService;
import by.masha.cha.service.AppUserService;
import by.masha.cha.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AppUserOrderListController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppOrderService appOrderService;
    @Autowired
    private CarService carService;


    @GetMapping("/appUser-orders.html")
    public ModelAndView showAppUserOrderList(String pageNumber) {
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer page = 0;
        if (pageNumber != null) {
            page = Integer.valueOf(pageNumber);
        }
        List<AppOrder> appOrders =
                appOrderService.getPageForUser(principal.getUserId(), 3, page);
        Long appOrderCount = appOrderService.getCountForUser(principal.getUserId());
        int pageCount = (int) Math.ceil((double) appOrderCount / 3);
        List<Car> cars = carService.findAllByUserId(principal.getUserId());
        ModelAndView modelAndView = new ModelAndView("appUser_orders_list");
        modelAndView.addAllObjects(Map.of("cars", cars));
        modelAndView.addAllObjects(Map.of("appOrders", appOrders));
        modelAndView.addAllObjects(Map.of("pageCount", pageCount));
        modelAndView.addAllObjects(Map.of("currentPage", page));
        modelAndView.addAllObjects(Map.of("pages", appOrderService.getPagesList(pageCount)));
        modelAndView.addAllObjects(Map.of("appUser",
                appUserService.findById(principal.getUserId())));
        return modelAndView;

    }


}
