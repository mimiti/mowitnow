package mowitnow.data;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import mowitnow.data.Utils.Orientation;

public class OrientedPositionTest {

	@Test
	public void verify_surcharge_equals() {
		
		OrientedPosition positionT = new OrientedPosition(new Position(5, 5), Orientation.NORTH);
		OrientedPosition positionTOk = new OrientedPosition(new Position(5, 5), Orientation.NORTH);
		OrientedPosition positionTKo = new OrientedPosition(new Position(5, 5), Orientation.SOUTH);
		
		assertThat(positionT.equals(positionTOk)).isTrue();
		assertThat(positionT.equals(positionTKo)).isFalse();
	}

}
