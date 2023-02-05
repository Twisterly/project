package by.masha.cha.dao;

import by.masha.cha.model.*;
import com.mchange.lang.IntegerUtils;
import net.bytebuddy.matcher.StringMatcher;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


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

        Query query = sessionFactory.openSession().createQuery("From Car");
        query.setFirstResult(0);
        query.setMaxResults(5);
        List<Car> carList = query.list();
        return carList;
//        return sessionFactory.getCurrentSession().createQuery("from Car",
//                Car.class).list();
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
    public List<Car> findCarByFilter(CarFilter carFilter) {
        StringBuilder query = new StringBuilder("FROM Car C WHERE ");
        if (StringUtils.isNotEmpty(carFilter.getBrand())) {
            query.append("C.brand.brandName='" + carFilter.getBrand() + "' ");
        }
        if (StringUtils.isNotEmpty(carFilter.getModelDetail()) && StringUtils.isNotEmpty(carFilter.getBrand())) {
            query.append("AND C.modelDetail.modelName='" + carFilter.getModelDetail() + "' ");
        } else if (StringUtils.isNotEmpty(carFilter.getModelDetail()) && StringUtils.isEmpty(carFilter.getBrand())) {
            query.append("C.modelDetail.modelName='" + carFilter.getModelDetail() + "' ");
        }
        if (StringUtils.isNotEmpty(carFilter.getBodyType()) && (StringUtils.isNotEmpty(carFilter.getBrand()) || StringUtils.isNotEmpty(carFilter.getModelDetail()))) {
            query.append("AND C.bodyType='" + carFilter.getBodyType() + "' ");
        } else if (StringUtils.isNotEmpty(carFilter.getBodyType()) && (StringUtils.isEmpty(carFilter.getBrand()) && StringUtils.isEmpty(carFilter.getModelDetail()))) {
            query.append("C.bodyType='" + carFilter.getBodyType() + "' ");
        }
        if (StringUtils.isNotEmpty(carFilter.getDoors()) &&
                (StringUtils.isNotEmpty(carFilter.getBrand()) ||
                        StringUtils.isNotEmpty(carFilter.getModelDetail()) ||
                        StringUtils.isNotEmpty(carFilter.getBodyType()))) {
            Integer doors = IntegerUtils.parseInt(carFilter.getDoors(), 0);
            if (doors > 0) {
                query.append("AND C.seats='" + doors + "' ");
            }
        } else if (StringUtils.isNotEmpty(carFilter.getDoors()) &&
                (StringUtils.isEmpty(carFilter.getBrand()) &&
                        StringUtils.isEmpty(carFilter.getModelDetail()) &&
                        StringUtils.isEmpty(carFilter.getBodyType()))) {
            Integer doors = IntegerUtils.parseInt(carFilter.getDoors(), 0);
            if (doors > 0) {
                query.append("C.seats='" + doors + "' ");
            }
        }
        if (StringUtils.isNotEmpty(carFilter.getSeats()) &&
                (StringUtils.isNotEmpty(carFilter.getDoors()) ||
                        StringUtils.isNotEmpty(carFilter.getBrand()) ||
                        StringUtils.isNotEmpty(carFilter.getModelDetail()) ||
                        StringUtils.isNotEmpty(carFilter.getBodyType()))) {
            Integer seats = IntegerUtils.parseInt(carFilter.getSeats(), 0);
            if (seats > 0) {
                query.append("AND C.seats='" + seats + "' ");
            }
        } else if (StringUtils.isNotEmpty(carFilter.getSeats()) &&
                (StringUtils.isEmpty(carFilter.getDoors()) &&
                        StringUtils.isEmpty(carFilter.getBrand()) &&
                        StringUtils.isEmpty(carFilter.getModelDetail()) &&
                        StringUtils.isEmpty(carFilter.getBodyType()))) {
            Integer seats = IntegerUtils.parseInt(carFilter.getSeats(), 0);
            if (seats > 0) {
                query.append("C.seats='" + seats + "' ");
            }
        }
        if (StringUtils.isNotEmpty(carFilter.getTransmissionType()) &&
                ((StringUtils.isEmpty(carFilter.getSeats()) &&
                        StringUtils.isEmpty(carFilter.getDoors()) &&
                        StringUtils.isEmpty(carFilter.getBrand()) &&
                        StringUtils.isEmpty(carFilter.getModelDetail()) &&
                        StringUtils.isEmpty(carFilter.getBodyType())))) {
            query.append("C.transmissionType.transmissionTypeName='" + carFilter.getTransmissionType() + "' ");
        } else if (StringUtils.isNotEmpty(carFilter.getTransmissionType()) &&
                (StringUtils.isNotEmpty(carFilter.getSeats()) ||
                        StringUtils.isNotEmpty(carFilter.getDoors()) ||
                        StringUtils.isNotEmpty(carFilter.getBrand()) ||
                        StringUtils.isNotEmpty(carFilter.getModelDetail()) ||
                        StringUtils.isNotEmpty(carFilter.getBodyType()))) {
            query.append("AND C.transmissionType.transmissionTypeName='" + carFilter.getTransmissionType() + "' ");
        }
        if (StringUtils.isNotEmpty(carFilter.getFuelType()) &&
                (StringUtils.isEmpty(carFilter.getTransmissionType()) &&
                        StringUtils.isEmpty(carFilter.getSeats()) &&
                        StringUtils.isEmpty(carFilter.getDoors()) &&
                        StringUtils.isEmpty(carFilter.getBrand()) &&
                        StringUtils.isEmpty(carFilter.getModelDetail()) &&
                        StringUtils.isEmpty(carFilter.getBodyType()))) {
            query.append("C.fuelType.fuelTypeName='" + carFilter.getFuelType() + "' ");
        } else if (StringUtils.isNotEmpty(carFilter.getFuelType()) &&
                (StringUtils.isNotEmpty(carFilter.getTransmissionType()) ||
                        StringUtils.isNotEmpty(carFilter.getSeats()) ||
                        StringUtils.isNotEmpty(carFilter.getDoors()) ||
                        StringUtils.isNotEmpty(carFilter.getBrand()) ||
                        StringUtils.isNotEmpty(carFilter.getModelDetail()) ||
                        StringUtils.isNotEmpty(carFilter.getBodyType()))) {
            query.append("AND C.fuelType.fuelTypeName='" + carFilter.getFuelType() + "' ");
        }
        if (StringUtils.isNotEmpty(carFilter.getClimateControl()) &&
                (StringUtils.isEmpty(carFilter.getFuelType()) &&
                        StringUtils.isEmpty(carFilter.getTransmissionType()) &&
                        StringUtils.isEmpty(carFilter.getSeats()) &&
                        StringUtils.isEmpty(carFilter.getDoors()) &&
                        StringUtils.isEmpty(carFilter.getBrand()) &&
                        StringUtils.isEmpty(carFilter.getModelDetail()) &&
                        StringUtils.isEmpty(carFilter.getBodyType()))) {
            query.append("C.climateControl='" + BooleanUtils.toInteger(Boolean.valueOf(carFilter.getClimateControl())) + "' ");
        } else if (StringUtils.isNotEmpty(carFilter.getClimateControl()) &&
                (StringUtils.isNotEmpty(carFilter.getFuelType()) ||
                        StringUtils.isNotEmpty(carFilter.getTransmissionType()) ||
                        StringUtils.isNotEmpty(carFilter.getSeats()) ||
                        StringUtils.isNotEmpty(carFilter.getDoors()) ||
                        StringUtils.isNotEmpty(carFilter.getBrand()) ||
                        StringUtils.isNotEmpty(carFilter.getModelDetail()) ||
                        StringUtils.isNotEmpty(carFilter.getBodyType()))) {
            query.append("AND C.climateControl='" + BooleanUtils.toInteger(Boolean.valueOf(carFilter.getClimateControl())) + "' ");
        }
        return
                sessionFactory.getCurrentSession().
                        createQuery(query.toString(), Car.class).list();

    }

    @Override
    public List<Car> findAllByUserId(String userId) {
        String query = "From AppOrder inner join Car on " +
                "appUser.id='" + userId + "' ";
        return sessionFactory.getCurrentSession()
                .createQuery(query, Car.class).list();
    }


}


