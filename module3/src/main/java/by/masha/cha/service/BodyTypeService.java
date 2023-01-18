package by.masha.cha.service;

import by.masha.cha.dao.BodyTypeDao;
import by.masha.cha.model.BodyType;
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
        bodyTypeDao.create(bodyType);
    }

    public List<BodyType> getAll() {
        return bodyTypeDao.findAll();
    }

}
