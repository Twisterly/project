package by.masha.cha.service;

import by.masha.cha.dao.BodyTypeDao;
import by.masha.cha.model.BodyType;
import by.masha.cha.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BodyTypeService {

    @Autowired
    private BodyTypeDao bodyTypeDao;

    @Transactional
    public void add(BodyType bodyType) {
        bodyType.setBodyTypeName(bodyType.getBodyTypeName().toUpperCase());
        bodyTypeDao.create(bodyType);
    }

    public List<BodyType> getAll() {
        return bodyTypeDao.findAll();
    }

    public List<String> findAllBodyTypeNames(){return bodyTypeDao.findAllBodyTypeNames();}

    public boolean isAlreadyExists(BodyType bodyType){
        return bodyTypeDao.isAlreadyExists(bodyType);
    }

    public BodyType findById(long id){
        return bodyTypeDao.findById(id);
    }

}
