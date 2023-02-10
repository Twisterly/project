package by.masha.cha.web;

import by.masha.cha.service.AppOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CancelOrderController {

    @GetMapping("/cancel-order.html")
    public ModelAndView showCancelOrderPage() {
        return new ModelAndView(
                "cancel_order");

    }
}
