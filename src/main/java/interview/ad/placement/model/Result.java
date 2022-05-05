package interview.ad.placement.model;

import java.util.Date;

public class Result {
	
	private String name;
	private Date startDate;
	private Date endDate;
	private long impressions;
	private int cpm;
	private long cost;
	
	public Result(String name, Date startDate, Date endDate, long impressions, int cpm, long cost) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.impressions = impressions;
		this.cpm = cpm;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public long getImpressions() {
		return impressions;
	}

	public int getCpm() {
		return cpm;
	}

	public long getCost() {
		return cost;
	}
	
}
