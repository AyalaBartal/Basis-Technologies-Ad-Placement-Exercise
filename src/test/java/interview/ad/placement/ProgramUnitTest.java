package interview.ad.placement;

import org.junit.Test;
import org.mockito.Mockito;

import interview.ad.placement.model.Input;
import interview.ad.placement.model.Output;
import interview.ad.placement.service.Core;
import interview.ad.placement.service.Reader;
import interview.ad.placement.service.Writer;

public class ProgramUnitTest {

	@Test
	public void testAssert() {
		Reader reader = Mockito.mock(Reader.class);
		Core core = Mockito.mock(Core.class);
		Writer writer = Mockito.mock(Writer.class);
		Program program = new Program(reader, core, writer);

		String s1 = "a", s2 = "b";
		Input input = Mockito.mock(Input.class);
		Output output = Mockito.mock(Output.class);

		Mockito.when(reader.readFromFiles(s1, s2)).thenReturn(input);
		Mockito.when(core.process(input)).thenReturn(output);
		Mockito.doNothing().when(writer).write(output);

		program.init();

		Mockito.verify(reader, Mockito.times(1)).readFromFiles(s1, s2);
		Mockito.verify(core, Mockito.times(1)).process(input);
		Mockito.verify(writer, Mockito.times(1)).write(output);
	}

}
