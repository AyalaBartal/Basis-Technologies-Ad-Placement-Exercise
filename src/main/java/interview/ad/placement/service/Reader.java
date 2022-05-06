package interview.ad.placement.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.Placement;
import utils.DateUtils;

@Component
public class Reader {
	
	public Input readFromFiles(String placementsFilePath, String deliveriesFilePath) {
		Input input = new Input();
		
		List<String> enteries = getLinesFromFile(placementsFilePath, true);
		if(enteries == null)
			return readFromFiles(deliveriesFilePath, placementsFilePath);

		for(String entery : enteries) {				
			input.add(parseLineToPlacement(entery));
		}
		
		enteries = getLinesFromFile(deliveriesFilePath, false);
		for(String entery : enteries) {
			input.add(parseLineToDelivery(entery));
		}
		
		return input;
	}
	
	private List<String> getLinesFromFile(String path, boolean firstRun){
		List<String> enteries = new ArrayList<String>();
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			String entery = scanner.nextLine();
			
			if(firstRun && entery.split(",").length == 3) {
				return null;
			}
			
			while(scanner.hasNextLine()) {
				entery = scanner.nextLine();
				enteries.add(entery);
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		return enteries;
	}

	private Placement parseLineToPlacement(String entery) {
		entery.replaceAll("\\s+","");
		String[] details = entery.split("\t");
		
		int id = Integer.valueOf(details[0]);
		String name = details[1];
		Date start = DateUtils.getDate(details[2]);
		Date end =  DateUtils.getDate(details[3]);
		int cpm = Integer.valueOf(details[4]);
		
		return new Placement(id, name, start, end, cpm);
	}
	
	private Delivery parseLineToDelivery(String entery) {
		entery.replaceAll("\\s+", "");
		String[] details = entery.split(",");
		
		int id = Integer.valueOf(details[0]);
		Date date = DateUtils.getDate(details[1]);
		long impressions = Long.parseLong(details[2]);
		
		return new Delivery(id, date, impressions);
	}

}
