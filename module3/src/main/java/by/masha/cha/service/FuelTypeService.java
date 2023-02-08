package by.masha.cha.service;

import by.masha.cha.dao.FuelTypeDao;
import by.masha.cha.model.Brand;
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
       fuelType.setFuelTypeName(fuelType.getFuelTypeName().toUpperCase());
        fuelTypeDao.create(fuelType);
    }

    public List<FuelType> getAll() {
        return fuelTypeDao.findAll();
    }

    public List<String> findAllFuelTypeNames(){return  fuelTypeDao.findAllFuelTypeNames();}

    public boolean isAlreadyExists(FuelType fuelType){
        return fuelTypeDao.isAlreadyExists(fuelType);
    }

}
