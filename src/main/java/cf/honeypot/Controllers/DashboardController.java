package cf.honeypot.Controllers;

import cf.honeypot.Services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

	@Autowired
	private EventService eventService;

	@RequestMapping("/dashboard")
	public String requestDashboard(Model model){
		LOG.info("Get request for /dashboard");
		String colour = eventService.getDashboardAlertColour();
		LOG.info("Colour for dash= " + colour);
		model.addAttribute("colour", colour);
		return "dashboard";
	}
}
