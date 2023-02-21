package by.masha.cha.rest;

import by.masha.cha.model.Brand;
import by.masha.cha.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(
                brandService.findById(id),
                HttpStatus.OK);
    }
}

