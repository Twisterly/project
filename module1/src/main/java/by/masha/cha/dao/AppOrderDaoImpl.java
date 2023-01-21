package by.masha.cha.dao;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.BodyType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class AppOrderDaoImpl implements AppOrderDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(AppOrder appOrder) {
        sessionFactory.getCurrentSession().saveOrUpdate(appOrder);
    }

    @Override
    public AppOrder findById(String id) {
        return sessionFactory.getCurrentSession().get(AppOrder.class, id);
    }

    @Override
    public void update(AppOrder appOrder) {
        create(appOrder);
    }

    @Override
    public void delete(AppOrder appOrder) {
        AppOrder loadedAppOrder =
                sessionFactory.getCurrentSession().load(AppOrder.class,
                        appOrder.getId());
        sessionFactory.getCurrentSession().delete(loadedAppOrder);
    }

    @Override
    public List<AppOrder> findAll() {
        String query = "FROM AppOrder";
        return sessionFactory.getCurrentSession().createQuery(query,
                AppOrder.class).list();
    }
}
