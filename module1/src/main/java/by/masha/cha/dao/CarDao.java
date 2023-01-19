package by.masha.cha.dao;

import by.masha.cha.model.Car;

import java.util.List;

public interface CarDao {

    void create(Car car);

    Car findById(long id);

    void update(Car car);

    void delete(Car car);

    List<Car> findAll();

    List<Car> findAllByBrandName(String name);



}