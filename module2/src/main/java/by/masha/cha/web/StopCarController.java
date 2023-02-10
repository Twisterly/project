package by.masha.cha.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StopCarController {

    @GetMapping("/stop-car.html")
    public ModelAndView showStopCarPage() {
        return new ModelAndView(
                "stop_car");

    }
}
