package by.masha.cha.web;

import by.masha.cha.model.Car;
import by.masha.cha.service.BodyTypeService;
import by.masha.cha.service.BrandService;
import by.masha.cha.service.CarService;
import by.masha.cha.service.ModelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CarListController {

    @Autowired
    private CarService carService;
//    @Autowired
//    private ModelDetailService modelDetailService;
//    @Autowired
//    private BodyTypeService bodyTypeService;
//    @Autowired
//    private BrandService brandService;

    @GetMapping("/car-list.html")
    public ModelAndView showCarList() {
        return new ModelAndView(
                "car_list",
                Map.of("cars", carService.getAll())
        );

    }

    @ResponseBody
    @GetMapping("/image/{car.id}/photo.jpg")
    public byte[] getImage(@PathVariable("car.id") long carId) {
        System.out.println("Call getImage: " + carId);
        Car empl = carService.getById(carId);
        return empl.getCarPhoto().getPhoto();
    }
}
