package interview.ad.placement.model;

import java.util.Date;

import interview.ad.placement.utils.DateUtils;

public class Delivery {
	
	private int placmentId;
	private Date date;
	private long impressions;
	
	public Delivery(int placementId, Date date, long impressions) {
		super();
		this.placmentId = placementId;
		this.date = date;
		this.impressions = impressions;
	}
	
	public Delivery(String deliveryString) {
		super();
		deliveryString.replaceAll("\\s+", "");
		String[] details = deliveryString.split(",");
		
		this.placmentId = Integer.valueOf(details[0]);
		this.date = DateUtils.getDate(details[1]);
		this.impressions = Long.parseLong(details[2]);
	}

	public int getPlacmentId() {
		return placmentId;
	}

	public Date getDate() {
		return date;
	}
	
	public long getImpressions() {
		return impressions;
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
		if (placmentId != other.placmentId)
			return false;
		if (impressions != other.impressions)
			return false;
		return true;
	}	

}
