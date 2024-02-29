package mowitnow.parse;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;


public class ParseMowerTest {
	
	@Test
	public void parse_mower(){
		ParseMower parserTondeuse = new ParseMower();
		parserTondeuse.setDirection("DGDGA");
		parserTondeuse.setLawn("50 5");
		parserTondeuse.setMower("1 2 N");
		assertThat(parserTondeuse.executeParse()).isTrue();
	}
	@Test
	
	public void parse_mower_lawn_incorrect(){
		ParseMower parserTondeuse = new ParseMower();
		parserTondeuse.setDirection("DGDGA");
		parserTondeuse.setLawn("0 -1");
		parserTondeuse.setMower("1 2 N");
		assertThat(parserTondeuse.executeParse()).isFalse();
	}
	
	@Test
	public void parse_mower_empty_data(){
		ParseMower parserTondeuse = new ParseMower();
		assertThat(parserTondeuse.executeParse()).isFalse();
	}
}
