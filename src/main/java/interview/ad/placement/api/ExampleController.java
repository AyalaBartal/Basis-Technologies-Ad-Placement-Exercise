package interview.ad.placement.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/example")
public class ExampleController {

/*
-Linux terminal-
curl -X GET -sb \
-H "Accept: application/json" \
'http://localhost:8081/api/v1/example/hello' 

-Windows cmd- 
curl -H "Accept: application/json" "http://localhost:8081/api/v1/example/hello"	 	 
*/
	@RequestMapping(value = "/hello")
	public String getHello() {
		return "Hello";
	}

/*
-Linux terminal-
curl -X POST \
-H "Content-Type: application/json"  \
'http://localhost:8081/api/v1/example/files' \
-d '{"name":"me","lastName":"me last"}'
 
-Windows cmd- 
curl -H "Content-Type: application/json" "http://localhost:8081/api/v1/example/files" -d "{ \"a\":\"1\", \"b\":\"2\"}"		   
 */
	@RequestMapping(value ="/files", method = RequestMethod.POST)
	public Object writeFiles(@RequestBody Object input) {
		return input;
	}

}
