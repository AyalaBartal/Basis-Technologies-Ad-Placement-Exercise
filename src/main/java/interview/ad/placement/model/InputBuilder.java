package interview.ad.placement.model;

import java.util.List;

public class InputBuilder {
	
	private Input input;
	
	public InputBuilder() {
		this.input = new Input();
	}
	
	public InputBuilder addPlacements(List<String> placements) throws Exception {
		for(String placement : placements)
			addPlacement(placement);
		return this;
	}
	
	public InputBuilder addPlacement(String placement) throws Exception {
		add(new Placement(placement));
		return this;
	}
	
	public InputBuilder add(Placement placement) {
		input.add(placement);
		return this;
	}
	
	public InputBuilder addDeliveries(List<String> deliveries) throws Exception {
		for(String delivery : deliveries)
			addDelivery(delivery);
		return this;
	}
	
	public InputBuilder addDelivery(String delivery) throws Exception {
		add(new Delivery(delivery));
		return this;
	}
	
	public InputBuilder add(Delivery delivery) {
		input.add(delivery);
		return this;
	}
	
	public Input build() {
		return this.input;
	}

}
