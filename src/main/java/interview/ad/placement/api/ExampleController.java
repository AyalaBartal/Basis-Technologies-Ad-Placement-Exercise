package interview.ad.placement.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/example")
public class ExampleController {

	@RequestMapping(value = "/hello")
	public String getHello() {
		return "Hello";
	}

}
