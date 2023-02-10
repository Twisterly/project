package by.masha.cha.web;

import by.masha.cha.dao.ModelDetailDao;
import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.service.ModelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ModelDetailListController {

    @Autowired
    private ModelDetailService modelDetailService;

//    @GetMapping("/modelDetail-list.html")
//    public ModelAndView showModelDetailList() {
//        return new ModelAndView(
//                "modelDetail_list",
//                Map.of("modelDetails", modelDetailDao.findAllModelNames())
//        );
//    }

    @GetMapping("/modelDetail-list.html")
    public ModelAndView showModelDetailList(String pageNumber) {
        Integer page= 0;
        if(pageNumber != null){page = Integer.valueOf(pageNumber);}
        List<ModelDetail> modelDetails = modelDetailService.getPage(5, page);
        Long modelCount = modelDetailService.getCount();
        int pageCount = (int) Math.ceil((double)modelCount/5);
        ModelAndView modelAndView = new ModelAndView("modelDetail_list");
        modelAndView.addAllObjects(Map.of("pageCount", pageCount));
        modelAndView.addAllObjects(Map.of("currentPage", page));
        modelAndView.addAllObjects(Map.of("modelDetails", modelDetails));
        return modelAndView;

    }

}
