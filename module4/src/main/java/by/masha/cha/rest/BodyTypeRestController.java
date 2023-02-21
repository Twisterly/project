package by.masha.cha.rest;

import by.masha.cha.model.BodyType;
import by.masha.cha.service.BodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/bodyTypes")
public class BodyTypeRestController {

    @Autowired
    BodyTypeService bodyTypeService;

    @GetMapping("")
    public ResponseEntity<List<BodyType>> getAllBodyTypes() {
        List<BodyType> bodyTypes = bodyTypeService.getAll();
        return new ResponseEntity<>(
                bodyTypes,
                HttpStatus.OK);
    }
}