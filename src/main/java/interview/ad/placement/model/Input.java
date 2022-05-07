package interview.ad.placement.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input {
	
	private List<Delivery> deliveries;
	private Map<String, Placement> placements;
	
	protected Input() {
		super();
		this.deliveries = new ArrayList<Delivery>();
		this.placements = new HashMap<String, Placement>();
	}
	
	protected void add(Delivery delivery) {
		deliveries.add(delivery);
	}
	
	protected void add(Placement placement) {
		placements.put(placement.getName(), placement);
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public Map<String, Placement> getPlacements() {
		return placements;
	}
}
