package by.masha.cha.service;

import by.masha.cha.dao.AppOrderDao;
import by.masha.cha.model.AppOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public AppOrder findById(String id) {
        return appOrderDao.findById(id);
    }

    public AppOrder findLastOrder() {
        return appOrderDao.findLastOrder();
    }

    public void delete(AppOrder appOrder) {
        appOrderDao.delete(appOrder);
    }

    public AppOrder update(Date startDate,Date endDate,
                       String carId, String appOrderId) {
        AppOrder oldAppOrder = appOrderDao.findById(appOrderId);
//        if (!(oldAppOrder.getStartDate().toLocalDate().equals(appOrder.getStartDate()))) {
//            oldAppOrder.setStartDate(appOrder.getStartDate());
//        }
//        if (!(oldAppOrder.getEndDate().toLocalDate().equals(appOrder.getEndDate()))) {
//            oldAppOrder.setEndDate(appOrder.getEndDate());
//        }
//        if (!(oldAppOrder.getEndDate().toLocalDate().equals(appOrder.getEndDate()))) {
//            oldAppOrder.setEndDate(appOrder.getEndDate());
//        }
//        if (!(oldAppOrder.getTotalSum() == appOrder.getTotalSum())) {
//            oldAppOrder.setTotalSum(appOrder.getTotalSum());
//        }
//        if (!(oldAppOrder.getCar().getId().equals(appOrder.getCar().getId()))) {
//            oldAppOrder.setCar(appOrder.getCar());
//        }
//        if (!(oldAppOrder.getTotalSum() == appOrder.getTotalSum())) {
//            oldAppOrder.setTotalSum(appOrder.getTotalSum());
//        }
//        if (!(oldAppOrder.getTimeOfOrder().equals(appOrder.getTimeOfOrder()))) {
//            oldAppOrder.setTimeOfOrder(appOrder.getTimeOfOrder());
//        }
       appOrderDao.update(oldAppOrder);
        return oldAppOrder;
    }

    public List<AppOrder> findAllByUserId(String userId) {
        return appOrderDao.findAllByUserId(userId);
    }

    public List<AppOrder> findAllByCarId(String carId) {
        return appOrderDao.findAllByCarId(carId);
    }

    public boolean isCorrectDates(LocalDate startDate, LocalDate endDate) {
        if (startDate.isBefore(endDate) && startDate.isAfter(LocalDate.now())) {
            return true;
        } else
            return false;
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

        for (LocalDate localDate : desiredDates) {
            if (bookedDates.stream().anyMatch(localDate::equals)) {
                return true;
            }
        }
        return false;
    }

//    public List<Date> freeDays(List<AppOrder> appOrders, LocalDate startDate,
//                               LocalDate endDate) {
//        List<LocalDate> bookedDates = new ArrayList<>();
//        for (AppOrder order : appOrders) {
//            LocalDate firstDate = order.getStartDate().toLocalDate();
//            LocalDate secondDate = order.getEndDate().toLocalDate();
//            while (firstDate.isBefore(secondDate)) {
//                bookedDates.add(firstDate);
//                firstDate = firstDate.plusDays(1);
//            }
//            bookedDates.add(secondDate);
//        }
//        List<Date> freeDates = new ArrayList<>();
//        while (startDate.isBefore(endDate)) {
//            freeDates.add(Date.valueOf(startDate.minusDays(15)));
//            startDate = startDate.plusDays(1);
//        }
//        while (endDate.isBefore(endDate.plusDays(15))) {
//            freeDates.add(Date.valueOf(endDate));
//            endDate = endDate.plusDays(1);
//        }
//        for (Date date : freeDates) {
//            if (bookedDates.stream().anyMatch(date.toLocalDate()::equals)) {
//                freeDates.remove(date);
//            }
//        }
//        return freeDates;
//    }

    public boolean isAvailableDate(List<AppOrder> appOrders, LocalDate date) {
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
        if (bookedDates.stream().anyMatch(date::equals)) {
            return false;
        } else
            return true;
    }

    public String appOrderStatus(AppOrder appOrder) {
        LocalDate startDate = appOrder.getStartDate().toLocalDate();
        LocalDate endDate = appOrder.getEndDate().toLocalDate();
        if (startDate.isAfter(LocalDate.now())) {
            return "future";
        }
        if (startDate.isBefore(LocalDate.now()) &&
                endDate.isBefore(LocalDate.now())) {
            return "past";
        } else return "in process";
    }

    public List<AppOrder> getPageForUser(String appUserId, Integer pageSize,
                                         Integer pageNumber) {
        return appOrderDao.getPageForUser(appUserId, pageSize, pageNumber);
    }

    public Long getCountForUser(String appUserId) {
        return appOrderDao.getCountForUser(appUserId);

    }

    public List<Integer> getPagesList(Integer pageCount) {
        List<Integer> pages = new ArrayList<>();
        for (int i = 1; i < pageCount + 1; i++) {
            pages.add(i);
        }
        return pages;
    }

    public List<AppOrder> getPageForAdmin(Integer pageSize,
                                          Integer pageNumber) {
        return appOrderDao.getPageForAdmin(pageSize, pageNumber);
    }

    public Long getCountForAdmin() {
        return appOrderDao.getCountForAdmin();

    }

    public List<Date> findAppOrderDates(AppOrder appOrder) {
        List<Date> result = new ArrayList<>();
        LocalDate firstDate = appOrder.getStartDate().toLocalDate();
        LocalDate secondDate = appOrder.getEndDate().toLocalDate();
        while (firstDate.isBefore(secondDate)) {
            result.add(Date.valueOf(firstDate));
            firstDate = firstDate.plusDays(1);
        }
        result.add(Date.valueOf(secondDate));
        return result;
    }

    public List<AppOrder> findAppOrdersByDates(Date startDate, Date endDate) {
        List<AppOrder> appOrders = appOrderDao.findAll();
        List<AppOrder> result = new ArrayList<>();
        for (AppOrder appOrder : appOrders) {
            if ((findAppOrderDates(appOrder).contains(startDate) ||
                    (findAppOrderDates(appOrder).contains(endDate)))){
                result.add(appOrder);
                continue;
            }
        }
        return result;
    }

}




