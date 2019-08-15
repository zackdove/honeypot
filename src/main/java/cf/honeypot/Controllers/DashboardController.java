package cf.honeypot.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

	@RequestMapping("/dashboard")
	public String requestDashboard(){
		LOG.info("Get request for /dashboard");
		return "dashboard";
	}
}
