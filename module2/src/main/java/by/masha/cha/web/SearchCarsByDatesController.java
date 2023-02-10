package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.AppOrderService;
import by.masha.cha.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Controller
public class SearchCarsByDatesController {
    @Autowired
    private AppOrderService appOrderService;

    @Autowired
    private CarService carService;


    @GetMapping("/search-car-by-dates.html")
    public ModelAndView showCarByDatesPage() {
        ModelAndView modelAndView = new ModelAndView("search_by_dates");
        modelAndView.addAllObjects(Map.of("start",
                Date.valueOf(LocalDate.now())));
        modelAndView.addAllObjects(Map.of("end",
                Date.valueOf(LocalDate.now().plusDays(1))));
        return modelAndView;
    }

    @PostMapping("/searched-car-by-dates.html")
    public ModelAndView showCarsSearchedByDates(Date startDate, Date endDate) {
        List<AppOrder> appOrders =
                appOrderService.findAppOrdersByDates(startDate, endDate);
        List<Car> freeCars = carService.getFreeCars(appOrders);
        List<Car> cars = carService.getAll();
       return new ModelAndView("cars", Map.of("freeCars", freeCars));
    }
}

