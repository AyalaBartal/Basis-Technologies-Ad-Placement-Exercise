package interview.ad.placement;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.Placement;
import interview.ad.placement.service.Reader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Reader.class})
public class ReaderIntegrationTest {

	@Autowired
	private Reader reader;
	
	@Test
	public void readOneLineFile() {
		String deliveryPath = "files\\oneLineDelivery.csv";
		String placementPath = "files\\oneLinePlacements.csv";

		Input actual = reader.readFromFiles(placementPath, deliveryPath);
		
		Input mock = new Input();

		mock.add(new Delivery(1, getDate(2020, 11, 1), 33427));
		mock.add(new Placement(1, "Sports", getDate(2020, 11, 01), getDate(2020, 11, 30), 5));

		Assert.assertTrue(mock.getPlacements().get("Sports").equals(actual.getPlacements().get("Sports")));
		Assert.assertTrue(mock.getDeliveries().get(0).equals(actual.getDeliveries().get(0)));
	}
	
	
	@Test
	public void readMultiLineFile() {
		String deliveryPath = "files\\deliveries.csv";
		String placementPath = "files\\placements.csv";

		Input actual = reader.readFromFiles(placementPath, deliveryPath);
		
		Assert.assertEquals(4, actual.getPlacements().size());
		Assert.assertEquals(122, actual.getDeliveries().size());
	}
	
	private Date getDate(int year, int month, int day) {
		return new GregorianCalendar(year, month -1 , day).getTime();
	}

}
