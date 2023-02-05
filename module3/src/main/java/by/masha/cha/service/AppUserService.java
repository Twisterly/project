package by.masha.cha.service;

import by.masha.cha.dao.AppUserDao;
import by.masha.cha.model.AppUser;
import by.masha.cha.model.BodyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class
AppUserService {

    @Autowired
    AppUserDao appUserDao;

    public List<AppUser> findUserByUsername(String username) {
        System.out.println("Search for user: " + username);
        return appUserDao.findByUserName(username);
    }

    @Transactional
    public void add(AppUser appUser) {
        appUserDao.create(appUser);
    }

    public List<AppUser> getAll() {
        return appUserDao.findAll();
    }

    public AppUser findById(String id){return appUserDao.findById(id);}

    @Transactional
    public void update(AppUser appUser) {
        appUserDao.update(appUser);
    }

    public Integer isAlreadyExists(AppUser appUser){
        return appUserDao.isAlreadyExists(appUser);
    }



}
