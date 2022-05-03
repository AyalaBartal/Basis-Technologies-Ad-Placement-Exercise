package interview.ad.placement;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import interview.ad.placement.model.Input;
import interview.ad.placement.service.Reader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Reader.class})
public class ReaderIntegrationTest {

	@Autowired
	private Reader reader;

	@Test
	public void testAssert() {
		Input actual = reader.readFromFiles(null, null);
		Assert.assertEquals(null, actual);
	}

}
