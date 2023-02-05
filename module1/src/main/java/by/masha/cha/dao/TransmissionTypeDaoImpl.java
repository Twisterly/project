package by.masha.cha.dao;

import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.model.TransmissionType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TransmissionTypeDaoImpl implements TransmissionTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(TransmissionType transmissionType) {
        sessionFactory.getCurrentSession().saveOrUpdate(transmissionType);
    }

    @Override
    public TransmissionType findById(long id) {
        return sessionFactory.getCurrentSession().get(TransmissionType.class,
                id);
    }

    @Override
    public void update(TransmissionType transmissionType) {
        create(transmissionType);
    }

    @Override
    public void delete(TransmissionType transmissionType) {
        TransmissionType loadedTransmissionType =
                sessionFactory.getCurrentSession().load(TransmissionType.class,
                        transmissionType.getId());
        sessionFactory.getCurrentSession().delete(loadedTransmissionType);
    }

    @Override
    public List<TransmissionType> findAll() {
        String query = "FROM TransmissionType";
        return sessionFactory.getCurrentSession().createQuery(query,
                TransmissionType.class).list();
    }

    @Override
    public List<String> findAllTransmissionTypeNames() {
        String query = "SELECT t.transmissionTypeName FROM TransmissionType " +
                "AS t";
        return sessionFactory.getCurrentSession().createQuery(query,
                String.class).list();
    }

    @Override
    public boolean isAlreadyExists(TransmissionType transmissionType) {
        String query = "From TransmissionType T WHERE T" +
                ".transmissionTypeName='" + transmissionType.getTransmissionTypeName() + "'";
        List<TransmissionType> transmissionTypes =
                sessionFactory.getCurrentSession().createQuery(query,
                TransmissionType.class).list();
        if (transmissionTypes.size() == 0) {
            return false;
        } else
            return true;
    }

}
