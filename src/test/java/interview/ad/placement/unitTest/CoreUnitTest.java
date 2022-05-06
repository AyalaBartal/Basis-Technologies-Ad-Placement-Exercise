package interview.ad.placement.unitTest;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import interview.ad.placement.model.CoreDataBuilder;
import interview.ad.placement.model.Delivery;
import interview.ad.placement.model.Output;
import interview.ad.placement.model.Placement;
import interview.ad.placement.service.Core;
import utils.DateUtils;

public class CoreUnitTest {
	
	@Test
	public void testNullData() {
		Core core = new Core();
		Output output = core.processDataByPlacement(null);
		
		Assert.assertEquals(0, output.getResult().size());
	}
	
	@Test
	public void testEmptyData() {
		Core core = new Core();
		Output output = core.processDataByPlacement(new CoreDataBuilder().build());
		
		Assert.assertEquals(0, output.getResult().size());
	}
	
	@Test
	public void testDataProcessByPlacementOnePlacementOneDelivery() {
		CoreDataBuilder cdb = new CoreDataBuilder();
		cdb.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 38048));
		
		Core core = new Core();
		Output output = core.processDataByPlacement(cdb.build());
		
		Assert.assertEquals(1, output.getResult().size());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 1), output.getResult().get(0).getStartDate());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 20), output.getResult().get(0).getEndDate());
		Assert.assertEquals(38048, output.getResult().get(0).getImpressions());
		Assert.assertEquals(190, output.getResult().get(0).getCost());
	}
	
	@Test
	public void testDataProcessByPlacementOnePlacementThreeDeliveries() {
		CoreDataBuilder cdb = new CoreDataBuilder();
		cdb.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 5), 38048));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 10), 12345));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 15), 56789));
		
		Core core = new Core();
		Output output = core.processDataByPlacement(cdb.build());
		
		Assert.assertEquals(1, output.getResult().size());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 1), output.getResult().get(0).getStartDate());
		Assert.assertEquals(DateUtils.getDate(2020, 11, 20), output.getResult().get(0).getEndDate());
		Assert.assertEquals(107182, output.getResult().get(0).getImpressions());
		Assert.assertEquals(535, output.getResult().get(0).getCost());
	}
	
	@Test
	public void testDataProcessByPlacementTowPlacementOneDeliveryForEach() {
		CoreDataBuilder cdb = new CoreDataBuilder();
		cdb.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 38048));
		cdb.add(new Placement(2, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 10));
		cdb.add(new Delivery(2, DateUtils.getDate(2020, 11, 3), 38048));
		
		Core core = new Core();
		Output output = core.processDataByPlacement(cdb.build());
		
		Assert.assertEquals(2, output.getResult().size());
	}
	
	@Test
	public void testDataProcessByPlacementTowPlacementThreeDeliveriesForEach() {
		CoreDataBuilder cdb = new CoreDataBuilder();
		cdb.add(new Placement(1, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 5));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 3), 38048));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 15), 25730));
		cdb.add(new Delivery(1, DateUtils.getDate(2020, 11, 20), 478512));
		cdb.add(new Placement(2, "Sport", DateUtils.getDate(2020, 11, 1), DateUtils.getDate(2020, 11, 20), 10));
		cdb.add(new Delivery(2, DateUtils.getDate(2020, 11, 3), 38048));
		cdb.add(new Delivery(2, DateUtils.getDate(2020, 11, 4), 352154));
		cdb.add(new Delivery(2, DateUtils.getDate(2020, 11, 18), 785463));
		
		Core core = new Core();
		Output output = core.processDataByPlacement(cdb.build());
		
		Assert.assertEquals(2, output.getResult().size());
	}

}
