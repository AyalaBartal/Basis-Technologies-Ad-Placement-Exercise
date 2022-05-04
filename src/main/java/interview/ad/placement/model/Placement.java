package interview.ad.placement.model;

import java.util.Date;

public class Placement {
	
	private int id;
	private String name;
	private Date start;
	private Date end;
	private int cmp;
	
	public Placement(int id, String name, Date start, Date end, int cmp) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.cmp = cmp;
	}
	
	public String getName() {
		return this.name;
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
		if (cmp != other.cmp)
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
