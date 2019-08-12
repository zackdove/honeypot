package cf.honeypot.Services;

import cf.honeypot.Models.Event;
import cf.honeypot.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

	public void createEvent(Long id, LocalDateTime dateTime, String sourceAddress, String destAddress, String protocol, String destPort, String flag, String summary){
		Event e = new Event();
		e.setId(id);
		e.setDateTime(dateTime);
		e.setSourceAddress(sourceAddress);
		e.setDestAddress(destAddress);
		e.setProtocol(protocol);
		e.setDestPort(destPort);
		e.setFlag(flag);
		e.setSummary(summary);
		save(e);
	}

	public Event save(Event event){return eventRepository.save(event);}

	public List<Event> getTop100(){
		return eventRepository.getTop100();
	}
}
