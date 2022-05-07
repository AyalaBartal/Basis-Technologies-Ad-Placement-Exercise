package interview.ad.placement.unitTest;

import org.junit.Test;

import interview.ad.placement.model.CoreData;
import interview.ad.placement.model.CoreDataBuilder;
import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.InputBuilder;
import interview.ad.placement.model.Placement;
import interview.ad.placement.utils.DateUtils;

import org.junit.Assert;

public class CoreDataBuilderUnitTests {
	
	private CoreData data;
	
	@Test
	public void testWithCorrectData() {
		Input input = new InputBuilder()
						.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 33427))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 30311))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 38048))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 38673))
						.build();
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 1), data.getDeliveries().get(1).get(0).getDate());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 5), data.getDeliveries().get(1).get(4).getDate());	
	}
	
	
	@Test
	public void testWithDeliveryWithMixedDateOrder() {
		Input input = new InputBuilder()
						.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 38048))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 38673))
						.build();

		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 1), data.getDeliveries().get(1).get(0).getDate());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 5), data.getDeliveries().get(1).get(4).getDate());	
	}
	
	@Test
	public void testWithDeliveryAndNoPlacement() {
		Input input = new InputBuilder()
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 38048))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 38673))
						.build();
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(0, data.getPlacements().size());
		Assert.assertEquals(null, data.getDeliveries().get(1));	
	}
	
	@Test
	public void testWithDeliveryisEarlierThenStartDate() {
		Input input = new InputBuilder()
						.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 38048))
						.add(new Delivery(1, DateUtils.getDate(2020, 10, 4), 32167))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 38673))
						.build();
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(4, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testWithDeliveryisLaterThenEndDate() {
		Input input = new InputBuilder()
						.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
						.add(new Delivery(1, DateUtils.getDate(2020, 12, 1), 38048))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 38673))
						.build();
				
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(4, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testWithDeliveryisEqualsToEndDate() {
		Input input = new InputBuilder()
						.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 20), 38048))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
						.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 38673))
						.build();
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testWithDeliveryisEqualsToStartDate() {
		Input input = new InputBuilder()
				.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 38048))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 38673))
				.build();
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testWithTowDiffrentPlacments() {
		Input input = new InputBuilder()
							.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
							.add(new Placement(2, "Business", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
							.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
							.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
							.add(new Delivery(2, DateUtils.getDate(2020, 11, 1), 38048))
							.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
							.add(new Delivery(2, DateUtils.getDate(2020, 11, 2), 38673))
							.build();
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(2, data.getPlacements().size());
		Assert.assertEquals(3, data.getDeliveries().get(1).size());	
		Assert.assertEquals(2, data.getDeliveries().get(2).size());	
	}
	
	@Test
	public void testTowCallingToDataBuilderWithOnePlacement() {
		Input input = new InputBuilder()
				.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 38048))
				.build();

		
		data = new CoreDataBuilder().add(input).build();
		
		input = new InputBuilder()
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 2), 38673))
				.build();
		
		data = new CoreDataBuilder().add(data).add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testTowCallingToDataBuilderWithTowPlacement() {
		Input input = new InputBuilder()
				.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 33427))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 30311))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 1), 38048))
				.build();

		
		data = new CoreDataBuilder().add(input).build();
		
		input = new InputBuilder()
				.add(new Placement(2, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5))
				.add(new Delivery(1, DateUtils.getDate(2020, 11, 4), 32167))
				.add(new Delivery(2, DateUtils.getDate(2020, 11, 2), 38673))
				.build();
		
		data = new CoreDataBuilder().add(input).add(data).build();

		
		Assert.assertEquals(2, data.getPlacements().size());
		Assert.assertEquals(3, data.getDeliveries().get(1).size());	
		Assert.assertEquals(1, data.getDeliveries().get(2).size());	
	}
}
