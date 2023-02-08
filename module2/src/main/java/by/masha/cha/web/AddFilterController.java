package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddFilterController {
    @Autowired
    private CarService carService;

    @Autowired
    private ModelDetailService modelDetailService;
    @Autowired
    private BodyTypeService bodyTypeService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private TransmissionTypeService transmissionTypeService;

    @GetMapping("/add-filter.html")
    public ModelAndView showAddFilter() {
        CarFilter carFilter = new CarFilter();
        ModelAndView modelAndView = new ModelAndView("add_filter");
        modelAndView.addAllObjects(Map.of("carFilter", carFilter));
        return modelAndView;
    }

    @PostMapping("/add-filter.html")
    public ModelAndView addFilter(CarFilter carFilter) {
        System.out.println("Call addFilter: " + carFilter);
        return new ModelAndView("filtered_car_list",
                Map.of("cars",
                        carService.findCarByFilter(carFilter)));

    }

}
