package by.masha.cha.dao;

import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.model.ModelDetail;

import java.util.List;

public interface CarDao {

    void create(Car car);

    Car findById(long id);

    void update(Car car);

    void delete(Car car);

    List<Car> findAll();

    List<ModelDetail> findByModel(long id);

}