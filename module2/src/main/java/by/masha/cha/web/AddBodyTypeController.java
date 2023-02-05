package by.masha.cha.web;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.service.BodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddBodyTypeController {
    @Autowired
    private BodyTypeService bodyTypeService;

    @GetMapping("/add-bodyType.html")
    public ModelAndView showAddBodyTypePage() {
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        return new ModelAndView(
                "add_bodyType",
                Map.of("bodyTypes", bodyTypes)
        );
    }

    @PostMapping("/add-bodyType.html")
    //   @Secured("ADMIN")
    public ModelAndView addBodyType(BodyType bodyType) {
        System.out.println("Call addBodyType: " + bodyType);
        ModelAndView modelAndView1 = new ModelAndView("bodyType_list");
        ModelAndView modelAndView2 = new ModelAndView("error_bodyType");
        if (bodyTypeService.isAlreadyExists(bodyType) == false) {
            bodyTypeService.add(bodyType);
            List<String> bodyTypes = bodyTypeService.findAllBodyTypeNames();
            modelAndView1.addAllObjects(Map.of("bodyTypes", bodyTypes));
            modelAndView1.addAllObjects(Map.of("bodyType", bodyType.getBodyTypeName()));
            return modelAndView1;
        } else {
            List<String> bodyTypes = bodyTypeService.findAllBodyTypeNames();
            modelAndView1.addAllObjects(Map.of("bodyTypes", bodyTypes));
            return modelAndView2;
        }
    }

}
