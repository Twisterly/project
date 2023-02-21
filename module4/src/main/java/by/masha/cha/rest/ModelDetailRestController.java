package by.masha.cha.rest;

import by.masha.cha.model.ModelDetail;
import by.masha.cha.service.ModelDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelDetailRestController {

    @Autowired
    ModelDetailService modelDetailService;

    @GetMapping("")
    public ResponseEntity<List<ModelDetail>> getAllModels() {
        List<ModelDetail> models = modelDetailService.getAll();
        return new ResponseEntity<>(
                models,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDetail> getById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(
                modelDetailService.findById(id),
                HttpStatus.OK);
    }
}

