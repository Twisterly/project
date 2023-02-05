package by.masha.cha.dao;

import by.masha.cha.model.AppUser;
import by.masha.cha.model.BodyType;
import by.masha.cha.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppUserDaoImpl implements AppUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AppUser> findByUserName(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser au where au.username=:username",
                        AppUser.class)
                .setParameter("username", username)
                .list();
    }

    @Override
    public void create(AppUser appUser) {
        sessionFactory.getCurrentSession().saveOrUpdate(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        String query = "FROM AppUser";
        return sessionFactory.getCurrentSession().createQuery(query,
                AppUser.class).list();
    }

    @Override
    public AppUser findById(String id) {
        return sessionFactory.getCurrentSession().get(AppUser.class, id);
    }

    @Override
    public void update(AppUser appUser) {
        create(appUser);
    }

    @Override
    public void delete(AppUser appUser) {
        AppUser loadedAppUser =
                sessionFactory.getCurrentSession().load(AppUser.class,
                        appUser.getId());
        sessionFactory.getCurrentSession().delete(loadedAppUser);
    }

    @Override
    public Integer isAlreadyExists(AppUser appUser) {
        String query1 =
                "From AppUser A WHERE A.username='" + appUser.getUsername() + "'";
        List<AppUser> appUserNames =
                sessionFactory.getCurrentSession().createQuery(query1,
                        AppUser.class).list();
        String query2 =
                "From AppUser A WHERE A.email='" + appUser.getEmail() + "'";
        List<AppUser> appUserEmails =
                sessionFactory.getCurrentSession().createQuery(query2,
                        AppUser.class).list();
        String query3 =
                "From AppUser A WHERE A.phoneNumber='" + appUser.getPhoneNumber() + "'";
        List<AppUser> appUserPhoneNumber =
                sessionFactory.getCurrentSession().createQuery(query3,
                        AppUser.class).list();
        if (appUserNames.size() == 0 && appUserEmails.size() == 0 && appUserPhoneNumber.size() == 0) {
            return 1;
        } else if (appUserNames.size() == 0 && appUserEmails.size() != 0 && appUserPhoneNumber.size() == 0) {
            return 2;
        } else if (appUserNames.size() == 0 && appUserEmails.size() != 0 && appUserPhoneNumber.size() != 0) {
            return 3;
        } else if (appUserNames.size() == 0 && appUserEmails.size() == 0 && appUserPhoneNumber.size() != 0) {
            return 4;
        } else if (appUserNames.size() != 0 && appUserEmails.size() == 0 && appUserPhoneNumber.size() == 0) {
            return 5;
        } else if (appUserNames.size() != 0 && appUserEmails.size() != 0 && appUserPhoneNumber.size() == 0) {
            return 6;
        } else if (appUserNames.size() != 0 && appUserEmails.size() == 0 && appUserPhoneNumber.size() != 0) {
            return 7;
        } else
            return 8;
    }
}