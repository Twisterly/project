package by.masha.cha.service;

import by.masha.cha.dao.AppOrderDao;
import by.masha.cha.model.AppOrder;
import by.masha.cha.model.BodyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppOrderService {

    @Autowired
    private AppOrderDao appOrderDao;

    @Transactional
    public void add(AppOrder appOrder) {
        appOrderDao.create(appOrder);
    }

    public List<AppOrder> getAll() {
        return appOrderDao.findAll();
    }
}
