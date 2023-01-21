package by.masha.cha.web;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.TransmissionType;
import by.masha.cha.service.AppOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddAppOrderController {
    @Autowired
    private AppOrderService appOrderService;

    @GetMapping("/create-order.html")
    public ModelAndView showCreateAppOrderPage() {
        List<AppOrder> appOrders = appOrderService.getAll();
        return new ModelAndView(
                "create_appOrder",
                Map.of("appOrders", appOrders)
        );
    }

    @PostMapping("/create-order.html")
    //   @Secured("ADMIN")
    public String createAppOrder(AppOrder appOrder) {
        System.out.println("Call createAppOrder: " + appOrder);
        appOrderService.add(appOrder);
        return "redirect:/orders-list.html";
    }


}
