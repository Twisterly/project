package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class BodyTypeDaoImpl implements BodyTypeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(BodyType bodyType) {
        sessionFactory.getCurrentSession().saveOrUpdate(bodyType);
    }

    @Override
    public BodyType findById(long id) {
        return sessionFactory.getCurrentSession().get(BodyType.class, id);
    }

    @Override
    public void update(BodyType bodyType) {
        create(bodyType);

    }

    @Override
    public void delete(BodyType bodyType) {
        BodyType loadedBodyType =
                sessionFactory.getCurrentSession().load(BodyType.class,
                        bodyType.getId());
        sessionFactory.getCurrentSession().delete(loadedBodyType);

    }

    @Override
    public List<String> findAllBodyTypeNames() {
        String query = "SELECT b.bodyTypeName FROM BodyType AS b";
        return sessionFactory.getCurrentSession().createQuery(query,
                String.class).list();
    }

    @Override
    public List<BodyType> findAll() {
        String query = "FROM BodyType";
        return sessionFactory.getCurrentSession().createQuery(query,
                BodyType.class).list();
    }

    @Override
    public boolean isAlreadyExists(BodyType bodyType) {
        String query = "From BodyType B WHERE B.bodyTypeName='" + bodyType.getBodyTypeName() +"'";
        List<BodyType> bodyTypes = sessionFactory.getCurrentSession().createQuery(query,
                BodyType.class).list();
        if(bodyTypes.size() == 0){
            return false;
        } else
            return true;
    }
}
