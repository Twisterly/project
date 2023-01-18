package by.masha.cha.service;

import by.masha.cha.dao.ModelDetailDao;
import by.masha.cha.model.Brand;
import by.masha.cha.model.Car;
import by.masha.cha.model.ModelDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelDetailService {

    @Autowired
    private ModelDetailDao modelDetailDao;

    @Transactional
    public void add(ModelDetail modelDetail) {
        List<ModelDetail> modelDetails = new ArrayList<>();
        modelDetails.add(modelDetail);
        Brand brand = modelDetail.getBrand();
        if (brand.getModelDetails() == null) {
           modelDetail.getBrand().setModelDetails(modelDetails);
        }
        modelDetailDao.create(modelDetail);
    }

    public List<ModelDetail> getAll() {
        return modelDetailDao.findAll();
    }

}
