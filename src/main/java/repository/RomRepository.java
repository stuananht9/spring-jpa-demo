package repository;

import entity.RomEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tuananh on 06/03/17.
 */
@Repository
public interface RomRepository extends CrudRepository<RomEntity, Integer> {
    //RomEntity findByRoomNumber(int roomNumber);
}
