package interview.ad.placement.integrationTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.InputBuilder;
import interview.ad.placement.model.Placement;
import interview.ad.placement.service.Reader;
import interview.ad.placement.utils.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Reader.class})
public class ReaderIntegrationTest {

	@Autowired
	private Reader reader;
	
	@Test
	public void readOneLinePlacemntFile() {
		String placementPath = "files\\oneLinePlacements.csv";
		List<String> actual = reader.readFile(placementPath);

		Assert.assertEquals(1, actual.size());
		Assert.assertEquals("1	Sports	11/1/20	11/30/20	5", actual.get(0));
	}
	
	@Test
	public void readOneLineDeliveryFile() {
		String deliveryPath = "files\\oneLineDelivery.csv";
		List<String> actual = reader.readFile(deliveryPath);

		Assert.assertEquals(1, actual.size());
		Assert.assertEquals("1,11/1/2020,33427", actual.get(0));
	}
	
	@Test
	public void readMultiLineFile() {
		String deliveryPath = "files\\placements.csv"; 
		List<String> actual = reader.readFile(deliveryPath);
		
		Assert.assertEquals(4, actual.size());
	}
}
