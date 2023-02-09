package by.masha.cha.dao;

import by.masha.cha.model.*;
import com.mchange.lang.IntegerUtils;
import com.sun.xml.bind.v2.TODO;
import net.bytebuddy.matcher.StringMatcher;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;


@Repository
@Transactional
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void create(Car car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public Car findById(String id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public void update(Car car) {
        create(car);

    }

    @Override
    public void delete(Car car) {
        Car loadedCar =
                sessionFactory.getCurrentSession().load(Car.class,
                        car.getId());
        sessionFactory.getCurrentSession().delete(loadedCar);
    }


    @Override
    public List<Car> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Car",
                Car.class).list();
    }

    @Override
    public List<Car> findAllByBrandName(String name) {
        String brandQuery = "FROM Brand B WHERE B.brandName='" + name + "'";
        List<Brand> brands =
                sessionFactory.getCurrentSession().createQuery(brandQuery,
                        Brand.class).list();
        Brand brand = brands.get(0);
        String carQuery =
                "FROM Car C WHERE brand='" + brand.getId() + "'";
        return sessionFactory.getCurrentSession().createQuery(carQuery,
                Car.class).list();
    }

    @Override
    public List<Car> findAllByClimateControl(boolean climateControl) {
        StringBuilder query = new StringBuilder("FROM Car C WHERE ");
        String climateControlQuery =
                "FROM Car C WHERE C.climateControl='" + BooleanUtils.toInteger(climateControl) + "'";
        return
                sessionFactory.getCurrentSession().createQuery(climateControlQuery,
                        Car.class).list();


    }


    @Override
    public List<Car> findCarByFilter(CarFilter carFilter, Integer pageSize,
                                     Integer pageNumber) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Car> criteria = criteriaBuilder.createQuery(Car.class);
        Root<Car> cars = criteria.from(Car.class);
        List<Predicate> predicates = new ArrayList<>();
        if (!(carFilter.getBrand().equals("")) && !(carFilter.getBrand().equals("null"))) {
            predicates.add(criteriaBuilder.equal(cars.get("brand").get(
                    "brandName"), carFilter.getBrand()));
        }
        if (!(carFilter.getModelDetail().equals("")) && !(carFilter.getModelDetail().equals("null"))) {
            predicates.add(criteriaBuilder.equal(cars.get("modelDetail").get(
                    "modelName"), carFilter.getModelDetail()));
        }
        if (!(carFilter.getFuelType().equals("")) && !(carFilter.getFuelType().equals("null"))) {
            predicates.add(criteriaBuilder.equal(cars.get("fuelType").get(
                    "fuelTypeName"), carFilter.getFuelType()));
        }
        if (!(carFilter.getTransmissionType().equals("")) && !(carFilter.getTransmissionType().equals("null"))) {
            predicates.add(criteriaBuilder.equal(cars.get("transmissionType").get("transmissionTypeName"), carFilter.getTransmissionType()));
        }
        if (!(carFilter.getDoors().equals("")) && !(carFilter.getDoors().equals("null"))) {
            predicates.add(criteriaBuilder.equal(cars.get("doors"),
                    Integer.parseInt(carFilter.getDoors())));
        }
        if (!(carFilter.getSeats().equals("")) && !(carFilter.getSeats().equals("null"))) {
            predicates.add(criteriaBuilder.equal(cars.get("seats"),
                    Integer.parseInt(carFilter.getSeats())));
        }
        criteria.select(cars).where(predicates.toArray(Predicate[]::new));
        Query<Car> query =
                sessionFactory.getCurrentSession().createQuery(criteria);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return query.list();


    }

    @Override
    public List<Car> findAllByUserId(String userId) {
        String query = "From AppOrder ao WHERE ao.appUser='" + userId +
                "' ";
        List<AppOrder> appOrders =
                sessionFactory.getCurrentSession().createQuery(query,
                        AppOrder.class).list();
        List<Car> carList = new ArrayList<>();
        for (AppOrder order : appOrders) {
            carList.add(order.getCar());
        }
        return carList;
    }

    @Override
    public List<Car> findAllByLimit(Integer limit, Integer offset) {
        String query = "From Car c ORDER BY id LIMIT '" + limit + "' " +
                "OFFSET " +
                "'" + offset + "'";
        List<Car> cars =
                sessionFactory.getCurrentSession().createQuery(query,
                        Car.class).list();
        return cars;
    }

    public List<Car> findAllAndSortByYear() {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(Car.class)
                        .addOrder(Order.asc("year"));
        return criteria.list();
    }

    public List<Car> getPage(Integer pageSize, Integer pageNumber) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(Car.class).addOrder(Order.asc("year"));
        criteria.setFirstResult(pageNumber * pageSize);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }


    public Long getCount() {
        Criteria criteriaCount =
                sessionFactory.getCurrentSession().createCriteria(Car.class);
        criteriaCount.setProjection(Projections.rowCount());
        return (Long) criteriaCount.uniqueResult();

    }

    public List<String> getAllCarDoorsModification() {
        List<String> result = new ArrayList<>();
        List<Car> cars = sessionFactory.getCurrentSession().createQuery(
                "from" +
                        " Car",
                Car.class).list();
        for (Car car : cars) {
            result.add(car.getDoors().toString());
        }
        return result.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getAllCarSeatsModification() {
        List<String> result = new ArrayList<>();
        List<Car> cars = sessionFactory.getCurrentSession().createQuery(
                "from" +
                        " Car",
                Car.class).list();
        for (Car car : cars) {
            result.add(car.getSeats().toString());
        }
        return result.stream()
                .distinct()
                .collect(Collectors.toList());
    }


}


