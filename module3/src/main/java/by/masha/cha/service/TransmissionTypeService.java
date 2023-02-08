package by.masha.cha.service;

import by.masha.cha.dao.TransmissionTypeDao;
import by.masha.cha.model.Brand;
import by.masha.cha.model.ModelDetail;
import by.masha.cha.model.TransmissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransmissionTypeService {

    @Autowired
    private TransmissionTypeDao transmissionTypeDao;

    @Transactional
    public void add(TransmissionType transmissionType) {
        transmissionType.setTransmissionTypeName(transmissionType.getTransmissionTypeName().toUpperCase());
        transmissionTypeDao.create(transmissionType);
    }

    public List<TransmissionType> getAll() {
        return transmissionTypeDao.findAll();
    }

    public boolean isAlreadyExists(TransmissionType transmissionType) {
        return transmissionTypeDao.isAlreadyExists(transmissionType);
    }

    public List<String> findAllTransmissionTypeNames() {
        return transmissionTypeDao.findAllTransmissionTypeNames();
    }

}
