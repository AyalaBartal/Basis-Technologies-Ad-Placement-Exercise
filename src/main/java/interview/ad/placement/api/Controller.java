package interview.ad.placement.api;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import interview.ad.placement.Program;
import interview.ad.placement.model.Output;
import interview.ad.placement.utils.DateUtils;

@RestController
@RequestMapping(value = "/api/v1/process_files")
public class Controller {

	@Autowired
	private Program program;

	// curl -H "Content-Type: application/json" "http://localhost:8081/api/v1/process_files/process_by_placement" -d "{\"placmentFile\":\"files\\placements.csv\", \"deliveryFile\":\"files\\deliveries.csv\"}"
	@RequestMapping(value = "/process_by_placement", method = RequestMethod.POST)
	public ResponseEntity<String> processByPlacment(@RequestBody Object input) {
		HashMap<String, Object> map = (HashMap) input;

		String placmentsFilePath = (String) map.get("placmentFile");
		String deliveriesFilePath = (String) map.get("deliveryFile");

		try {
			String r = program.processFromFileByPlacment(placmentsFilePath, deliveriesFilePath);
			return ResponseEntity.status(HttpStatus.OK).body(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
	}

	//curl -H "Content-Type: application/json" "http://localhost:8081/api/v1/process_files/process_by_date_range" -d "{ \"placmentFile\":\"files\\placements.csv\", \"deliveryFile\":\"files\\deliveries.csv\", \"startDate\":\"11/22/2020\", \"endDate\":\"12/5/2020\"}"
	@RequestMapping(value = "/process_by_date_range", method = RequestMethod.POST)
	public ResponseEntity<String> processByDateRange(@RequestBody Object input) {
		HashMap<String, Object> map = (HashMap) input;

		String placmentsFilePath = (String) map.get("placmentFile");
		String deliveriesFilePath = (String) map.get("deliveryFile");
		Date startDate = DateUtils.getDate((String) map.get("startDate"));
		Date endDate = DateUtils.getDate((String) map.get("endDate"));
		
		try {
			String r = program.processByDateRange(placmentsFilePath, deliveriesFilePath, startDate, endDate);
			return ResponseEntity.status(HttpStatus.OK).body(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
	}

}
