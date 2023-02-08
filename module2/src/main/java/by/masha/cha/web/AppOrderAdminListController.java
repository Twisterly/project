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
public class AppOrderAdminListController {

    @Autowired
    private AppOrderService appOrderService;

    @Autowired
    private CarService carService;

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/allOrders-list.html")
    public ModelAndView showOrderList(String pageNumber) {
        Integer page = 0;
        if (pageNumber != null) {
            page = Integer.valueOf(pageNumber);
        }
        List<AppOrder> appOrders =
                appOrderService.getPageForAdmin(5, page);
        Long appOrderCount = appOrderService.getCountForAdmin();
        int pageCount = (int) Math.ceil((double) appOrderCount / 5);
        List<Car> cars = carService.getAll();
        ModelAndView modelAndView = new ModelAndView("appOrder_list");
        modelAndView.addAllObjects(Map.of("cars", cars));
        modelAndView.addAllObjects(Map.of("appOrders", appOrders));
        modelAndView.addAllObjects(Map.of("pageCount", pageCount));
        modelAndView.addAllObjects(Map.of("currentPage", page));
        modelAndView.addAllObjects(Map.of("pages", appOrderService.getPagesList(pageCount)));
        return modelAndView;
    }





}
