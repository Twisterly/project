package by.masha.cha.service;

import by.masha.cha.dao.CarDao;
import by.masha.cha.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class CarService {
    @Autowired
    CarDao carDao;

    @Transactional
    public void add(Car car, byte[] photo) {
        //       Brand brand = car.getBrand();
//        if (brand == null) {
//            car.setBrand(new Brand());
//        }
//        FuelType fuelType = car.getFuelType();
//        if (fuelType == null) {
//            car.setFuelType(new FuelType());
//        }
//        TransmissionType transmissionType = car.getTransmissionType();
//        if (transmissionType == null) {
//            car.setTransmissionType(new TransmissionType());
//        }
        //       BodyType bodyType = car.getBodyType();
//        if (bodyType == null) {
//            car.setBodyType(new BodyType());
//        }
        if (car.getCarPhoto() == null) {
            CarPhoto carPhoto = new CarPhoto();
            carPhoto.setCar(car);
            carPhoto.setPhoto(photo);
            car.setCarPhoto(carPhoto);
        }

        carDao.create(car);

    }

//    public Page<Car> listAll() {
//        Pageable pageable = PageRequest.of(0, 5);
//        return repo.findAll(pageable);
//    }

    public List<Car> getAll() {
        return carDao.findAll();
    }

    public Car getById(String carId) {
        return carDao.findById(carId);
    }


    public List<Car> findCarByFilter(CarFilter carFilter, Integer pageSize,
                                     Integer pageNumber) {
        return carDao.findCarByFilter(carFilter, pageSize, pageNumber);

    }

    public Car updateCar(Brand brand,
                         ModelDetail modelDetail,
                         BodyType bodyType,
                         TransmissionType transmissionType,
                         FuelType fuelType,
                         Integer doors,
                         Integer seats,
                         String color,
                         double price,
                         String carId) {

        Car car = carDao.findById(carId);
        if (!(car.getBrand().equals(brand))) {
            car.setBrand(brand);
        }
        if (!(car.getModelDetail().equals(modelDetail))) {
            car.setModelDetail(modelDetail);
        }
        if (!(car.getBodyType().equals(bodyType))) {
            car.setBodyType(bodyType);
        }
        if (!(car.getTransmissionType().equals(transmissionType))) {
            car.setTransmissionType(transmissionType);
        }
        if (car.getDoors() != doors) {
            car.setDoors(doors);
        }
        if (car.getSeats() != seats) {
            car.setSeats(seats);
        }
        if (!(car.getColor().equals(color))) {
            car.setColor(color);
        }
        if (car.getPrice() != price) {
            car.setPrice(price);
        }
//        if (car.isClimateControl() == climateControl) {
//            car.setClimateControl(climateControl);
//        }
        carDao.update(car);
        return car;
    }

    public List<Car> findAllByUserId(String userId) {
        return carDao.findAllByUserId(userId);
    }

    public List<Car> findAllByLimit(Integer limit, Integer offset) {
        return carDao.findAllByLimit(limit, offset);
    }

    public List<Car> findAllAndSortByYear() {
        return carDao.findAllAndSortByYear();
    }

    public List<Car> getPage(Integer pageSize, Integer pageNumber) {
        return carDao.getPage(pageSize, pageNumber);
    }

    public Long getCount() {
        return carDao.getCount();
    }

    public List<Car> getFreeCars(List<AppOrder> orders) {
        List<Car> allCars = carDao.findAll();
        List<Car> orderedCars = new ArrayList<>();
        for (AppOrder appOrder : orders) {
            orderedCars.add(appOrder.getCar());
        }
        for (Car car : allCars) {
            if (allCars.stream().anyMatch(car::equals)) {
                allCars.remove(car);
            }
        }
        return allCars;
    }

    public List<String> getAllCarDoorsModification() {
        return carDao.getAllCarDoorsModification();
    }

    public List<String> getAllCarSeatsModification() {
        return carDao.getAllCarSeatsModification();
    }
}
