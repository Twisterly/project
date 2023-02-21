package by.masha.cha.rest;

import by.masha.cha.model.Brand;
import by.masha.cha.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandRestController {

    @Autowired
    BrandService brandService;

    @GetMapping("")
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAll();
        return new ResponseEntity<>(
                brands,
                HttpStatus.OK);
    }
}

