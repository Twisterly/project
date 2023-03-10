package by.masha.cha.dao;

import by.masha.cha.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.sql.Date;
import java.util.List;

public interface CarDao {

    void create(Car car);

    Car findById(String id);

    void update(Car car);

    void delete(Car car);

    List<Car> findAll();

    List<Car> findAllByBrandName(String name);

    List<Car> findAllByClimateControl(boolean isClimateControl);

    List<Car> findCarByFilter(CarFilter carFilter, Integer pageSize, Integer pageNumber);

    List<Car> findAllByUserId(String userId);

    List<Car> findAllByLimit(Integer limit, Integer offset);

    List<Car> findAllAndSortByYear();

    List<Car> getPage(Integer pageSize, Integer pageNumber);

    List<Car> getPageNotActiveCars(Integer pageSize, Integer pageNumber);
    Long getCount();

    Long getCountNotActiveCars();

    List<String> getAllCarDoorsModification();

    List<String> getAllCarSeatsModification();

    boolean isUnique(String regNum);
















}