package by.masha.cha.dao;


import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BrandDaoImpl implements BrandDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Brand brand) {
        sessionFactory.getCurrentSession().saveOrUpdate(brand);
    }

    @Override
    public Brand findById(long id) {
        return sessionFactory.getCurrentSession().get(Brand.class, id);
    }

    @Override
    public void update(Brand brand) {
        create(brand);

    }

    @Override
    public void delete(Brand brand) {
        Brand loadedBrand =
                sessionFactory.getCurrentSession().load(Brand.class,
                        brand.getId());
        sessionFactory.getCurrentSession().delete(loadedBrand);

    }

    @Override
    public List<Brand> findAll() {
        String query = "FROM Brand";
        return sessionFactory.getCurrentSession().createQuery(query,
                Brand.class).list();
    }

    @Override
    public List<String> findAllBrandNames() {
        String query = "SELECT b.brandName FROM Brand AS b";
        return sessionFactory.getCurrentSession().createQuery(query,
                String.class).list();
    }

    @Override
    public Brand findByBrandName(String name) {
        String query = "FROM Brand B WHERE B.brandName='" + name +"'";
        List<Brand> brands =
                sessionFactory.getCurrentSession().createQuery(query,
                        Brand.class).list();
        return brands.get(0);
    }

    @Override
    public boolean isAlreadyExists(Brand brand) {
        String query = "From Brand B WHERE B.brandName='" + brand.getBrandName() +"'";
        List<Brand> brands = sessionFactory.getCurrentSession().createQuery(query,
                Brand.class).list();
        if(brands.size() == 0){
            return false;
        } else
        return true;
    }

    @Override
    public Long getIdByBrandName(String brandName) {
        String query = "From Brand B WHERE B.brandName='" + brandName +"'";
        Brand brand = sessionFactory.getCurrentSession().createQuery(query, Brand.class).uniqueResult();
        return brand.getId();
    }

    public List<Brand> getPage(Integer pageSize, Integer pageNumber) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(Brand.class).addOrder(Order.asc("brandName"));
        criteria.setFirstResult(pageNumber * pageSize);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }


    public Long getCount() {
        Criteria criteriaCount =
                sessionFactory.getCurrentSession().createCriteria(Brand.class);
        criteriaCount.setProjection(Projections.rowCount());
        return (Long) criteriaCount.uniqueResult();

    }
}