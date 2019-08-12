package cf.honeypot.Services;

import cf.honeypot.Models.Event;
import cf.honeypot.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void createEvent(Long id, String sourceIp, String content){
		Event e = new Event();
		e.setId(id);
		e.setSourceIp(sourceIp);
		e.setContent(content);
		save(e);
	}

	public Event save(Event event){return eventRepository.save(event);}
}
