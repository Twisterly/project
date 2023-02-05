package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.Car;
import by.masha.cha.model.TransmissionType;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.AppOrderService;
import by.masha.cha.service.AppUserService;
import by.masha.cha.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddAppOrderController {
    @Autowired
    private AppOrderService appOrderService;

    @Autowired
    private CarService carService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/create-order.html")
    public ModelAndView showCreateAppOrderPage() {
//        List<AppOrder> appOrders = appOrderService.getAll();
//        return new ModelAndView(
//                "create_appOrder",
//                Map.of("appOrders", appOrders)
//        );
        List<Car> carList = carService.getAll();
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView("create_appOrder");
        modelAndView.addAllObjects(Map.of("cars", carList));
        modelAndView.addAllObjects(Map.of("userId", principal.getUserId()));
        return modelAndView;
    }

    @PostMapping("/create-order.html")
    public ModelAndView createAppOrder(AppOrder appOrder) {
        System.out.println("Call createAppOrder: " + appOrder);
        appOrderService.add(appOrder);
        String orderId = appOrder.getId();
        String carId = appOrder.getCar().getId();
        ModelAndView modelAndView = new ModelAndView("appOrder");
        AppOrder newAppOrder = appOrderService.findById(orderId);
        Car orderedCar = carService.getById(carId);
        modelAndView.addAllObjects(Map.of("newAppOrder", newAppOrder));
        modelAndView.addAllObjects(Map.of("orderedCar", orderedCar));
        return modelAndView;
    }


}
