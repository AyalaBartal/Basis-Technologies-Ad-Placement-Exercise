package interview.ad.placement.utils;

public class StringUtils {
	
	public static String[] splitString(String s) {
		if(s.contains(","))
			return s.split(",");
		else if(s.contains("\t"))
			return s.split("\t");
		return new String[] {s};
	}

}
