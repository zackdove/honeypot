package cf.honeypot.Repositories;

import cf.honeypot.Models.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();
	Optional<Event> findById(Long id);

	@Query(value = "SELECT id, dateTime, sourceAddress, destAddress, protocol, destPort, flag, summary, packetNum FROM Event e ORDER BY e.id DESC LIMIT 100", nativeQuery = true)
	List<Event> getTop100();


	List<Event> findAllBySourceAddressEquals(String sourceAddress);

	List<Event> findAllByDestAddressEquals(String destAddress);

	List<Event> findAllByProtocolEquals(String protocol);

	List<Event> findAllByDestPortEquals(String destPort);

	List<Event> findAllByFlagEquals(String flag);

	List<Event> findByDateTimeAfter(LocalDateTime time);

}
