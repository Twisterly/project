package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;

import java.util.List;

public interface BrandDao {

    void create(Brand brand);

    Brand findById(long id);

    void update(Brand brand);

    void delete(Brand brand);

    public List<Brand> findAll();

    List<String> findAllBrandNames();

    Brand findByBrandName(String name);

    boolean isAlreadyExists(Brand brand);

    Long getIdByBrandName(String brandName);

    List<Brand> getPage(Integer pageSize, Integer pageNumber);
    Long getCount();
}
