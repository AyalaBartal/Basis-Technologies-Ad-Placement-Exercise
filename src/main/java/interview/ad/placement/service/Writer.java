package interview.ad.placement.service;

import org.springframework.stereotype.Component;

import interview.ad.placement.model.Output;
import interview.ad.placement.model.Result;

@Component
public class Writer {
	
	public String writeToCommandLine(Output data) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append("The result of the processing are:").append("\n");
		for(Result result: data.getResult())
			sb.append(result.toString()).append("\n");
		return sb.toString();
	}

}
