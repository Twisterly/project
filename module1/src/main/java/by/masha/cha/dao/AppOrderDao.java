package by.masha.cha.dao;

import by.masha.cha.model.AppOrder;

import java.util.List;

public interface AppOrderDao {

    void create(AppOrder appOrder);

    AppOrder findById(String id);

    void update(AppOrder appOrder);

    void delete(AppOrder appOrder);

    List<AppOrder> findAll();

    List<AppOrder> findAllByUserId(String id);

    List<AppOrder> findAllActiveByCarId(String id);

    List<AppOrder> getPageForUser(String appUserId, Integer pageSize, Integer pageNumber);
    Long getCountForUser(String appUserId);

    List<AppOrder> getPageForAdmin(Integer pageSize, Integer pageNumber);
    Long getCountForAdmin();


}
