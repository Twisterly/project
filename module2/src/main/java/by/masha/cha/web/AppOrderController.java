package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AppOrderController {

    @Autowired
    private AppOrderService appOrderService;
    @Autowired
    private CarService carService;

    @GetMapping("/order.html")
    public ModelAndView showAppOrder(String appOrderId) {
        AppOrder appOrder = appOrderService.findById(appOrderId);
        Car car = carService.getById(appOrder.getCar().getId());
        ModelAndView modelAndView = new ModelAndView("appOrderInfo");
        modelAndView.addAllObjects(Map.of("appOrder", appOrder));
        modelAndView.addAllObjects(Map.of("car", car));
        modelAndView.addAllObjects(Map.of("status",
                appOrderService.appOrderStatus(appOrder)));
        return modelAndView;
    }

}



