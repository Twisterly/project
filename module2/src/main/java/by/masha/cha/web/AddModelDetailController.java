package by.masha.cha.web;

import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.service.BrandService;
import by.masha.cha.service.ModelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.ReactiveTransaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddModelDetailController {

    @Autowired
    private ModelDetailService modelDetailService;

    @Autowired
    private BrandService brandService;

    @GetMapping("/add-modelDetail.html")
    public ModelAndView showAddModelDetailPage() {
        //       List<ModelDetail> modelDetails = modelDetailService.getAll();
        List<Brand> brands = brandService.getAll();
        ModelAndView modelAndView = new ModelAndView("add_modelDetail");
        modelAndView.addAllObjects(Map.of("brands", brands));
        return modelAndView;
//        return new ModelAndView(
//                "add_modelDetail",
//                Map.of("modelDetails", modelDetails)
//        );
    }

//    @PostMapping("/add-modelDetail.html")
//    //   @Secured("ADMIN")
//    public String addModelDetail(ModelDetail modelDetail) {
//        System.out.println("Call addModelDetail: " + modelDetail);
//        modelDetailService.add(modelDetail);
//        return "redirect:/modelDetail-list.html";
//    }

    @PostMapping("/add-modelDetail.html")
    //   @Secured("ADMIN")
    public ModelAndView addModelDetail(ModelDetail modelDetail) {
        System.out.println("Call addModelDetail: " + modelDetail);
        ModelAndView modelAndView1 = new ModelAndView("modelDetail_list");
        ModelAndView modelAndView2 = new ModelAndView("error_modelDetail");
        if (modelDetailService.isAlreadyExists(modelDetail) == false) {
            modelDetailService.add(modelDetail);
            List<String> modelDetails = modelDetailService.findAllModelNames();
            modelAndView1.addAllObjects(Map.of("modelDetails",modelDetails));
            modelAndView1.addAllObjects(Map.of("modelDetail", modelDetail.getModelName()));
            return modelAndView1;
        } else {
            List<String> modelDetails = modelDetailService.findAllModelNames();
            modelAndView1.addAllObjects(Map.of("modelDetails", modelDetails));
            return modelAndView2;
        }
    }

}