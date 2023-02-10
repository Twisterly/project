package by.masha.cha.web;

import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddBrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/add-brand.html")
    public ModelAndView showAddBrandPage() {
        List<Brand> brands = brandService.getAll();
        return new ModelAndView(
                "add_brand",
                Map.of("brands", brands)
        );
    }

    @PostMapping("/add-brand.html")
    //   @Secured("ADMIN")
    public ModelAndView addBrand(Brand brand) {
        System.out.println("Call addBrand: " + brand);

        ModelAndView modelAndView1 = new ModelAndView("brand_list");
        ModelAndView modelAndView2 = new ModelAndView("error_brand");
        if (brandService.isAlreadyExists(brand) == false) {
            brandService.add(brand);
            List<String> brands = brandService.findAllBrandNames();
            modelAndView1.addAllObjects(Map.of("brands", brands));
            modelAndView1.addAllObjects(Map.of("brand", brand.getBrandName()));
            return modelAndView1;
        } else {
            List<String> brands = brandService.findAllBrandNames();
            modelAndView1.addAllObjects(Map.of("brands", brands));
            return modelAndView2;
        }
    }


}