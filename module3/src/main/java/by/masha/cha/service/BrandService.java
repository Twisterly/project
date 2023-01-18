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

}

