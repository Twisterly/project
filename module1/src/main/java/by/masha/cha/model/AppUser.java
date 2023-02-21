package by.masha.cha.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "t_app_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @Column(name = "app_user_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String password;
    @Column(name = "user_first_name")
    private String firstName;

    @Column(name = "user_last_name")
    private String lastName;
    @Column(name = "user_birth_date")
    private Date birthDate;

    @Column(name="user_email")
    private String email;

    @Column(name="user_phone_number")
    private String phoneNumber;
    @Column(name="user_gender")
    private String gender;

    @Column(name = "user_role")
    private String role;

    @OneToMany(mappedBy = "appUser")
    private List<AppOrder> appOrders;

}