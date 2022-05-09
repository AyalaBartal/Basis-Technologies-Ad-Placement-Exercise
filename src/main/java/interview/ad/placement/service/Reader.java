package interview.ad.placement.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Reader {
	
	public List<String> readFile(String path) throws Exception{
		List<String> enteries = new ArrayList<String>();
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		String entery = scanner.nextLine();
		
		while(scanner.hasNextLine()) {
			entery = scanner.nextLine();
			enteries.add(entery);
		}
			
		scanner.close();
		
		return enteries;
	}
}
