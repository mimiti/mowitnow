package mowitnow.data;
public class OrientedPosition {
	
	private Position positionMower;
	private Utils.Orientation orientedMower;

	public OrientedPosition(Position pPositionMower,
			Utils.Orientation pOrientationMower) {
		this.positionMower = pPositionMower;
		this.orientedMower = pOrientationMower;
	}

	public Utils.Orientation getOrientationMower() {
		return orientedMower;
	}

	public void setOrientationMower(Utils.Orientation pOrientationMower) {
		this.orientedMower = pOrientationMower;
	}

	public Position getPositionMower() {
		return positionMower;
	}

	public void setPositionMower(Position pPositionMower) {
		this.positionMower = pPositionMower;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrientedPosition other = (OrientedPosition) obj;
		if (positionMower == null) {
			if (other.positionMower != null)
				return false;
			} else if (!positionMower.equals(other.positionMower))
				return false;
		if (orientedMower != other.orientedMower)
			return false;
		return true;
	}
}