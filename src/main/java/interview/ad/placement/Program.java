package interview.ad.placement;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

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

	public Program(Reader reader, Core core, Writer writer) {
		super();
		this.reader = reader;
		this.core = core;
		this.writer = writer;
	}

	@PostConstruct
	public void init() {
		System.out.println("start program");
		Input input = reader.readFromFiles("a", "b");
		Output output = core.process(input);
		writer.write(output);
		System.out.println("end program");
	}

}
