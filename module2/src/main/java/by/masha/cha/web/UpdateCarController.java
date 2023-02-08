package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UpdateCarController {
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

    @GetMapping("car/update-car.html")
    public ModelAndView showUpdateCarPage(String carId) {
        Car car = carService.getById(carId);
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        List<Brand> brands = brandService.getAll();
        List<FuelType> fuelTypes = fuelTypeService.getAll();
        List<TransmissionType> transmissionTypes =
                transmissionTypeService.getAll();
        ModelAndView modelAndView = new ModelAndView("update_car");
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        modelAndView.addAllObjects(Map.of("bodyTypes", bodyTypes));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("fuelTypes", fuelTypes));
        modelAndView.addAllObjects(Map.of("transmissionTypes",
                transmissionTypes));
        modelAndView.addAllObjects(Map.of("car", car));
        return modelAndView;
    }


    @PostMapping("car/update-car.html")
    @SneakyThrows
    public String updateCar(String carId) {
        Car car = carService.getById(carId);
        System.out.println("Call updateCar: " + car);
        carService.updateCar(car);
        return "redirect:/car-list.html";
    }

}



