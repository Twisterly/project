package by.masha.cha.service;

import by.masha.cha.dao.AppOrderDao;
import by.masha.cha.model.AppOrder;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

    public AppOrder findById(String id) {
        return appOrderDao.findById(id);
    }

    public AppOrder findLastOrder() {
        return appOrderDao.findLastOrder();
    }

    public List<AppOrder> findAllByUserId(String userId) {
        return appOrderDao.findAllByUserId(userId);
    }

    public List<AppOrder> findAllByCarId(String carId) {
        return appOrderDao.findAllByUserId(carId);
    }

    public boolean isReserved(List<AppOrder> appOrders, LocalDate startDate,
                              LocalDate endDate) {
        List<LocalDate> bookedDates = new ArrayList<>();
        for (AppOrder order : appOrders) {
            LocalDate firstDate = order.getStartDate().toLocalDate();
            LocalDate secondDate = order.getEndDate().toLocalDate();
            while (firstDate.isBefore(secondDate)) {
                bookedDates.add(firstDate);
               firstDate = firstDate.plusDays(1);
            }
            bookedDates.add(secondDate);
        }
        List<LocalDate> desiredDates = new ArrayList<>();
        while (startDate.isBefore(endDate)) {
            desiredDates.add(startDate);
            startDate = startDate.plusDays(1);
        }
        desiredDates.add(endDate);

//        System.out.println("Reserved dates");
//        for (LocalDate localDate : bookedDates) {
//            System.out.println(localDate);
//        }
//        System.out.println("Desired dates");
//        for (LocalDate localDate : desiredDates) {
//            System.out.println(localDate);
//        }

        for (LocalDate localDate : desiredDates) {
            if (bookedDates.stream().anyMatch(localDate::equals)) {
                return true;
            }
        }
        return false;
    }
}

