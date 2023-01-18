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
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        Brand brand = car.getBrand();
        if (brand.getCar() == null) {
            car.getBrand().setCar(cars);
        }
        BodyType bodyType = car.getBodyType();
        if (bodyType.getCar() == null){
            car.getBodyType().setCar(cars);
        }
        FuelType fuelType = car.getFuelType();
        if (fuelType.getCar() == null){
            car.getFuelType().setCar(cars);
        }
        TransmissionType transmissionType = car.getTransmissionType();
        if (transmissionType.getCar() == null){
            car.getTransmissionType().setCar(cars);
        }
        if (car.getCarPhoto() == null) {
            CarPhoto carPhoto = new CarPhoto();
            carPhoto.setCar(cars);
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
}
