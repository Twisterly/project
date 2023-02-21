package by.masha.cha.rest;

import by.masha.cha.model.AppUser;
import by.masha.cha.service.AppUserService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/appUsers")
@RequiredArgsConstructor
public class AppUserRestController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        List<AppUser> appUsers = appUserService.getAll();
        List<AppUser> result = new ArrayList<>();
        for (AppUser appUser : appUsers) {
            result.add(AppUser.builder()
                    .id(appUser.getId())
                    .username(appUser.getUsername())
                    .password(appUser.getPassword())
                    .firstName(appUser.getFirstName())
                    .lastName(appUser.getLastName())
                    .birthDate(appUser.getBirthDate())
                    .email(appUser.getEmail())
                    .phoneNumber(appUser.getPhoneNumber())
                    .gender(appUser.getGender())
                    .build());
        }
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getById(@PathVariable(value = "id") String id) {
        AppUser appUser = appUserService.findById(id);
        AppUser result = AppUser.builder()
                .id(appUser.getId())
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .birthDate(appUser.getBirthDate())
                .email(appUser.getEmail())
                .phoneNumber(appUser.getPhoneNumber())
                .gender(appUser.getGender())
                .role(appUser.getRole())
                .build();
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
}



