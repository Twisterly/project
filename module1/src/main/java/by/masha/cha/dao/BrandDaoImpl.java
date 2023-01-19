package by.masha.cha.dao;


import by.masha.cha.model.Brand;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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
}