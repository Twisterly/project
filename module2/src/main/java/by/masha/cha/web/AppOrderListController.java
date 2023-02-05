package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.service.AppOrderService;
import by.masha.cha.service.AppUserService;
import by.masha.cha.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AppOrderListController {

    @Autowired
    private AppOrderService appOrderService;

    @Autowired
    private CarService carService;

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/order-list.html")
    public ModelAndView showOrderList() {
        List<Car> cars = carService.getAll();
        List<AppOrder> appOrders =appOrderService.getAll();
        List<AppUser> appUsers = appUserService.getAll();
        ModelAndView modelAndView = new ModelAndView("order_list");
        modelAndView.addAllObjects( Map.of("cars", cars));
        modelAndView.addAllObjects(Map.of("appOrders", appOrders));
        modelAndView.addAllObjects(Map.of("appUsers", appUsers));
        return modelAndView;
    }




}
