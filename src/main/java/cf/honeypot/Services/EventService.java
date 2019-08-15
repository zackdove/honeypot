package cf.honeypot.Services;

import cf.honeypot.Models.Event;
import cf.honeypot.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

	private EventRepository eventRepository;

	@Autowired
	public EventService(EventRepository eventRepository){
		this.eventRepository = eventRepository;
	}

	public List<Event> findAll(){
		return eventRepository.findAll();
	}

	public Event createEvent(Long id, LocalDateTime dateTime, String sourceAddress, String destAddress, String protocol, String destPort, String flag, String summary, Long packetNum){
		Event e = new Event();
		e.setId(id);
		e.setDateTime(dateTime);
		e.setSourceAddress(sourceAddress);
		e.setDestAddress(destAddress);
		e.setProtocol(protocol);
		e.setDestPort(destPort);
		e.setFlag(flag);
		e.setSummary(summary);
		e.setPacketNum(packetNum);
		return e;
	}

	public void createAndSaveEvent(Long id, LocalDateTime dateTime, String sourceAddress, String destAddress, String protocol, String destPort, String flag, String summary, Long packetNum){
		Event e = createEvent(id, dateTime, sourceAddress, destAddress,  protocol,  destPort,  flag,  summary,  packetNum);
		save(e);
	}

	public Event save(Event event){return eventRepository.save(event);}

	public List<Event> getTop100(){
		return eventRepository.getTop100();
	}

	public List<Event> findAllBySourceAddressEquals(String sourceAddress){return eventRepository.findAllBySourceAddressEquals(sourceAddress);}

	public List<Event> findAllByDestAddressEquals(String destAddress){return eventRepository.findAllByDestAddressEquals(destAddress);}

	public List<Event> findAllByProtocolEquals(String protocol){return eventRepository.findAllByProtocolEquals(protocol);}

	public List<Event> findAllByDestPortEquals(String destPort){return eventRepository.findAllByDestPortEquals(destPort);}

	public List<Event> findAllByFlagEquals(String flag){return eventRepository.findAllByFlagEquals(flag);}

	public Optional<Event> findById(String id){
		Optional<Event> optionalEvent = eventRepository.findById(Long.valueOf(id));
		return optionalEvent;
	}

	public Event getBlankEvent(){
		return createEvent(Long.valueOf(1), null, null, null, null, null, null, null, null);
	}

	public String getDashboardAlertColour(){
		String colour = "red";
		return colour;
	}
}
