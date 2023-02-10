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

import java.util.Map;

@Controller
public class AppOrderDelayController {
    @Autowired
    private AppOrderService appOrderService;
    @Autowired
    private CarService carService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/delete-order.html")
    public ModelAndView showOrderList(String appOrderId) {
        AppOrder appOrder = appOrderService.findById(appOrderId);
        Car car = carService.getById(appOrder.getCar().getId());
        AppUser appUser = appUserService.findById(appOrder.getAppUser().getId());
        ModelAndView modelAndView = new ModelAndView("delete_question");
        modelAndView.addAllObjects( Map.of("car", car));
        modelAndView.addAllObjects(Map.of("appOrder", appOrder));
        modelAndView.addAllObjects(Map.of("appUser", appUser));
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

    @PostMapping("/delete-order.html")
    @SneakyThrows
    public String deleteAppOrder(String appOrderId) {
        AppOrder appOrder =  appOrderService.findById(appOrderId);
        System.out.println("Call deleteAppOrder: " + appOrder);
        appOrderService.delete(appOrder);
        return "redirect:/order-list.html";
    }
}
