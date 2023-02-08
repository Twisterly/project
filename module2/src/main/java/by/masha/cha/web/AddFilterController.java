package by.masha.cha.web;

import by.masha.cha.model.*;
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
    @Autowired
    AppUserService appUserService;

    @GetMapping("/add-filter.html")
    public ModelAndView showAddFilter() {
        CarFilter carFilter = new CarFilter();
        List<String> brands = brandService.findAllBrandNames();
        List<String> modelDetails = modelDetailService.findAllModelNames();
        List<String> fuelTypes = fuelTypeService.findAllFuelTypeNames();
        List<String> transmissionTypes =
                transmissionTypeService.findAllTransmissionTypeNames();
        List<String> doors = carService.getAllCarDoorsModification();
        List<String> seats = carService.getAllCarSeatsModification();
        ModelAndView modelAndView = new ModelAndView("add_filter");
        modelAndView.addAllObjects(Map.of("carFilter", carFilter));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        modelAndView.addAllObjects(Map.of("fuelTypes", fuelTypes));
        modelAndView.addAllObjects(Map.of("transmissionTypes",
                transmissionTypes));
        modelAndView.addAllObjects(Map.of("doorsList", doors));
        modelAndView.addAllObjects(Map.of("seatsList", seats));
        return modelAndView;
    }

    @PostMapping("/add-filter.html")
    public ModelAndView addFilter(CarFilter carFilter, String pageNumber) {
        System.out.println("Call addFilter: " + carFilter);
        List<Brand> brands = brandService.getAll();
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        List<TransmissionType> transmissionTypes =
                transmissionTypeService.getAll();
        List<FuelType> fuelTypes = fuelTypeService.getAll();
        Integer page = 0;
        if (pageNumber != null) {
            page = Integer.valueOf(pageNumber);
        }
        List<Car> cars = carService.findCarByFilter(carFilter, 3, page);
        Long carCount = carService.getCount();
        int pageCount = (int) Math.ceil((double) carCount / 3);
        ModelAndView modelAndView = new ModelAndView("car_list");
        modelAndView.addAllObjects(Map.of("cars", cars));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("bodyTypes", bodyTypes));
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        modelAndView.addAllObjects(Map.of("transmissionTypes",
                transmissionTypes));
        modelAndView.addAllObjects(Map.of("fuelTypes", fuelTypes));
        modelAndView.addAllObjects(Map.of("pageCount", pageCount));
        modelAndView.addAllObjects(Map.of("currentPage", page));
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelAndView.addAllObjects(Map.of("role",
                appUserService.getRoleNum(appUserService.findById(principal.getUserId()))));
        return modelAndView;


    }

}
