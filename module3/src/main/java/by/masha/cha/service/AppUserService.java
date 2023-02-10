package by.masha.cha.service;

import by.masha.cha.dao.AppUserDao;
import by.masha.cha.model.AppUser;
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

    public AppUser findById(String id) {
        return appUserDao.findById(id);
    }

    @Transactional
    public void update(AppUser updatedAppUser, String userId) {
        AppUser appUser = appUserDao.findById(userId);
        if (!(updatedAppUser.getFirstName().equals(appUser.getFirstName()))){
            appUser.setFirstName(updatedAppUser.getFirstName());
        }
        if (!(updatedAppUser.getLastName().equals(appUser.getLastName()))){
            appUser.setLastName(updatedAppUser.getLastName());
        }
        if (!(updatedAppUser.getLastName().equals(appUser.getLastName()))){
            appUser.setLastName(updatedAppUser.getLastName());
        }
        if (!(updatedAppUser.getPassword().equals(appUser.getPassword()))){
            appUser.setPassword(updatedAppUser.getPassword());
        }
        if (!(updatedAppUser.getLastName().equals(appUser.getLastName()))){
            appUser.setLastName(updatedAppUser.getLastName());
        }
        if (!(updatedAppUser.getEmail().equals(appUser.getEmail()))){
            appUser.setEmail(updatedAppUser.getEmail());
        }
        if (!(updatedAppUser.getPhoneNumber().equals(appUser.getPhoneNumber()))){
            appUser.setPhoneNumber(updatedAppUser.getPhoneNumber());
        }
        appUserDao.update(appUser);
    }

    public Integer isAlreadyExists(AppUser appUser) {
        return appUserDao.isAlreadyExists(appUser);
    }

    public Integer isAlreadyExists(AppUser appUser, String appUserId){
        return appUserDao.isAlreadyExists(appUser, appUserId);
    }

    public Integer getRoleNum(AppUser appUser) {
        if (appUser.getRole().equals("ADMIN")) {
            return 1;
        }
        if (appUser.getRole().equals("USER")) {
            return 2;
        } else return 0;
    }

    public List<AppUser> getPage(Integer pageSize, Integer pageNumber) {
        return appUserDao.getPage(pageSize, pageNumber);
    }

    public Long getCount() {
        return appUserDao.getCount();
    }


}
