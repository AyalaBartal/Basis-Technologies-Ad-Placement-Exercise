package interview.ad.placement.unitTest;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.InputBuilder;
import interview.ad.placement.model.Placement;
import interview.ad.placement.utils.DateUtils;

public class InputBuilderUnitTest {
		
	@Test
	public void testNoData() {
		Input input = new InputBuilder().build();
		
		Assert.assertEquals(0, input.getPlacements().size());
		Assert.assertEquals(0, input.getDeliveries().size());
	}
	
	@Test
	public void testOnePlacmentObjectOneDeliveryObject() {
		Input input = new InputBuilder()
						.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 33427))
						.build();
		
		Assert.assertEquals(1, input.getPlacements().size());
		Assert.assertEquals(1, input.getDeliveries().size());
	}
	
	@Test
	public void testTowPlacmentObjectTowDeliveryObject() {
		Input input = new InputBuilder()
						.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Placement(2, "Business", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 33427))
						.add(new Delivery(2, DateUtils.getDate(2020, 11, 2), 38673))
						.build();
		
		Assert.assertEquals(2, input.getPlacements().size());
		Assert.assertEquals(2, input.getDeliveries().size());
	}
	
	@Test
	public void testNoPlacmentObjectOneDeliveryObject() {
		Input input = new InputBuilder()
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 33427))
						.build();
		
		Assert.assertEquals(0, input.getPlacements().size());
		Assert.assertEquals(1, input.getDeliveries().size());
	}
	
	@Test
	public void testOnePlacmentObjectNoeDeliveryObject() {
		Input input = new InputBuilder()
						.add(new Placement(2, "Business", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.build();
		
		Assert.assertEquals(1, input.getPlacements().size());
		Assert.assertEquals(0, input.getDeliveries().size());
	}
	
	@Test
	public void testOnePlacmentStringOneDeliveryString() {
		Input input = new InputBuilder()
						.addPlacement("4	Politics	12/1/20	12/31/20	6")
						.addDelivery("1,11/1/2020,33427")
						.build();
		
		Assert.assertEquals(1, input.getPlacements().size());
		Assert.assertEquals(1, input.getDeliveries().size());
		Assert.assertEquals(6, input.getPlacements().get("Politics").getCpm());
		Assert.assertEquals(33427, input.getDeliveries().get(0).getImpressions());
	}
	
	
	@Test
	public void testPlacmentDeliveryFromStringList() {
		List<String> pl = Arrays.asList("4	Politics	12/1/20	12/31/20	6");
		List<String> dl = Arrays.asList("1,11/1/2020,33427");
		Input input = new InputBuilder()
						.addPlacements(pl)
						.addDeliveries(dl)
						.build();
		
		Assert.assertEquals(1, input.getPlacements().size());
		Assert.assertEquals(1, input.getDeliveries().size());
		Assert.assertEquals(6, input.getPlacements().get("Politics").getCpm());
		Assert.assertEquals(33427, input.getDeliveries().get(0).getImpressions());
	}
}
