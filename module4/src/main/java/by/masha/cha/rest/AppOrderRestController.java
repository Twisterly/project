package by.masha.cha.rest;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.Car;
import by.masha.cha.service.AppOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appOrders")
public class AppOrderRestController {

    @Autowired
    AppOrderService appOrderService;

    @GetMapping("")
    public ResponseEntity<List<AppOrder>> getAllAppOrders() {
        List<AppOrder> appOrders = appOrderService.getAll();
        List<AppOrder> result = new ArrayList<>();
        for (AppOrder appOrder : appOrders) {
            result.add(AppOrder.builder()
                    .id(appOrder.getId())
                    .appUser(appOrder.getAppUser())
                    .startDate(appOrder.getStartDate())
                    .endDate(appOrder.getEndDate())
                    .totalSum(appOrder.getTotalSum())
                    .timeOfOrder(appOrder.getTimeOfOrder())
                    .cancellation(appOrder.isCancellation())
                    .timeOfCancellation(appOrder.getTimeOfCancellation())
                    .car(Car.builder()
                            .id(appOrder.getCar().getId())
                            .brand(appOrder.getCar().getBrand())
                            .modelDetail(appOrder.getCar().getModelDetail())
                            .regNumber(appOrder.getCar().getRegNumber())
                            .vinNumber(appOrder.getCar().getVinNumber())
                            .price(appOrder.getCar().getPrice())
                            .year(appOrder.getCar().getYear())
                            .color(appOrder.getCar().getColor())
                            .seats(appOrder.getCar().getSeats())
                            .doors(appOrder.getCar().getDoors())
                            .bodyType(appOrder.getCar().getBodyType())
                            .transmissionType(appOrder.getCar().getTransmissionType())
                            .fuelType(appOrder.getCar().getFuelType())
                            .comment(appOrder.getCar().getComment())
                            .active(appOrder.getCar().getActive())
                            .build())
                    .appUser(AppUser.builder()
                            .id(appOrder.getAppUser().getId())
                            .username(appOrder.getAppUser().getUsername())
                            .password(appOrder.getAppUser().getPassword())
                            .firstName(appOrder.getAppUser().getFirstName())
                            .lastName(appOrder.getAppUser().getLastName())
                            .birthDate(appOrder.getAppUser().getBirthDate())
                            .email(appOrder.getAppUser().getEmail())
                            .phoneNumber(appOrder.getAppUser().getPhoneNumber())
                            .gender(appOrder.getAppUser().getGender())
                            .build())
                    .build());
        }
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AppOrder> getById(@PathVariable(value = "id") String id) {
        AppOrder appOrder = appOrderService.findById(id);
        AppOrder result = AppOrder.builder()
                .id(appOrder.getId())
                .appUser(appOrder.getAppUser())
                .startDate(appOrder.getStartDate())
                .endDate(appOrder.getEndDate())
                .totalSum(appOrder.getTotalSum())
                .timeOfOrder(appOrder.getTimeOfOrder())
                .cancellation(appOrder.isCancellation())
                .timeOfCancellation(appOrder.getTimeOfCancellation())
                .car(Car.builder()
                        .id(appOrder.getCar().getId())
                        .brand(appOrder.getCar().getBrand())
                        .modelDetail(appOrder.getCar().getModelDetail())
                        .regNumber(appOrder.getCar().getRegNumber())
                        .vinNumber(appOrder.getCar().getVinNumber())
                        .price(appOrder.getCar().getPrice())
                        .year(appOrder.getCar().getYear())
                        .color(appOrder.getCar().getColor())
                        .seats(appOrder.getCar().getSeats())
                        .doors(appOrder.getCar().getDoors())
                        .bodyType(appOrder.getCar().getBodyType())
                        .transmissionType(appOrder.getCar().getTransmissionType())
                        .fuelType(appOrder.getCar().getFuelType())
                        .comment(appOrder.getCar().getComment())
                        .active(appOrder.getCar().getActive())
                        .build())
                .appUser(AppUser.builder()
                        .id(appOrder.getAppUser().getId())
                        .username(appOrder.getAppUser().getUsername())
                        .password(appOrder.getAppUser().getPassword())
                        .firstName(appOrder.getAppUser().getFirstName())
                        .lastName(appOrder.getAppUser().getLastName())
                        .birthDate(appOrder.getAppUser().getBirthDate())
                        .email(appOrder.getAppUser().getEmail())
                        .phoneNumber(appOrder.getAppUser().getPhoneNumber())
                        .gender(appOrder.getAppUser().getGender())
                        .build())
                .build();
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
}
