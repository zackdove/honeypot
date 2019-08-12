package cf.honeypot.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

	@RequestMapping("/")
	public String requestIndex(){
		LOG.info("Get request for /");
		return "index";
	}

	@RequestMapping("/dashboard")
	public String requestDashboard(){
		LOG.info("Get request for /dashboard");
		return "dashboard";
	}

	@RequestMapping("/placeholder")
	public String requestPlaceholder(){
		LOG.info("Get request for /placeholder");
		return "powerbi-placeholder";
	}


}