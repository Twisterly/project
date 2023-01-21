package by.masha.cha.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "t_app_order")
@Getter
@Setter
public class AppOrder {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "end_time")
    private Time endTime;

    @Column(name="total_sum")
    private double totalSum;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "car_orders",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "car_id"))
//    private List<Car> cars;
}
