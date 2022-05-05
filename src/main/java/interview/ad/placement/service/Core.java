package interview.ad.placement.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import interview.ad.placement.model.CoreData;
import interview.ad.placement.model.CoreDataBuilder;
import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.Output;
import interview.ad.placement.model.Placement;
import interview.ad.placement.model.Result;

@Component
public class Core {
	
	public Output processDataByPlacement(CoreData data) {
		
		Output output = new Output();
		
		if(data != null && data.getPlacements().size() != 0) {
			for(Integer id: data.getPlacements().keySet()) {
				Placement placment = data.getPlacements().get(id);
				String name = placment.getName();
				int cmp = placment.getCmp();
				long impressions = 0;
				Date startDate = placment.getStart(), endDate = placment.getEnd();
				for(Delivery delivery: data.getDeliveries().get(id)) {
					impressions += delivery.getImpressions();
				}
				long cost = impressions/1000 * cmp;
				output.addResult(new Result(name, startDate, endDate, impressions, cmp, cost));
			}
		}
		
		return output;
	}
}
