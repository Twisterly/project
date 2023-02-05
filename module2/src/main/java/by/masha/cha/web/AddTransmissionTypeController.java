package by.masha.cha.web;

import by.masha.cha.model.Brand;
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

//    @PostMapping("/add-transmissionType.html")
//    //   @Secured("ADMIN")
//    public String addTransmissionType(TransmissionType transmissionType) {
//        System.out.println("Call addTransmissionType: " + transmissionType);
//        transmissionTypeService.add(transmissionType);
//        return "redirect:/transmissionType-list.html";
//    }

    @PostMapping("/add-transmissionType.html")
    //   @Secured("ADMIN")
    public ModelAndView addTransmissionType(TransmissionType transmissionType) {
        System.out.println("Call addTransmissionType: " + transmissionType);
        ModelAndView modelAndView1 = new ModelAndView("transmissionType_list");
        ModelAndView modelAndView2 = new ModelAndView("error_transmissionType");
        if (transmissionTypeService.isAlreadyExists(transmissionType) == false) {
            transmissionTypeService.add(transmissionType);
            List<String> transmissionTypes = transmissionTypeService.findAllTransmissionTypeNames();
            modelAndView1.addAllObjects(Map.of("transmissionTypes", transmissionTypes));
            modelAndView1.addAllObjects(Map.of("transmissionType", transmissionType.getTransmissionTypeName()));
            return modelAndView1;
        } else {
            List<String> transmissionTypes = transmissionTypeService.findAllTransmissionTypeNames();
            modelAndView1.addAllObjects(Map.of("transmissionTypes", transmissionTypes));
            return modelAndView2;
        }
    }
}


