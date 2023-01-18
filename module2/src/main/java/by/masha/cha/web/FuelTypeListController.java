package by.masha.cha.web;

import by.masha.cha.dao.FuelTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class FuelTypeListController {

    @Autowired
    private FuelTypeDao fuelTypeDao;

    @GetMapping("/fuelType-list.html")
    public ModelAndView showFuelTypes() {
        return new ModelAndView(
                "fuelType_list",
                Map.of("fuelTypes", fuelTypeDao.findAllFuelTypeNames())
        );
    }
}

