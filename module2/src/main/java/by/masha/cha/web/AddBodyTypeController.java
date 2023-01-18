package by.masha.cha.web;

import by.masha.cha.model.BodyType;
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
    public String addBodyType(BodyType bodyType) {
        System.out.println("Call addBodyType: " + bodyType);
        bodyTypeService.add(bodyType);
        return "redirect:/bodyType-list.html";
    }

}
