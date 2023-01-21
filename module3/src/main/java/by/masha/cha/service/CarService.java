package by.masha.cha.service;

import by.masha.cha.dao.CarDao;
import by.masha.cha.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarDao carDao;

    @Transactional
    public void add(Car car, byte[] photo) {
        Brand brand = car.getBrand();
        if (brand == null) {
            car.setBrand(new Brand());
        }
        FuelType fuelType = car.getFuelType();
        if (fuelType == null) {
            car.setFuelType(new FuelType());
        }
        TransmissionType transmissionType = car.getTransmissionType();
        if (transmissionType == null) {
            car.setTransmissionType(new TransmissionType());
        }
        BodyType bodyType = car.getBodyType();
        if (bodyType == null) {
            car.setBodyType(new BodyType());
        }
        if (car.getCarPhoto() == null) {
            CarPhoto carPhoto = new CarPhoto();
            carPhoto.setCar(car);
            carPhoto.setPhoto(photo);
            car.setCarPhoto(carPhoto);
        }

        carDao.create(car);

    }

    public List<Car> getAll() {
        return carDao.findAll();
    }

    public Car getById(long carId) {
        return carDao.findById(carId);
    }


    public List<Car> findCarByFilter(CarFilter carFilter) {
        List<Car> resultList = new ArrayList<>();
        return carDao.findCarByFilter(carFilter);

    }


}
