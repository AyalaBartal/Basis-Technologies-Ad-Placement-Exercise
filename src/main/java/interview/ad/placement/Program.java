package interview.ad.placement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import interview.ad.placement.model.CoreDataBuilder;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.Output;
import interview.ad.placement.service.Core;
import interview.ad.placement.service.Reader;
import interview.ad.placement.service.Writer;

@Component
public class Program {
	
	private Reader reader;
	private Core core;
	private Writer writer;

	@Autowired
	public Program(Reader reader, Core core, Writer writer) {
		super();
		this.reader = reader;
		this.core = core;
		this.writer = writer;
	}

	@PostConstruct
	public void init() {
		System.out.println("start program");
		Input input = reader.readFromFiles("files\\\\placements.csv", "files\\\\deliveries.csv");
		Output output = core.processDataByPlacement(new CoreDataBuilder().add(input).build());
		writer.write(output);
		System.out.println("end program");
	}

}
