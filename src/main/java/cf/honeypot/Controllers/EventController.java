package cf.honeypot.Controllers;

import cf.honeypot.Services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public String viewEvents(Model model){
		LOG.info("Listing events");
		model.addAttribute("events", eventService.findAll());
		return "event_list";
	}
}
