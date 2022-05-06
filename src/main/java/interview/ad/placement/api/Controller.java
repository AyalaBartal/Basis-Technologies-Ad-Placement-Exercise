package interview.ad.placement.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import interview.ad.placement.Program;
import interview.ad.placement.model.Output;

@RestController
@RequestMapping(value = "/api/v1/process_files")
public class Controller {
	
	@Autowired
	private Program program;
	
	//curl -H "Content-Type: application/json" "http://localhost:8081/api/v1/process_files/process_by_placement" -d "{ \"placmentFile\":\"files\\placements.csv\", \"deliveryFile\":\"files\\deliveries.csv\"}"
	@RequestMapping(value = "/process_by_placement", method = RequestMethod.POST)
	public String processByPlacment(@RequestBody Object input) {
		HashMap<String,Object> map = (HashMap)input;
		
		String placmentsFilePath = (String)map.get("placmentFile");
		String deliveriesFilePath = (String)map.get("deliveryFile");
		
		return program.processFromFileByPlacment(placmentsFilePath, deliveriesFilePath);
		
		

	}
	

}
