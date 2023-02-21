package by.masha.cha.rest;

import by.masha.cha.model.FuelType;
import by.masha.cha.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fuelTypes")
public class FuelTypeRestController {

    @Autowired
    FuelTypeService fuelTypeService;

    @GetMapping("")
    public ResponseEntity<List<FuelType>> getAllFuelTypes() {
        List<FuelType> fuelTypes = fuelTypeService.getAll();
        return new ResponseEntity<>(
                fuelTypes,
                HttpStatus.OK);
    }

}
