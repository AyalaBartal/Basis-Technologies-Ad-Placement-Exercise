package interview.ad.placement.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoreData {
	
	private Map<Integer, Placement> placementMap;
	private Map<Integer, List<Delivery>> deliveryMap;
	
	protected CoreData() {
		this.placementMap = new HashMap<Integer, Placement>();
		this.deliveryMap = new HashMap<Integer, List<Delivery>>();
	}
	
	protected void add(Placement placement) {
		if(!this.placementMap.containsKey(placement.getId()))
			this.deliveryMap.put(placement.getId(), new LinkedList<Delivery>());
		this.placementMap.put(placement.getId(), placement);
	}
	
	protected void add(Delivery delivery) {
		List<Delivery> deliveryList = this.deliveryMap.get(delivery.getPlacmentId());
		if(deliveryList == null) {
			System.out.println("Placment not found");
		}
		else if(delivery.getDate().before(this.placementMap.get(delivery.getPlacmentId()).getStart()) ||
				delivery.getDate().after(this.placementMap.get(delivery.getPlacmentId()).getEnd())) {
				System.out.println("Date not in range");
		}
		else {
			int index = 0;
			while(index < deliveryList.size() && deliveryList.get(index).getDate().before(delivery.getDate()))
				index++;
			deliveryList.add(index, delivery);
		}
	}
	
	public Map<Integer, Placement> getPlacements(){
		return this.placementMap;
	}
	
	public Map<Integer, List<Delivery>> getDeliveries(){
		return this.deliveryMap;
	}
}
