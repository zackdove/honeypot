package cf.honeypot;

import cf.honeypot.Controllers.EventController;
import cf.honeypot.Repositories.EventRepository;
import cf.honeypot.Services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventService eventService;

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	public void run(ApplicationArguments args){

		Long id = Long.valueOf(69);
		if (!eventRepository.findById(id).isPresent()){
			LOG.info("initiating event 69");
			eventService.createAndSaveEvent(id , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));

		}
	}
}
