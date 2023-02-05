package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
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
public class ShowPersonOrdersController {
    @Autowired
    AppOrderService appOrderService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    CarService carService;

    @GetMapping("/person-orders.html")
    public ModelAndView showPersonOrders() {
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<AppOrder> appOrders = appOrderService.findAllByUserId(userId);
        ModelAndView modelAndView = new ModelAndView("person_orders");
        String id = principal.getUserId();
        AppUser appUser = appUserService.findById(id);
        modelAndView.addAllObjects( Map.of("appUser", appUser));
        List<AppOrder> appOrders = appOrderService.findAllByUserId(id);
        modelAndView.addAllObjects(Map.of("appOrders", appOrders));
//        List<Car> cars = carService.findAllByUserId(appUser.getId());
//        modelAndView.addAllObjects(Map.of("cars", cars));
//        modelAndView.addAllObjects(Map.of("appOrders", appOrders));
        return modelAndView;
    }
}
