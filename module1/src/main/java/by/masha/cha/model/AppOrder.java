package by.masha.cha.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_app_order")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppOrder {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "total_sum")
    private double totalSum;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;
    @Column(name = "order_time")
    private Timestamp timeOfOrder;
    @Column(name = "cancellation")
    private boolean cancellation;

    @Column(name = "cancellation_time")
    private Timestamp timeOfCancellation;

}
