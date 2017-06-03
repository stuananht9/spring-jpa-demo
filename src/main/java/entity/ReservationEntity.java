package entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by tuananh on 06/03/17.
 */
@Entity
@Table(name = "RESERVATION")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDate checkinDate;
    private LocalDate checkoutDate;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private RomEntity romEntity;
    //Contructor

    public ReservationEntity() {
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public RomEntity getRomEntity() {
        return romEntity;
    }

    public void setRomEntity(RomEntity romEntity) {
        this.romEntity = romEntity;
    }
}
