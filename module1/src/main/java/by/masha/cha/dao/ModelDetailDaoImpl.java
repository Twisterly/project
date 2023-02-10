package by.masha.cha.dao;

import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.model.ModelDetail;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ModelDetailDaoImpl implements ModelDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(ModelDetail modelDetail) {
        sessionFactory.getCurrentSession().saveOrUpdate(modelDetail);
    }

    @Override
    public ModelDetail findById(long id) {
        return sessionFactory.getCurrentSession().get(ModelDetail.class, id);
    }

    @Override
    public void update(ModelDetail modelDetail) {
        create(modelDetail);

    }

    @Override
    public void delete(ModelDetail modelDetail) {
        ModelDetail loadedModelDetail =
                sessionFactory.getCurrentSession().load(ModelDetail.class,
                        modelDetail.getId());
        sessionFactory.getCurrentSession().delete(loadedModelDetail);
    }

    @Override
    public List<String> findAllModelNames() {
        String query = "SELECT m.modelName FROM ModelDetail AS m";
        return sessionFactory.getCurrentSession().createQuery(query,
                String.class).list();
    }

    @Override
    public List<ModelDetail> findAll() {
        String query = "FROM ModelDetail";
        return sessionFactory.getCurrentSession().createQuery(query,
                ModelDetail.class).list();
    }

    @Override
    public List<ModelDetail> findAllModelsByBrandName(String name) {
        String brandQuery = "FROM Car C WHERE C.brand.brandName='" + name + "'";
        List<Car> cars =
                sessionFactory.getCurrentSession().createQuery(brandQuery,
                        Car.class).list();
        List<ModelDetail> modelDetailsList = new ArrayList<>();
        for(Car car : cars ){
          modelDetailsList.add(car.getModelDetail());
        }
       return modelDetailsList;
    }

    @Override
    public boolean isAlreadyExists(ModelDetail modelDetail) {
        String query =
                "From ModelDetail M WHERE M.modelName='" + modelDetail.getModelName() + "'";
        List<ModelDetail> modelDetails =
                sessionFactory.getCurrentSession().createQuery(query,
                ModelDetail.class).list();
        if (modelDetails.size() == 0) {
            return false;
        } else
            return true;
    }

    public List<ModelDetail> getPage(Integer pageSize, Integer pageNumber) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(ModelDetail.class).addOrder(Order.asc("modelName"));
        criteria.setFirstResult(pageNumber * pageSize);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }


    public Long getCount() {
        Criteria criteriaCount =
                sessionFactory.getCurrentSession().createCriteria(ModelDetail.class);
        criteriaCount.setProjection(Projections.rowCount());
        return (Long) criteriaCount.uniqueResult();

    }

}
