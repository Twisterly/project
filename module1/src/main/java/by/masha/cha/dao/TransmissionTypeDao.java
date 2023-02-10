package by.masha.cha.dao;

import by.masha.cha.model.Brand;
import by.masha.cha.model.TransmissionType;

import java.util.List;

public interface TransmissionTypeDao {

    void create(TransmissionType transmissionType);

    TransmissionType findById(long id);

    void update(TransmissionType transmissionType);

    void delete(TransmissionType transmissionType);

    public List<TransmissionType> findAll();

    List<String> findAllTransmissionTypeNames();

    boolean isAlreadyExists(TransmissionType transmissionType);

}
