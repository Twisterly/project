package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.Car;
import by.masha.cha.model.TransmissionType;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.*;
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
        List<Car> carList = carService.getAll();
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView("create_appOrder");
        modelAndView.addAllObjects(Map.of("cars", carList));
        modelAndView.addAllObjects(Map.of("userId", principal.getUserId()));
        return modelAndView;
    }

    @PostMapping("/create-order.html")
    public ModelAndView createAppOrder(AppOrder appOrder, Car car) {
        System.out.println("Call createAppOrder: " + appOrder);
        List<AppOrder> ordersList = appOrderService.findAllByCarId(car.getId());
        if ((appOrderService.isReserved(ordersList,
                appOrder.getStartDate().toLocalDate(),
                appOrder.getEndDate().toLocalDate()) == false)
                && appOrderService.isCorrectDates(appOrder.getStartDate().toLocalDate(),
                appOrder.getEndDate().toLocalDate()))
        {
            appOrderService.add(appOrder);
            ModelAndView modelAndView = new ModelAndView("appOrder");
            modelAndView.addAllObjects(Map.of("newAppOrder", appOrder));
            modelAndView.addAllObjects(Map.of("car",
                    carService.getById(car.getId())));
            return modelAndView;
        }
        else
            return new ModelAndView("error");
//        List<AppOrder> ordersList = appOrderService.findAllByCarId(carId);
//        if (appOrderService.isReserved(ordersList, appOrder.getStartDate().toLocalDate(), appOrder.getEndDate().toLocalDate()) == false) {
//            appOrderService.add(appOrder);
//            ModelAndView modelAndView = new ModelAndView("appOrder");
//            modelAndView.addAllObjects(Map.of("newAppOrder", appOrder));
//            modelAndView.addAllObjects(Map.of("car", carService.getById(carId)));
//            return modelAndView;
//        }
//        else
//            return new ModelAndView("error");
    }


}
