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
			eventService.createAndSaveEvent(Long.valueOf(2) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(3) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(4) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(5) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));

			eventService.createAndSaveEvent(Long.valueOf(6) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(7) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(8) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(9) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(10) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(11) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(22) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(223) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(25) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(287) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(28) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(24) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(253) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(255) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));
			eventService.createAndSaveEvent(Long.valueOf(2555) , LocalDateTime.now(), "69.69.69.69", "420.420.420.420", "HTTP", "80", "red", "Put summary here", Long.valueOf(1));

		}
	}
}
