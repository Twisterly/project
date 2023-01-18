package by.masha.cha.dao;

import by.masha.cha.model.ModelDetail;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
