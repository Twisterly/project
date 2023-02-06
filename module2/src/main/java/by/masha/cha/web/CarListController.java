package by.masha.cha.web;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Controller
public class CarListController {

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

    @GetMapping("/car-list.html")
    public ModelAndView showCarList() {
        List<Brand> brands = brandService.getAll();
        List<Car> cars = carService.getAll();
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        ModelAndView modelAndView = new ModelAndView("car_list");
        modelAndView.addAllObjects(Map.of("cars", cars));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("bodyTypes", bodyTypes));
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        UserExt principal =
                (UserExt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelAndView.addAllObjects(Map.of("role",
                appUserService.getRoleNum(appUserService.findById(principal.getUserId()))));
        return modelAndView;

    }


//    @GetMapping("/pagination")
//    public String listCars(
//            Model model,
//            @RequestParam(value = "size", required = false, defaultValue =
//            "0") Integer size,
//            @RequestParam(value = "size", required = false, defaultValue =
//            "7") Integer page ){
//        Page<Car> pageCars = carService.findAll(PageRequest.of(page, size));
//        model.addAttribute("pageCars", pageCars);
//        model.addAttribute("numbers", IntStream.range(0, pageCars
//        .getTotalPages()).toArray());
//
//        return "car_list";
//    }


    @ResponseBody
    @GetMapping("/image/{car.id}/photo.jpg")
    public byte[] getImage(@PathVariable("car.id") String carId) {
        System.out.println("Call getImage: " + carId);
        Car empl = carService.getById(carId);
        return empl.getCarPhoto().getPhoto();
    }

//    @GetMapping("/car-list.html")
//    @SneakyThrows
//    public ModelAndView updateCar( Car car) {
//        System.out.println("Call updateCar: " + car);
//        return new ModelAndView("update_car", Map.of("car", car));
//    }


}
