package by.masha.cha.rest;

import by.masha.cha.model.TransmissionType;
import by.masha.cha.service.TransmissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transmissionTypes")
public class TransmissionTypeRestController {

    @Autowired
    TransmissionTypeService transmissionTypeService;

    @GetMapping("")
    public ResponseEntity<List<TransmissionType>> getAllTransmissionTypes() {
        List<TransmissionType> transmissionTypes =
                transmissionTypeService.getAll();
        return new ResponseEntity<>(
                transmissionTypes,
                HttpStatus.OK);
    }
}
