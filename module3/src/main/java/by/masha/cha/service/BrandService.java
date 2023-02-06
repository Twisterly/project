package by.masha.cha.service;

import by.masha.cha.dao.BrandDao;
import by.masha.cha.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandDao brandDao;

    @Transactional
    public void add(Brand brand) {
        brandDao.create(brand);
    }

    public List<Brand> getAll() {
        return brandDao.findAll();
    }

    public List<String> findAllBrandNames() {
        return brandDao.findAllBrandNames();
    }

    public boolean isAlreadyExists(Brand brand){
        return brandDao.isAlreadyExists(brand);
    }

    public Brand findById(long id) {
        return brandDao.findById(id);
    }

}

