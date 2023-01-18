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
    public String addBrand(Brand brand) {
        System.out.println("Call addBrand: " + brand);
        brandService.add(brand);
        return "redirect:/brand-list.html";
    }

}