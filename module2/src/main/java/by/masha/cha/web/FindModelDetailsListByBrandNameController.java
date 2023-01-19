package by.masha.cha.web;

import by.masha.cha.model.*;
import by.masha.cha.service.BrandService;
import by.masha.cha.service.ModelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class FindModelDetailsListByBrandNameController {

    @Autowired
    private ModelDetailService modelDetailService;
    @Autowired
    private BrandService brandService;

    @GetMapping("/search-modelDetail.html")
    public ModelAndView showFindModelDetailsPage() {
        List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<Brand> brands = brandService.getAll();
        ModelAndView modelAndView = new ModelAndView("search_modelDetails");
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        modelAndView.addAllObjects(Map.of("brands", brands));
//        return new ModelAndView(
//                "add_car",
//                Map.of("modelDetails", modelDetails)
//        );
        return modelAndView;
    }

    @PostMapping("/search-modelDetail.html")
    public String showFindModelDetailsPage(ModelDetail modelDetail, Brand brand) {
        System.out.println("Call showModelDetails: " + modelDetail);
        modelDetailService.findAllModelsByBrandName(brand.getBrandName());
        return "redirect:/modelDetailSearch-list.html";
    }


}
