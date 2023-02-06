package by.masha.cha.web;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class GuestCarListController {

    @Autowired
    private CarService carService;
    @Autowired
    private ModelDetailService modelDetailService;
    @Autowired
    private BodyTypeService bodyTypeService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/guest-car-list.html")
    public ModelAndView showCarList() {
        List<Brand> brands = brandService.getAll();
        List<Car> cars = carService.getAll();
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        ModelAndView modelAndView = new ModelAndView("guest_car_list");
        modelAndView.addAllObjects(Map.of("cars", cars));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("bodyTypes", bodyTypes));
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        return modelAndView;

    }
}
