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

    @GetMapping("/order/{order.id}.html")
    public ModelAndView showAppOrder(String carId) {
        AppOrder appOrd = appOrderService.findLastOrder();
        Car car = carService.getById(carId);
        ModelAndView modelAndView = new ModelAndView("appOrder");
        modelAndView.addAllObjects( Map.of("order", appOrd));
        modelAndView.addAllObjects(Map.of("car", car));
        return modelAndView;
    }


//    @GetMapping("/pagination")
//    public String listCars(
//            Model model,
//            @RequestParam(value = "size", required = false, defaultValue = "0") Integer size,
//            @RequestParam(value = "size", required = false, defaultValue = "7") Integer page ){
//        Page<Car> pageCars = carService.findAll(PageRequest.of(page, size));
//        model.addAttribute("pageCars", pageCars);
//        model.addAttribute("numbers", IntStream.range(0, pageCars.getTotalPages()).toArray());
//
//        return "car_list";
//    }
}



