package by.masha.cha.dao;

import by.masha.cha.model.BodyType;


import java.util.List;

public interface BodyTypeDao {

    void create(BodyType bodyType);

    BodyType findById(long id);

    void update(BodyType bodyType);

    void delete(BodyType bodyType);

    List<String> findAllBodyTypeNames();

    public List<BodyType> findAll();
}
