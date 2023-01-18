package by.masha.cha.service;

import by.masha.cha.dao.FuelTypeDao;
import by.masha.cha.dao.TransmissionTypeDao;
import by.masha.cha.model.FuelType;
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
        transmissionTypeDao.create(transmissionType);
    }

    public List<TransmissionType> getAll() {
        return transmissionTypeDao.findAll();
    }

}
