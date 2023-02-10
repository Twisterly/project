package by.masha.cha.service;

import by.masha.cha.dao.ModelDetailDao;
import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


import java.util.List;

@Service
public class ModelDetailService {

    @Autowired
    private ModelDetailDao modelDetailDao;

    @Transactional
    public void add(ModelDetail modelDetail) {
        modelDetail.setModelName(modelDetail.getModelName().toUpperCase());
        modelDetailDao.create(modelDetail);
    }

    public List<ModelDetail> getAll() {
        return modelDetailDao.findAll();
    }

    public List<String> findAllModelNames() {
        return modelDetailDao.findAllModelNames();
    }

    public boolean isAlreadyExists(ModelDetail modelDetail) {
        return modelDetailDao.isAlreadyExists(modelDetail);
    }

    public List<ModelDetail> findAllModelsByBrandName(String name) {
        return modelDetailDao.findAllModelsByBrandName(name);
    }

    public ModelDetail findById(long id){
        return modelDetailDao.findById(id);
    }
}
