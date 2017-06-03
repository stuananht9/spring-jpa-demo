package repository;

import entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tuananh on 06/03/17.
 */
@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Integer> {
    //List<ReservationEntity> findByRoomId(int roomId);
}
