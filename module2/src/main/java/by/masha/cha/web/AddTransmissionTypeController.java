package by.masha.cha.web;

import by.masha.cha.model.TransmissionType;
import by.masha.cha.service.TransmissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddTransmissionTypeController {

    @Autowired
    private TransmissionTypeService transmissionTypeService;

    @GetMapping("/add-transmissionType.html")
    public ModelAndView showAddTransmissionTypePage() {
        List<TransmissionType> transmissionTypes = transmissionTypeService.getAll();
        return new ModelAndView(
                "add_transmissionType",
                Map.of("transmissionTypes", transmissionTypes)
        );
    }

    @PostMapping("/add-transmissionType.html")
    //   @Secured("ADMIN")
    public String addTransmissionType(TransmissionType transmissionType) {
        System.out.println("Call addTransmissionType: " + transmissionType);
        transmissionTypeService.add(transmissionType);
        return "redirect:/transmissionType-list.html";
    }
}


