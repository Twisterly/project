package by.masha.cha.dao;

import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.model.ModelDetail;
import net.bytebuddy.matcher.StringMatcher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Car findById(long id) {
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
    public List<ModelDetail> findByModel(long modelId) {
        String query = "SELECT m.modelDetail FROM Car AS m WHERE id=" + modelId;
        return sessionFactory.getCurrentSession().createQuery(query,
                ModelDetail.class).list();

    }

}