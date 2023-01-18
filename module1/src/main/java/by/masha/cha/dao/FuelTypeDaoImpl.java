package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.FuelType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FuelTypeDaoImpl implements FuelTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(FuelType fuelType) {
        sessionFactory.getCurrentSession().saveOrUpdate(fuelType);
    }

    @Override
    public FuelType findById(long id) {
        return sessionFactory.getCurrentSession().get(FuelType.class, id);
    }

    @Override
    public void update(FuelType fuelType) {
        create(fuelType);

    }

    @Override
    public void delete(FuelType fuelType) {
        FuelType loadedFuelType =
                sessionFactory.getCurrentSession().load(FuelType.class,
                        fuelType.getId());
        sessionFactory.getCurrentSession().delete(loadedFuelType);

    }

    @Override
    public List<String> findAllFuelTypeNames() {
        String query = "SELECT f.fuelTypeName FROM FuelType AS f";
        return sessionFactory.getCurrentSession().createQuery(query,
                String.class).list();
    }

    @Override
    public List<FuelType> findAll() {
        String query = "FROM FuelType";
        return sessionFactory.getCurrentSession().createQuery(query,
                FuelType.class).list();
    }
}

