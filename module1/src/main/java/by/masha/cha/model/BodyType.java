package by.masha.cha.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_body_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyType {

    @Id
    @Column(name = "body_type_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "body_type_seq")
    @SequenceGenerator(name = "body_type_seq", sequenceName = "t_body_type_seq")
    private long id;

    @Column(name="body_type_name")
    private String bodyTypeName;

}
