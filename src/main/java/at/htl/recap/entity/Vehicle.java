package at.htl.recap.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="V_VEHICLE")
@SequenceGenerator(
        name = "vehicleSeq",
        sequenceName = "VEHICLE_SEQ",
        initialValue = 1000)
public class Vehicle extends PanacheEntityBase {

    @Id
    @Column(name = "V_ID")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicleSeq"
    )
    Long id;

    @Column(name = "V_BRAND")
    String brand;

    @Column(name = "V_MODEL")
    String model;

    @Column(name = "V_CONSTRUCTION_YEAR")
    int constructionYear;

    public int age() {
        return LocalDate.now().getYear() - constructionYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s", brand, model);
    }
}
