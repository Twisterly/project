package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
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
//        return new ModelAndView(
//                "add_car",
//                Map.of("modelDetails", modelDetails)
//        );
        return modelAndView;
    }


    @PostMapping("/add-car.html")
    @SneakyThrows
    public String addCar(@RequestParam("photo") MultipartFile file, Car car) {
        System.out.println("Call addCar: " + car);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());
        carService.add(car, file.getBytes());
        return "redirect:/car-list.html";
    }

}
