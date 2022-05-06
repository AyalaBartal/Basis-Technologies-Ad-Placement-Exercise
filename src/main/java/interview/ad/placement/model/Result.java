package interview.ad.placement.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interview.ad.placement.utils.DateUtils;

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

	@Override
	public String toString() {
		String name = this.name + " ";
		String dateRange = "(" + DateUtils.toString(this.startDate) + "-" +  DateUtils.toString(this.endDate) +  "): ";
		String impressions = formatNumber(this.impressions) + " impressions ";
		String cpm = "@ $" + this.cpm + " CPM ";
		String cost = "= $" + formatNumber(this.cost);
		
		return name + dateRange + impressions + cpm + cost;
	}

	private String formatNumber(long number) {
		List<Integer> numberList = new ArrayList<Integer>();
		while(number / 1000 > 0) {
			numberList.add((int)(number % 1000));
			number /= 1000;
		}
		
		if(number > 0)
			numberList.add((int)(number));
		
		StringBuilder sb = new StringBuilder();
		for(int i = numberList.size() - 1; i > 0; i--)
			sb.append(numberList.get(i) + ",");
		sb.append(numberList.get(0));
			
		return sb.toString();
	}
	
}
