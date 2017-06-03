package assignmentspringjpa;

import config.SpringConfig;
import entity.ReservationEntity;
import entity.RomEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.ReservationRepository;
import repository.RomRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Created by tuananh on 06/03/17.
 */
public class Main {
    static ApplicationContext context =
            new AnnotationConfigApplicationContext(SpringConfig.class);
        static RomRepository romRepository =
                (RomRepository)context.getBean("romRepository");
        static ReservationRepository reservationRepository =
                (ReservationRepository)context.getBean("reservationRepository");

    public static void main(String[] args) {
        LocalDate fromDate = LocalDate.of(2016, Month.NOVEMBER, 16);
        LocalDate toDate = LocalDate.of(2016, Month.NOVEMBER, 17);
        checkAvailableRom(fromDate, toDate);
    }

    public static  void checkAvailableRom(LocalDate fromDate, LocalDate toDate){

        List<RomEntity> romEntityList = (List<RomEntity>)romRepository.findAll();
        for (RomEntity romEntity : romEntityList){
//            romEntity.setReservationeList(romEntity.getReservationeList());
//              if (romEntity.checkAvailableRom(fromDate, toDate)){
                  System.out.println(romEntity);
//              }
        }
    }
}
