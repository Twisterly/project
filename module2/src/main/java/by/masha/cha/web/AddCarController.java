package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddCarController {
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

    @GetMapping("/add-car.html")
    public ModelAndView showAddCarPage() {
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        List<Brand> brands = brandService.getAll();
        List<FuelType> fuelTypes = fuelTypeService.getAll();
        List<TransmissionType> transmissionTypes =
                transmissionTypeService.getAll();
        ModelAndView modelAndView = new ModelAndView("add_car");
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        modelAndView.addAllObjects(Map.of("bodyTypes", bodyTypes));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("fuelTypes", fuelTypes));
        modelAndView.addAllObjects(Map.of("transmissionTypes",
                transmissionTypes));
        return modelAndView;
    }


    @PostMapping("/add-car.html")
    @SneakyThrows
    public ModelAndView addCar(@RequestParam("photo") MultipartFile file, Car car, String pageNumber) {
        System.out.println("Call addCar: " + car);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        List<Brand> brands = brandService.getAll();
        ModelAndView modelAndView = new ModelAndView("car_list");
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("bodyTypes", bodyTypes));
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelAndView.addAllObjects(Map.of("role",
                appUserService.getRoleNum(appUserService.findById(principal.getUserId()))));
        if(carService.isUnique(car.getRegNumber())){
            carService.add(car, file.getBytes());
            Integer page= 0;
            if(pageNumber != null){page = Integer.valueOf(pageNumber);}
            List<Car> cars = carService.getPage(5, page);
            Long carCount = carService.getCount();
            int pageCount = (int) Math.ceil((double)carCount/5);
            modelAndView.addAllObjects(Map.of("pageCount", pageCount));
            modelAndView.addAllObjects(Map.of("currentPage", page));
            modelAndView.addAllObjects(Map.of("cars", cars));
            return modelAndView;
        }
        else
        return new ModelAndView("add_car_error",
                Map.of("car", car));
    }

}
