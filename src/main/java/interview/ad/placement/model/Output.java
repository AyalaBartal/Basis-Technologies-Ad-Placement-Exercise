package interview.ad.placement.model;

import java.util.ArrayList;
import java.util.List;

public class Output {

	private List<Result> resultList;
	
	public Output() {
		this.resultList = new ArrayList<Result>();
	}
	
	public List<Result> getResult(){
		return this.resultList;
	}
	
	public void addResult(Result result) {
		this.resultList.add(result);
	}
}
