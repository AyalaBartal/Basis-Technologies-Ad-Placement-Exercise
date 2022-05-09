package interview.ad.placement.model;

import java.util.Date;

import interview.ad.placement.utils.DateUtils;
import interview.ad.placement.utils.StringUtils;

public class Placement {
	
	private int id;
	private String name;
	private Date start;
	private Date end;
	private int cpm;
	
	public Placement(int id, String name, Date start, Date end, int cmp) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.cpm = cmp;
	}
	
	public Placement(String placement) {
		super();
		String[] details = StringUtils.splitString(placement);
		
		this.id = Integer.valueOf(details[0]);
		this.name = details[1];
		this.start = DateUtils.getDate(details[2]);
		this.end =  DateUtils.getDate(details[3]);
		this.cpm = Integer.valueOf(details[4]);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public int getCpm() {
		return cpm;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Placement other = (Placement) obj;
		if (cpm != other.cpm)
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

}
