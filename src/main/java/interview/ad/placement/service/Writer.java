package interview.ad.placement.service;

import org.springframework.stereotype.Component;

import interview.ad.placement.model.Output;
import interview.ad.placement.model.Result;

@Component
public class Writer {
	
	public void write(Output data) {
		for(Result result: data.getResult())
			System.out.println(result.toString());
	}

}
