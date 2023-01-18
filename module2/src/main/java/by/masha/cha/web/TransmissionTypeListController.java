package by.masha.cha.web;

import by.masha.cha.dao.TransmissionTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TransmissionTypeListController {

    @Autowired
    private TransmissionTypeDao transmissionTypeDao;

    @GetMapping("/transmissionType-list.html")
    public ModelAndView showTransmissionTypes() {
        return new ModelAndView(
                "transmissionType_list",
                Map.of("transmissionTypes",
                        transmissionTypeDao.findAllTransmissionTypeNames())
        );
    }
}

