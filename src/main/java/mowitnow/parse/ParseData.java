package mowitnow.parse;

import mowitnow.data.Utils.DirectionMower;
import mowitnow.data.Utils.Orientation;

public class ParseData {

	private ParseData(){

	}

	/**
	* parse the position of the mower and its orientation
	* Position and orientation are provided as 2 numbers and a letter,
	* separated by a space
	* @param mower
	* @return true if the position line is correct, false otherwise
	*/
	public static boolean parseMower(String mower){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(Orientation.NORTH.getCdOrientation())
			.append("|").append(Orientation.SOUTH.getCdOrientation())
			.append("|").append(Orientation.EAST.getCdOrientation())
			.append("|").append(Orientation.WEST.getCdOrientation());
		return mower.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	/**
	* parse the direction line
	* the direction are a sequence of characters (G, D, A) without spaces
	* @param direction
	* @return true if the direction line is correct, false otherwise
	*/
	public static boolean parseListDirection(String direction){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(DirectionMower.AVANCER.getCodeDirection())
		.append("|").append(DirectionMower.DROITE.getCodeDirection())
		.append("|").append(DirectionMower.GAUCHE.getCodeDirection())
		.append(")+");

		return direction.matches(stringBuilder.toString());
	}

	/**
	* parse the position of the lawn
	* the position of the lawn is in the form of 2 numbers separated by space
	* @param lawn
	* @return true if the instruction line is correct, false otherwise
	*/
	public static boolean parseLawn(String lawn){
		return lawn.matches("(\\d+) (\\d+)");
	}
}