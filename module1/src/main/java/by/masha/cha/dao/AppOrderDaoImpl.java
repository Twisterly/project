package by.masha.cha.dao;

import by.masha.cha.model.AppOrder;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.Car;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppOrderDaoImpl implements AppOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(AppOrder appOrder) {
        Car car = sessionFactory.getCurrentSession().get(Car.class,
                appOrder.getCar().getId());
        double totalSum =
                car.getPrice() * (appOrder.getEndDate().toLocalDate().getDayOfYear()
                        - appOrder.getStartDate().toLocalDate().getDayOfYear());
        appOrder.setTotalSum(totalSum);
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

    @Override
    public List<AppOrder> findAllByUserId(String id) {
        String query = "From AppOrder ao WHERE ao.appUser='" + id + "' ";
        return sessionFactory.getCurrentSession()
                .createQuery(query, AppOrder.class).list();


    }

    @Override
    public AppOrder findLastOrder() {
        String query = "From AppOrder AO ORDER BY AO.id DESC LIMIT 1";
        return (AppOrder) sessionFactory.getCurrentSession()
                .createQuery(query, AppOrder.class);
    }

    @Override
    public List<AppOrder> findAllByCarId(String id) {
        String query = "From AppOrder ao WHERE ao.car='" + id + "' ";
        return sessionFactory.getCurrentSession()
                .createQuery(query, AppOrder.class).list();
    }

    public List<AppOrder> getPageForUser(String appUserId, Integer pageSize, Integer pageNumber) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(AppOrder.class).add(Restrictions.eq("appUser.id", appUserId)).addOrder(Order.desc("startDate"));
        criteria.setFirstResult(pageNumber * pageSize);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }

    public Long getCountForUser(String appUserId) {
        Criteria criteriaCount =
                sessionFactory.getCurrentSession().createCriteria(AppOrder.class).add(Restrictions.eq("appUser.id", appUserId));
        criteriaCount.setProjection(Projections.rowCount());
        return (Long) criteriaCount.uniqueResult();

    }

    public List<AppOrder> getPageForAdmin(Integer pageSize, Integer pageNumber) {
        Criteria criteria =
                sessionFactory.getCurrentSession().createCriteria(AppOrder.class).addOrder(Order.desc("startDate"));
        criteria.setFirstResult(pageNumber * pageSize);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }

    public Long getCountForAdmin() {
        Criteria criteriaCount =
                sessionFactory.getCurrentSession().createCriteria(AppOrder.class);
        criteriaCount.setProjection(Projections.rowCount());
        return (Long) criteriaCount.uniqueResult();
    }




}
