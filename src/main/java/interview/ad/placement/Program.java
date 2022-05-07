package interview.ad.placement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import interview.ad.placement.model.CoreDataBuilder;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.InputBuilder;
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

	public String processFromFileByPlacment(String placmentFilePath, String deliveryFilePath) {
		Input input = createInput(placmentFilePath, deliveryFilePath);
		Output output = core.processDataByPlacement(new CoreDataBuilder().add(input).build());
		return writer.writeToCommandLine(output);
	}
	
	public String processByDateRange(String placmentFilePath, String deliveryFilePath, Date startDate, Date endDate) {
		Input input = createInput(placmentFilePath, deliveryFilePath);
		Output output = core.processDataByDateRange(new CoreDataBuilder().add(input, startDate, endDate).build(), startDate, endDate);
		return writer.writeToCommandLine(output);
	}
	
	private Input createInput(String placmentFilePath, String deliveryFilePath) {
		return new InputBuilder()
				.addPlacements(reader.readFile(placmentFilePath))
				.addDeliveries(reader.readFile(deliveryFilePath))
				.build();
	}

}
