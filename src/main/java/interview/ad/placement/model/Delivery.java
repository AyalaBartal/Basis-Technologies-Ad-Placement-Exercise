package interview.ad.placement.model;

import java.util.Date;

public class Delivery {
	
	private int id;
	private Date date;
	private long impressions;
	
	public Delivery(int id, Date date, long impressions) {
		super();
		this.id = id;
		this.date = date;
		this.impressions = impressions;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (impressions != other.impressions)
			return false;
		return true;
	}	
}
