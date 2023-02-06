package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.Car;
import by.masha.cha.service.AppOrderService;
import by.masha.cha.service.AppUserService;
import by.masha.cha.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller

public class AppOrderUpdateController {
    @Autowired
    AppOrderService appOrderService;
    @Autowired
    CarService carService;
    @Autowired
    AppUserService appUserService;

    @GetMapping("/update-order.html")
    public ModelAndView showUpdateOrderPage(String appOrderId) {
        AppOrder appOrder = appOrderService.findById(appOrderId);
//        Car car = carService.getById(appOrder.getCar().getId());
        List<Car> carList = carService.getAll();
        AppUser appUser =
                appUserService.findById(appOrder.getAppUser().getId());
        ModelAndView modelAndView = new ModelAndView("update_order");
//        modelAndView.addAllObjects( Map.of("car", car));
        modelAndView.addAllObjects(Map.of("appOrder", appOrder));
        modelAndView.addAllObjects(Map.of("appUser", appUser));
        modelAndView.addAllObjects(Map.of("cars", carList));
        return modelAndView;
    }

//    @GetMapping("/delete-order1.html")
//    @SneakyThrows
//    public String deleteAppOrder(String appOrderId) {
//        AppOrder appOrder =  appOrderService.findById(appOrderId);
//        System.out.println("Call deleteAppOrder: " + appOrder);
//       appOrderService.delete(appOrder);
//        return "redirect:/order-list.html";
//    }

    @PostMapping("/update-order.html")
    @SneakyThrows
    public String updateAppOrder(AppOrder appOrder, String appOrderId) {
        System.out.println("Call deleteAppOrder: " + appOrder);
        appOrderService.update(appOrder, appOrderId);
        return "redirect:/order-list.html";
    }
}


