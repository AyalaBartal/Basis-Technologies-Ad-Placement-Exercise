package interview.ad.placement.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.Placement;

@Component
public class Reader {
	
	private final int CURRENT_YEAR = 22;
	
	public Input readFromFiles(String placementsFilePath, String deliveriesFilePath) {
		Input input = new Input();
		
		List<String> enteries = getLinesFromFile(placementsFilePath);
		for(String entery : enteries) {
			input.add(parseLineToPlacement(entery));
		}
		
		enteries = getLinesFromFile(deliveriesFilePath);
		for(String entery : enteries) {
			input.add(parseLineToDelivery(entery));
		}
		
		return input;
	}
	
	private List<String> getLinesFromFile(String path){
		List<String> enteries = new ArrayList<String>();
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			String entery = scanner.nextLine();
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
		Date start = paresStringToDate(details[2]);
		Date end = paresStringToDate(details[3]);
		int cpm = Integer.valueOf(details[4]);
		
		return new Placement(id, name, start, end, cpm);
	}

	private Delivery parseLineToDelivery(String entery) {
		entery.replaceAll("\\s+", "");
		String[] details = entery.split(",");
		
		int id = Integer.valueOf(details[0]);
		Date date = paresStringToDate(details[1]);
		long impressions = Long.parseLong(details[2]);
		
		return new Delivery(id, date, impressions);
	}
	
	private Date paresStringToDate(String entery) {
		String[] details = entery.split("/");
		
		int month = Integer.parseInt(details[0]);
		int day = Integer.parseInt(details[1]);
		int year = Integer.parseInt(details[2]);
		
		if(year <= CURRENT_YEAR)
			year += 2000;
			
		return new GregorianCalendar(year, month-1, day).getTime();
	}
}
