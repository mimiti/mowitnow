package mowitnow.action;

import java.util.ArrayList;
import java.util.List;

import mowitnow.data.*;
import mowitnow.data.Utils.DirectionMower;
import mowitnow.data.Utils.Orientation;
public class FormatLine {

	private static final String CHAINE_ESPACE = " ";

	private FormatLine(){

	}

	/**
	* retrieve the position of the mower which is defined by its coordinates and its orientation
	* @param lineMower: line of the position of the mower (ex: 2 3 G)
	* @return the object which defines the position of the mower
	*/
	public static OrientedPosition formatLigneMower(String ligneMower){
		String[] elts = ligneMower.split(CHAINE_ESPACE);
		Position pPositionMower = new Position(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation orientationMower = getOrientation(elts[2].charAt(0));
		return new OrientedPosition(pPositionMower, orientationMower);
	}

	/**
	* retrieve the Lawn object containing the boundary coordinates of the lawn
	* @param lawnline: lawn line (ex: 2 3)
	* @return the object which defines the boundary of the lawn
	*/
	public static Lawn formatLigneLawn(String ligneLawn){
		String[] elts = ligneLawn.split(CHAINE_ESPACE);
		return new Lawn(new Position(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	/**
	* retrieve a list of Mower Instruction enums corresponding to the instruction line
	* @param lineDirection: instruction sequence (ex: GDAGD)
	* @return a list of Mower Instruction enums
	*/
	public static List<DirectionMower> formatLigneDirection(String ligneDirection){
		List<DirectionMower> listDirection = new ArrayList<DirectionMower>();
		for(char direction :ligneDirection.toCharArray()){
			listDirection.add(getDirection(direction));
		}
		return listDirection;
	}

	/**
	* retrieve an Orientation enum corresponding to the orientation character
	* @param cOrientation: orientation character (E, W, N, S)
	* @return the enum corresponding to the orientation
	*/
	public static Orientation getOrientation(char cOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getCdOrientation() == cOrientation){
				return orientation;
			}
		}
		return null;
	}
	/**
	* retrieve a MowerDirection enum corresponding to the direction character
	* @param cDirection: direction character (A, G, D)
	* @return the enum corresponding to the direction
	*/
	public static DirectionMower getDirection(char cDirection){
		for(DirectionMower direction : DirectionMower.values()) {
			if (direction.getCodeDirection() == cDirection) {
				return direction;
			}
		}
		return null;
	}
}