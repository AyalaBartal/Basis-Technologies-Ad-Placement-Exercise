package interview.ad.placement.model;

public class CoreDataBuilder {
	
	private CoreData data;
	
	public CoreDataBuilder() {
		this.data = new CoreData();
	}
	
	public CoreDataBuilder add(Placement placement) {
		this.data.add(placement);
		return this;
	}
	
	public CoreDataBuilder add(Delivery delivery) {
		this.data.add(delivery);
		return this;
	}
	
	public CoreDataBuilder add(Input input) {
		for(Placement placement : input.getPlacements().values())
			add(placement);
		for(Delivery delivery: input.getDeliveries())
			add(delivery);
		return this;
	}
	
	public CoreDataBuilder add(CoreData data) {
		for(Integer id : data.getPlacements().keySet()) {
			add(data.getPlacements().get(id));
			for(Delivery delivery: data.getDeliveries().get(id))
				add(delivery);		
		}
		return this;
	}
	
	public CoreData build() {
		return this.data;
	}

}
