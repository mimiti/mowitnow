package mowitnow.action;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import mowitnow.data.Lawn;
import mowitnow.data.Position;
import mowitnow.data.Utils.DirectionMower;
import mowitnow.data.Utils.Orientation;

public class FormatLineTest {

	@Test
	public void format_mower_line() {
		assertThat(FormatLine.formatLigneMower("10 15 N").getPositionMower()).isEqualTo(new Position(10, 15));
		assertThat(FormatLine.formatLigneMower("10 15 N").getOrientationMower()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void format_lawn_line() {
		assertThat(FormatLine.formatLigneMower("10 15")).isEqualTo(new Lawn(new Position(10, 15)));
	}

	@Test
	public void format_Direction_line() {
		assertThat(FormatLine.formatLigneDirection("DGAD")).hasSize(4)
				.contains(DirectionMower.DROITE)
				.contains(DirectionMower.GAUCHE)
				.contains(DirectionMower.AVANCER);
	}

	@Test
	public void recuperer_orientation() {
		assertThat(FormatLine.getOrientation('E')).isEqualTo(Orientation.EAST);
		assertThat(FormatLine.getOrientation('N')).isEqualTo(Orientation.NORTH);
		assertThat(FormatLine.getOrientation('S')).isEqualTo(Orientation.SOUTH);
		assertThat(FormatLine.getOrientation('W')).isEqualTo(Orientation.WEST);
		assertThat(FormatLine.getOrientation('a')).isNull();
	}

	

}
