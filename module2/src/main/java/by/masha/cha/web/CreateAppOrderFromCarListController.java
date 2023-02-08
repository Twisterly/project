package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.Car;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.AppOrderService;
import by.masha.cha.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CreateAppOrderFromCarListController {

    @Autowired
    private CarService carService;
    @Autowired
    private AppOrderService appOrderService;

    @GetMapping("/create-order-from-car-list.html")
    public ModelAndView showCreateAppOrderFromCarListPage(String carId) {
        Car car = carService.getById(carId);
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView(
                "createAppOrderFromCarList");
        modelAndView.addAllObjects(Map.of("car", car));
        modelAndView.addAllObjects(Map.of("userId", principal.getUserId()));
        return modelAndView;
    }

    @PostMapping("/create-order-from-car-list.html")
    public ModelAndView createAppOrderFromCarList(AppOrder appOrder,
                                                  String carId) {
        System.out.println("Call createAppOrder: " + appOrder);
        List<AppOrder> ordersList = appOrderService.findAllByCarId(carId);
        ModelAndView modelAndViewERROR = new ModelAndView(
                "createAppOrderFromCarList_error");
        if ((appOrderService.isReserved(ordersList,
                appOrder.getStartDate().toLocalDate(),
                appOrder.getEndDate().toLocalDate()) == false)
                && appOrderService.isCorrectDates(appOrder.getStartDate().toLocalDate(),
                appOrder.getEndDate().toLocalDate())) {
            appOrderService.add(appOrder);
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






