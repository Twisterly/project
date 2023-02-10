package by.masha.cha.web;


import by.masha.cha.model.Brand;
import by.masha.cha.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BrandListController {

    @Autowired
    private BrandService brandService;


    @GetMapping("/brand-list.html")
    public ModelAndView showBrands(String pageNumber) {
        Integer page= 0;
        if(pageNumber != null){page = Integer.valueOf(pageNumber);}
        List<Brand> brands = brandService.getPage(5, page);
        Long brandCount = brandService.getCount();
        int pageCount = (int) Math.ceil((double)brandCount/5);
        ModelAndView modelAndView = new ModelAndView("brand_list");
        modelAndView.addAllObjects(Map.of("brands", brands));
        modelAndView.addAllObjects(Map.of("pageCount", pageCount));
        modelAndView.addAllObjects(Map.of("currentPage", page));
        return modelAndView;

    }
}

