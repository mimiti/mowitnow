package mowitnow.data;
public class Lawn {

	private Position positionMax;
	public Lawn(){
		
	}
	public Lawn(Position pPositionMax) {
		this.positionMax = pPositionMax;
	}

	public Position getPositionMax() {
		return positionMax;
	}

	public void setPositionMax(Position positionMax) {
		this.positionMax = positionMax;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lawn other = (Lawn) obj;
		if (positionMax == null) {
			if (other.positionMax != null)
				return false;
			} else if (!positionMax.equals(other.positionMax))
				return false;
		return true;
	}
}