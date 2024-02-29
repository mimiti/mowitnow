package mowitnow.parse;

public class ParseMower {

	private String lawn ;
	private String mower ;
	private String direction ;

	public ParseMower(){
		this.lawn = "";
		this.mower = "";
		this.direction = "";
	}
	
	
	public boolean executeParse(){
		return ParseData.parseMower(mower)
				&& ParseData.parseLawn(lawn)
				&& ParseData.parseListDirection(direction);
	}
	
	public String getLawn() {
		return lawn;
	}

	public void setLawn(String lawn) {
		this.lawn = lawn;
	}

	public String getMower() {
		return mower;
	}

	public void setMower(String mower) {
		this.mower = mower;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}