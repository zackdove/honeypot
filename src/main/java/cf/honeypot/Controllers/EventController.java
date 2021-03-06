package cf.honeypot.Controllers;

import cf.honeypot.Models.Event;
import cf.honeypot.Models.Filter;
import cf.honeypot.Services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;

@Controller
public class EventController {

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public String viewEvents(Model model){
		model.addAttribute("events", eventService.getTop100());
		model.addAttribute("filter", new Filter());
		return "event_list";
	}

	@PostMapping("/events/filter")
	public String filterEvents(@ModelAttribute Filter filter, Model model){
		model.addAttribute("events", eventService.getEventsFromFilter(filter));
		return "event_list";
	}

	@GetMapping("/event/{id}")
	public String viewEvent(@PathVariable String id, Model model){
		LOG.info("Get requets for id = " + id);
		model.addAttribute("event", eventService.findById(id).get());
		return "event";
	}

	@RequestMapping(value = "/event_list_fragment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getEventListFragment(@RequestParam("sourceAddress") String sourceAddress, @RequestParam("destAddress") String destAddress, @RequestParam("protocol") String protocol, @RequestParam("destPort") String destPort, @RequestParam("flag") String flag, Model model){
		LOG.info("Refreshing events with protocol filter = " + protocol);
		Filter filter = new Filter();
		filter.setSourceAddress(sourceAddress);
		filter.setDestAddress(destAddress);
		filter.setProtocol(protocol);
		filter.setDestPort(destPort);
		filter.setFlag(flag);
		model.addAttribute("events", eventService.getEventsFromFilter(filter));
		model.addAttribute("filter", filter );
		return "event_list :: #eventListFragment";
	}


	@GetMapping("/events/sourceAddress/{sourceAddress}")
	public String viewEventsBySourceAddress(@PathVariable String sourceAddress, Model model){
		Filter filter = new Filter();
		filter.setSourceAddress(sourceAddress);
		model.addAttribute("events", eventService.getEventsFromFilter(filter));
		model.addAttribute("filter", filter);
		return "event_list";
	}

	@GetMapping("/events/destAddress/{destAddress}")
	public String viewEventsByDestAddress(@PathVariable String destAddress, Model model){
		Filter filter = new Filter();
		filter.setDestAddress(destAddress);
		model.addAttribute("events", eventService.getEventsFromFilter(filter));
		model.addAttribute("filter", filter);
		return "event_list";
	}

	@GetMapping("/events/protocol/{protocol}")
	public String viewEventsByProtocol(@PathVariable String protocol, Model model){
		Filter filter = new Filter();
		filter.setProtocol(protocol);
		model.addAttribute("events", eventService.getEventsFromFilter(filter));
		model.addAttribute("filter", filter);
		return "event_list";
	}

	@GetMapping("/events/destPort/{destPort}")
	public String viewEventsByDestPort(@PathVariable String destPort, Model model){
		Filter filter = new Filter();
		filter.setDestPort(destPort);
		model.addAttribute("events", eventService.getEventsFromFilter(filter));
		model.addAttribute("filter", filter);
		return "event_list";
	}

	@GetMapping("/events/flag/{flag}")
	public String viewEventsByFlag(@PathVariable String flag, Model model){
		Filter filter = new Filter();
		filter.setFlag(flag);
		model.addAttribute("events", eventService.getEventsFromFilter(filter));
		model.addAttribute("filter", filter);
		return "event_list";
	}
}
