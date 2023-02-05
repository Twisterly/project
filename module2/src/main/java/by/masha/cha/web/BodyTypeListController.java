package by.masha.cha.web;

import by.masha.cha.dao.BodyTypeDao;
import by.masha.cha.service.BodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class BodyTypeListController {
    @Autowired
    private BodyTypeService bodyTypeService;

    @GetMapping("/bodyType-list.html")
    public ModelAndView showBodyTypes() {
        return new ModelAndView(
                "bodyType_list",
                Map.of("bodyTypes",bodyTypeService.findAllBodyTypeNames())
        );
    }
}
