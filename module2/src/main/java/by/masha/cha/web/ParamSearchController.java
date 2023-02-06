package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.security.UserExt;
import by.masha.cha.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ParamSearchController {
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

    @GetMapping("/param-search.html")
    public ModelAndView showParamSearch() {
        List<Brand> brands = brandService.getAll();
        List<Car> cars = carService.getAll();
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        ModelAndView modelAndView = new ModelAndView("param_search");
        modelAndView.addAllObjects(Map.of("cars", cars));
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("bodyTypes", bodyTypes));
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        return modelAndView;

    }

    @PostMapping("/param-search.html")
    public ModelAndView getModels(long brandId) {
        Brand brand = brandService.findById(brandId);
        List<ModelDetail> modelDetails =
                modelDetailService.findAllModelsByBrandName(brand.getBrandName());
        System.out.println("Call getModels: " + modelDetails);
        ModelAndView modelAndView = new ModelAndView("param_search2");
        modelAndView.addAllObjects(Map.of("modelDetails",
                modelDetails));
        modelAndView.addAllObjects(Map.of("brand", brand));
        return modelAndView;

    }


}
