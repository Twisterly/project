package by.masha.cha.dao;

import by.masha.cha.model.Car;
import by.masha.cha.model.CarFilter;

import java.awt.print.Pageable;
import java.util.List;

public interface CarDao {

    void create(Car car);

    Car findById(String id);

    void update(Car car);

    void delete(Car car);

    List<Car> findAll();

    List<Car> findAllByBrandName(String name);

    List<Car> findAllByClimateControl(boolean isClimateControl);

    List<Car> findCarByFilter(CarFilter carFilter);

    List<Car> findAllByUserId(String userId);






}