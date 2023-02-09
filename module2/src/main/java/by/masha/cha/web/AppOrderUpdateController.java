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
    public ModelAndView updateAppOrder(AppOrder appOrder,String appOrderId) {
        System.out.println("Call updateAppOrder: " + appOrder);
        List<AppOrder> ordersList = appOrderService.findAllByCarId(appOrder.getCar().getId());
        ModelAndView modelAndViewERROR = new ModelAndView(
                "createAppOrderFromCarList_error");
        if ((appOrderService.isReserved(ordersList,
                appOrderService.findById(appOrderId).getStartDate().toLocalDate(),
                appOrderService.findById(appOrderId).getEndDate().toLocalDate()) == false)
                && appOrderService.isCorrectDates(appOrderService.findById(appOrderId).getStartDate().toLocalDate(),
                appOrderService.findById(appOrderId).getEndDate().toLocalDate())) {
            appOrderService.update(appOrderService.findById(appOrderId), appOrderService.findById(appOrderId).getId());
            ModelAndView modelAndView = new ModelAndView("appOrder");
            modelAndView.addAllObjects(Map.of("appOrder", appOrderService.findById(appOrderId)));
            modelAndView.addAllObjects(Map.of("car",
                    carService.getById(appOrderService.findById(appOrderId).getCar().getId())));
            return modelAndView;

        } else {
            Car car = carService.getById(appOrderService.findById(appOrderId).getCar().getId());
            UserExt principal =
                    (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            modelAndViewERROR.addAllObjects(Map.of("car", car));
            modelAndViewERROR.addAllObjects(Map.of("userId",
                    principal.getUserId()));
            modelAndViewERROR.addAllObjects(Map.of("startDate",
                    appOrderService.findById(appOrderId).getStartDate()));
            modelAndViewERROR.addAllObjects(Map.of("endDate",
                    appOrderService.findById(appOrderId).getEndDate()));
            if (appOrderService.isAvailableDate(ordersList,
                    appOrderService.findById(appOrderId).getStartDate().toLocalDate()) != true) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 1));
            }
            if (appOrderService.isAvailableDate(ordersList,
                    appOrderService.findById(appOrderId).getEndDate().toLocalDate()) != true) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 2));
            }
            if ((appOrderService.isAvailableDate(ordersList,
                    appOrderService.findById(appOrderId).getStartDate().toLocalDate()) != true)
                    &&
                    (appOrderService.isAvailableDate(ordersList,
                            appOrderService.findById(appOrderId).getEndDate().toLocalDate()) != true)) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 3));
            }
            return modelAndViewERROR;
        }
    }

}



