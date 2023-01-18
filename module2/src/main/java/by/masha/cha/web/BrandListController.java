package by.masha.cha.web;

import by.masha.cha.dao.BodyTypeDao;
import by.masha.cha.dao.BrandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class BrandListController {

    @Autowired
    private BrandDao brandDao;

    @GetMapping("/brand-list.html")
    public ModelAndView showBrands() {
        return new ModelAndView(
                "brand_list",
                Map.of("brands", brandDao.findAllBrandNames())
        );
    }
}

