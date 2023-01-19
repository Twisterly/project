package by.masha.cha.dao;

import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;

import java.util.List;

public interface ModelDetailDao {

    void create(ModelDetail modelDetail);

    ModelDetail findById(long id);

    void update(ModelDetail modelDetail);

    void delete(ModelDetail modelDetail);

    List<String> findAllModelNames();

   List<ModelDetail> findAll();

    List<ModelDetail> findAllModelsByBrandName(String name);


}