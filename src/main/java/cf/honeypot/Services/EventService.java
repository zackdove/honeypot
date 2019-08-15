package cf.honeypot.Services;

import cf.honeypot.Controllers.EventController;
import cf.honeypot.Models.Event;
import cf.honeypot.Models.Filter;
import cf.honeypot.Repositories.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

	private EventRepository eventRepository;

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

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


	//If there are 5 ambers in the last hour, the alert is amber, if there are 10 ambers or one red, the alert is red.
	//Else green.
	public String getDashboardAlertColour(){
		LocalDateTime anHourAgo = LocalDateTime.now().minusHours(1);
		List<Event> eventsInLastHour = eventRepository.findByDateTimeAfter(anHourAgo);
		String colour = "green";
		Integer danger = 0;
		for (Event event : eventsInLastHour){
			if (event.getFlag().equals("amber")){
				danger+=10;
			} else if (event.getFlag().equals("red")){
				danger+= 100;
			}
		}
		if (danger >= 50){
			colour = "amber";
		} else if (danger >= 100){
			colour = "red";
		}
		return colour;
	}

	public List<Event> getEventsFromFilter(Filter filter){
		List<Event> events = eventRepository.getTop100();
		LOG.info("Protocol = " + filter.getProtocol());
		LOG.info("Size " + events.size());
		if (!filter.getSourceAddress().isEmpty()){
			LOG.info("Filtering by source, so source is still here");
			events.removeIf(event -> !event.getSourceAddress().equals(filter.getSourceAddress()));
		}
		LOG.info("Size " + events.size());
		if (!filter.getDestAddress().isEmpty() ){
			events.removeIf(event -> !event.getDestAddress().equals(filter.getDestAddress()));
		}
		LOG.info("Size " + events.size());
		if (!filter.getProtocol().isEmpty()){
			events.removeIf(event -> !event.getProtocol().equals(filter.getProtocol()));
		}
		LOG.info("Size " + events.size());
		if (!filter.getDestPort().isEmpty()){
			events.removeIf(event -> !event.getDestPort().equals(filter.getDestPort()));
		}
		LOG.info("Size " + events.size());
		if (!filter.getFlag().isEmpty()){
			events.removeIf(event -> !event.getFlag().equals(filter.getFlag()));
		}
		LOG.info("Size " + events.size());
		return events;
	}
}
