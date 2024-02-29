package mowitnow.data;


public class Position {
	
	private int x;
	private int y;
	
	public Position(int pX, int pY){
		this.x = pX;
		this.y = pY;
	}
	
	public boolean isHorsPositionMax(Position pPosition){
		return pPosition.getX() >= 0 
				&& pPosition.getY() >= 0
				&& pPosition.getX() <= this.x
				&& pPosition.getY() <= this.y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}


	@Override
    public String toString() {
        return String.format("Position [x:%s,y:%s]", this.x, this.y);
    }


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}
}