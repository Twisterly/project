package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/update-car.html")
    public ModelAndView showUpdateCarPage(String carId) {
        Car car = carService.getById(carId);
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<Brand> brands = brandService.getAll();
        List<FuelType> fuelTypes = fuelTypeService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        List<TransmissionType> transmissionTypes =
                transmissionTypeService.getAll();
        ModelAndView modelAndView = new ModelAndView("update_car");
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("fuelTypes", fuelTypes));
        modelAndView.addAllObjects(Map.of("transmissionTypes",
                transmissionTypes));
        modelAndView.addAllObjects(Map.of("bodyTypes",
                bodyTypes));
        modelAndView.addAllObjects(Map.of("car", car));
        modelAndView.addAllObjects(Map.of("carId", carId));
        return modelAndView;
    }


    @PostMapping("/update-car.html")
    @SneakyThrows
    public ModelAndView updateCar(Car car, String carId) {
        System.out.println("Call updateCar: " + car);
        Brand brand = car.getBrand();
        ModelDetail modelDetail = car.getModelDetail();
        BodyType bodyType = car.getBodyType();
        TransmissionType transmissionType = car.getTransmissionType();
        FuelType fuelType = car.getFuelType();
        Car updatedCar = carService.updateCar(brand, modelDetail, bodyType,
                transmissionType, fuelType, car.getDoors(), car.getSeats(),
                car.getColor(), car.getPrice(), car.getActive(), car.getComment(),carId);
        return new ModelAndView("car_info", Map.of("car", updatedCar));
    }

}



