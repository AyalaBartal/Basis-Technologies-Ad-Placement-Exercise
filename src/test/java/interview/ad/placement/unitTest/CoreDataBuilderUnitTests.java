package interview.ad.placement.unitTest;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import interview.ad.placement.model.CoreData;
import interview.ad.placement.model.CoreDataBuilder;
import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Input;
import interview.ad.placement.model.Placement;
import org.junit.Assert;

public class CoreDataBuilderUnitTests {
	
	private CoreData data;
	
	@Test
	public void testWithCorrectData() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());
		Assert.assertEquals(getDate(2020, 11, 1), data.getDeliveries().get(1).get(0).getDate());
		Assert.assertEquals(getDate(2020, 11, 5), data.getDeliveries().get(1).get(4).getDate());	
	}
	
	
	@Test
	public void testWithDeliveryWithMixedDateOrder() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(1, getDate(2020, 11, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());
		Assert.assertEquals(getDate(2020, 11, 1), data.getDeliveries().get(1).get(0).getDate());
		Assert.assertEquals(getDate(2020, 11, 5), data.getDeliveries().get(1).get(4).getDate());	
	}
	
	@Test
	public void testWithDeliveryAndNoPlacement() {
		Input input = new Input(); 
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(1, getDate(2020, 11, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(0, data.getPlacements().size());
		Assert.assertEquals(null, data.getDeliveries().get(1));	
	}
	
	@Test
	public void testWithDeliveryisEarlierThenStartDate() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(1, getDate(2020, 11, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 10, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(4, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testWithDeliveryisLaterThenEndDate() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(1, getDate(2020, 12, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(4, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testWithDeliveryisEqualsToEndDate() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(1, getDate(2020, 11, 20), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());	
	}
	
	@Test
	public void testWithDeliveryisEqualsToStartDate() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(1, getDate(2020, 11, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());	
	}
	
	public void testWithTowDiffrentPlacments() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Placement(2, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(2, getDate(2020, 11, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(2, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		Assert.assertEquals(2, data.getPlacements().size());
		Assert.assertEquals(3, data.getDeliveries().get(1).size());	
		Assert.assertEquals(2, data.getDeliveries().get(2).size());	
	}
	
	public void testWithTowCallingTpMapFunctionWithOnePlacement() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		input.add(new Delivery(1, getDate(2020, 11, 1), 33427));
		
		data = new CoreDataBuilder().add(input).build();
		
		input = new Input(); 
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(1, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).add(data).build();
		
		Assert.assertEquals(1, data.getPlacements().size());
		Assert.assertEquals(5, data.getDeliveries().get(1).size());	
	}
	
	public void testWithTowCallingTpMapFunctionWithTowPlacement() {
		Input input = new Input(); 
		input.add(new Placement(1, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(1, getDate(2020, 11, 3), 38048));		
		input.add(new Delivery(1, getDate(2020, 11, 4), 32167));
		input.add(new Delivery(2, getDate(2020, 11, 2), 30311));
		
		data = new CoreDataBuilder().add(input).build();
		
		input = new Input();
		input.add(new Placement(2, "Sport", getDate(2020, 11, 1), getDate(2020, 11, 20), 5));
		input.add(new Delivery(2, getDate(2020, 11, 1), 33427));
		input.add(new Delivery(1, getDate(2020, 11, 5), 38673));
		
		data = new CoreDataBuilder().add(data).add(input).build();
		
		Assert.assertEquals(2, data.getPlacements().size());
		Assert.assertEquals(3, data.getDeliveries().get(1).size());	
		Assert.assertEquals(1, data.getDeliveries().get(2).size());	
	}
	
	private Date getDate(int year, int month, int day) {
		return new GregorianCalendar(year, month -1 , day).getTime();
	}
	
}
