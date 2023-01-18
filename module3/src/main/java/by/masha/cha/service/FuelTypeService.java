package by.masha.cha.service;

import by.masha.cha.dao.FuelTypeDao;
import by.masha.cha.model.FuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FuelTypeService {
    @Autowired
    private FuelTypeDao fuelTypeDao;

    @Transactional
    public void add(FuelType fuelType) {
       fuelTypeDao.create(fuelType);
    }

    public List<FuelType> getAll() {
        return fuelTypeDao.findAll();
    }

}
