package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by tuananh on 06/03/17.
 */
@Entity
@Table(name = "ROM")
public class RomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int roomNumber;
    private String roomType;
    private double unitPrice;

    @OneToMany(mappedBy = "romEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<ReservationEntity> reservationeList;

    public RomEntity() {
    }

    public RomEntity(int roomNumber, String roomType, double unitPrice, List<ReservationEntity> reservationeList) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.unitPrice = unitPrice;
        this.reservationeList = reservationeList;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<ReservationEntity> getReservationeList() {
        return reservationeList;
    }

    public void setReservationeList(List<ReservationEntity> reservationeList) {
        this.reservationeList = reservationeList;
    }

    @Override
    public String toString() {
        String message= "Room Number:" +getRoomNumber() + "\n" +
                        "Room Type:" +getRoomType() + "\n" +
                        "Unit Price" +getUnitPrice();
        if (reservationeList !=null){
            for (ReservationEntity reservation : reservationeList) {
                message +="CheckinDate: " +reservation.getCheckinDate() + "\n";
            }
        }
        return  message;
    }
    //checkAvailableRom
    public boolean checkAvailableRom(LocalDate fromDate, LocalDate toDate){
        boolean check = true;
        for (ReservationEntity r : reservationeList){
            if ((r.getCheckinDate().compareTo(fromDate) <= 0 && r.getCheckinDate().compareTo(toDate) >= 0) ||
                    (r.getCheckoutDate().compareTo(fromDate) <= 0 && (r.getCheckoutDate().compareTo(toDate) >=0))){
                check = false;
                break;
            }
        }
        return  check;
    }
}
