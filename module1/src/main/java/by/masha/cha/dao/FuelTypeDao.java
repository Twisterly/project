package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.FuelType;

import java.util.List;

public interface FuelTypeDao {

    void create(FuelType fuelType);

    FuelType findById(long id);

    void update(FuelType fuelType);

    void delete(FuelType fuelType);

    List<String> findAllFuelTypeNames();

    public List<FuelType> findAll();

    boolean isAlreadyExists(FuelType fuelType);
}
