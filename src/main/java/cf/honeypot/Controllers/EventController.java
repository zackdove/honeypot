package cf.honeypot.Controllers;

import cf.honeypot.Services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public String viewEvents(Model model){
		model.addAttribute("events", eventService.getTop100());
		return "event_list";
	}

	@GetMapping("/event_list_fragment")
	public String getEventListFragment(ModelMap map){
		map.addAttribute("events", eventService.getTop100());
		LOG.info("Refreshing events");

		return "event_list :: #eventListFragment";
	}
}
