package by.masha.cha.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "app_user")
@Getter
@Setter
public class AppUser {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "user_first_name")
    private String firstName;

    @Column(name = "user_last_name")
    private String lastName;
    @Column(name = "user_birth_date")
    private Date birthDate;

    @Column(name = "USER_ROLE")
    private String role = "USER";
}