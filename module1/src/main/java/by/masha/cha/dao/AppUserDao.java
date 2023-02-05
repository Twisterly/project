package by.masha.cha.dao;

import by.masha.cha.model.AppUser;
import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;

import java.util.List;

public interface AppUserDao {


    List<AppUser> findByUserName(String username);

    void create(AppUser appUser);

    public List<AppUser> findAll();

    public AppUser findById(String id);

    void update(AppUser appUser);

    void delete(AppUser appUser);

    Integer isAlreadyExists(AppUser appUser);

}
