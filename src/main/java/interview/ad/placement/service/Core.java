package interview.ad.placement.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import interview.ad.placement.model.CoreData;
import interview.ad.placement.model.Delivery;
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
				int cmp = placment.getCpm();
				long impressions = 0;
				Date startDate = placment.getStart(), endDate = placment.getEnd();
				for(Delivery delivery: data.getDeliveries().get(id)) {
					impressions += delivery.getImpressions();
				}

				float cost = ((float)impressions/1000) * cmp;

				output.addResult(new Result(name, startDate, endDate, impressions, cmp, Math.round(cost)));
			}
		}
		
		return output;
	}

	public Output processDataByDateRange(CoreData data, Date startDate, Date endDate) {
		if(startDate.after(endDate))
			return processDataByDateRange(data, startDate, endDate);
		
		Output output = new Output();
		
		float cost = 0;
		long impressions = 0;
		
		if(data != null && data.getPlacements().size() != 0) {
			for(Integer id: data.getPlacements().keySet()) {
				int cmp = data.getPlacements().get(id).getCpm();
				
				for(Delivery delivery: data.getDeliveries().get(id)) {
					impressions += delivery.getImpressions();
					cost += ((float)delivery.getImpressions()/1000) * cmp;
					
				}

			}
		}
		
		output.addResult(new Result("Total", startDate, endDate, impressions, Integer.MIN_VALUE, Math.round(cost)));
		
		return output;
	}
}
