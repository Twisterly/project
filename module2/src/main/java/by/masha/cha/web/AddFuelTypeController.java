package by.masha.cha.web;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.FuelType;
import by.masha.cha.service.BodyTypeService;
import by.masha.cha.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddFuelTypeController {

    @Autowired
    private FuelTypeService fuelTypeService;

    @GetMapping("/add-fuelType.html")
    public ModelAndView showAddFuelTypePage() {
        List<FuelType> fuelTypes = fuelTypeService.getAll();
        return new ModelAndView(
                "add_fuelType",
                Map.of("fuelTypes", fuelTypes)
        );
    }

//    @PostMapping("/add-fuelType.html")
//    //   @Secured("ADMIN")
//    public String addFuelType(FuelType fuelType) {
//        System.out.println("Call addFuelType: " + fuelType);
//        fuelTypeService.add(fuelType);
//        return "redirect:/fuelType-list.html";
//    }

    @PostMapping("/add-fuelType.html")
    //   @Secured("ADMIN")
    public ModelAndView addFuelType(FuelType fuelType) {
        System.out.println("Call addBrand: " + fuelType);
        ModelAndView modelAndView1 = new ModelAndView("fuelType_list");
        ModelAndView modelAndView2 = new ModelAndView("error_fuel");
        if (fuelTypeService.isAlreadyExists(fuelType) == false) {
            fuelTypeService.add(fuelType);
            List<String> fuelTypes = fuelTypeService.findAllFuelTypeNames();
            modelAndView1.addAllObjects(Map.of("fuelTypes",fuelTypes));
            modelAndView1.addAllObjects(Map.of("fuelType", fuelType.getFuelTypeName()));
            return modelAndView1;
        } else {
            List<String> fuelTypes = fuelTypeService.findAllFuelTypeNames();
            modelAndView1.addAllObjects(Map.of("fuelTypes", fuelTypes));
            return modelAndView2;
        }
    }

}

