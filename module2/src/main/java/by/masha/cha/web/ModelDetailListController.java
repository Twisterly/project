package by.masha.cha.web;

import by.masha.cha.dao.ModelDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ModelDetailListController {

    @Autowired
    private ModelDetailDao modelDetailDao;

    @GetMapping("/modelDetail-list.html")
    public ModelAndView showModelDetailList() {
        return new ModelAndView(
                "modelDetail_list",
                Map.of("modelDetails", modelDetailDao.findAllModelNames())
        );
    }

}
