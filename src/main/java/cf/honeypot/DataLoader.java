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

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventService eventService;

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	public void run(ApplicationArguments args){

		Long id = Long.valueOf(2);

		if (eventRepository.findById(id).isEmpty()){
			LOG.info("initiatinng event 69");
			eventService.createEvent(id, "69.69.69.69", "content placeholder");

		}
	}
}
