package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller

public class AppOrderUpdateController {
    @Autowired
    private AppOrderService appOrderService;
    @Autowired
    private CarService carService;
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelDetailService modelDetailService;

    @GetMapping("/update-order.html")
    public ModelAndView showUpdateOrderPage(String appOrderId) {
        AppOrder appOrder = appOrderService.findById(appOrderId);
        Car car = carService.getById(appOrder.getCar().getId());
        List<ModelDetail> modelDetail = modelDetailService.getAll();
        List<Brand> brand = brandService.getAll();
               List<Car> carList = carService.getAll();
        AppUser appUser =
                appUserService.findById(appOrder.getAppUser().getId());
        ModelAndView modelAndView = new ModelAndView("update_order");
        modelAndView.addAllObjects(Map.of("car", car));
        modelAndView.addAllObjects(Map.of("modelDetail", modelDetail));
        modelAndView.addAllObjects(Map.of("brand", brand));
        modelAndView.addAllObjects(Map.of("appUser", appUser));
        modelAndView.addAllObjects(Map.of("cars", carList));
        modelAndView.addAllObjects(Map.of("oldAppOrderId", appOrderId));
        modelAndView.addAllObjects(Map.of("appOrder", appOrder));
        return modelAndView;
    }

    @PostMapping("/update-order.html")
    @SneakyThrows
    public ModelAndView updateAppOrder(Date startDate, Date endDate, String appOrderId,
                                       String carId) {
  //      AppOrder currentOrder = appOrderService.findById(appOrderId);
        List<AppOrder> ordersList = appOrderService.findAllByCarId(carId);
        ordersList = ordersList.stream().filter(appOrder -> appOrder.getId().equals(appOrderId)).collect(Collectors.toList());
        ModelAndView modelAndViewERROR = new ModelAndView(
                "createAppOrderFromCarList_error");
        if ((appOrderService.isReserved(ordersList,
                startDate.toLocalDate(),
                endDate.toLocalDate()) == false)
                && appOrderService.isCorrectDates(startDate.toLocalDate(),
                endDate.toLocalDate())) {
            AppOrder newOrder = appOrderService.update(startDate, endDate,
                    carId, appOrderId);
            ModelAndView modelAndView = new ModelAndView("appOrder");
            modelAndView.addAllObjects(Map.of("appOrder",
                    newOrder));
            modelAndView.addAllObjects(Map.of("car",
                    carService.getById(newOrder.getCar().getId())));
            return modelAndView;

        } else {
            Car car = carService.getById(carId);
            UserExt principal =
                    (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            modelAndViewERROR.addAllObjects(Map.of("car", car));
            modelAndViewERROR.addAllObjects(Map.of("userId",
                    principal.getUserId()));
            modelAndViewERROR.addAllObjects(Map.of("startDate",
                    startDate));
            modelAndViewERROR.addAllObjects(Map.of("endDate",
                   endDate));
            if (appOrderService.isAvailableDate(ordersList,
                    startDate.toLocalDate()) != true) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 1));
            }
            if (appOrderService.isAvailableDate(ordersList,
                    endDate.toLocalDate()) != true) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 2));
            }
            if ((appOrderService.isAvailableDate(ordersList,
                    startDate.toLocalDate()) != true)
                    &&
                    (appOrderService.isAvailableDate(ordersList,
                           endDate.toLocalDate()) != true)) {
                modelAndViewERROR.addAllObjects(Map.of("reservation", 3));
            }
            return modelAndViewERROR;
        }
    }

}



