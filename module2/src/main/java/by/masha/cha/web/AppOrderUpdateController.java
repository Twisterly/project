package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.Car;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.AppOrderService;
import by.masha.cha.service.AppUserService;
import by.masha.cha.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller

public class AppOrderUpdateController {
    @Autowired
    private AppOrderService appOrderService;
    @Autowired
    private CarService carService;
    @Autowired
    private AppUserService appUserService;

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
    public ModelAndView updateAppOrder(AppOrder appOrder, String carId) {
        System.out.println("Call updateAppOrder: " + appOrder);
        List<AppOrder> ordersList = appOrderService.findAllByCarId(carId);
        ModelAndView modelAndViewERROR = new ModelAndView(
                "createAppOrderFromCarList_error");
        if ((appOrderService.isReserved(ordersList,
                appOrder.getStartDate().toLocalDate(),
                appOrder.getEndDate().toLocalDate()) == false)
                && appOrderService.isCorrectDates(appOrder.getStartDate().toLocalDate(),
                appOrder.getEndDate().toLocalDate())) {
            appOrderService.update(appOrder, appOrder.getId());
            ModelAndView modelAndView = new ModelAndView("appOrder");
            modelAndView.addAllObjects(Map.of("newAppOrder", appOrder));
            modelAndView.addAllObjects(Map.of("car",
                    carService.getById(carId)));
            return modelAndView;

        } else {
            Car car = carService.getById(carId);
            UserExt principal =
                    (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            modelAndViewERROR.addAllObjects(Map.of("car", car));
            modelAndViewERROR.addAllObjects(Map.of("userId",
                    principal.getUserId()));
            modelAndViewERROR.addAllObjects(Map.of("startDate",
                    appOrder.getStartDate()));
            modelAndViewERROR.addAllObjects(Map.of("endDate",
                    appOrder.getEndDate()));
            if (appOrderService.isAvailableDate(ordersList,
                    appOrder.getStartDate().toLocalDate()) != true) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 1));
            }
            if (appOrderService.isAvailableDate(ordersList,
                    appOrder.getEndDate().toLocalDate()) != true) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 2));
            }
            if ((appOrderService.isAvailableDate(ordersList,
                    appOrder.getStartDate().toLocalDate()) != true)
                    &&
                    (appOrderService.isAvailableDate(ordersList,
                            appOrder.getEndDate().toLocalDate()) != true)) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 3));
            }
            return modelAndViewERROR;
        }
    }

}



