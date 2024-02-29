package mowitnow.action;

import mowitnow.MowerException;
import mowitnow.data.OrientedPosition;
import mowitnow.data.Position;
import mowitnow.data.Utils;
import mowitnow.data.Utils.DirectionMower;
import mowitnow.data.Utils.Orientation;

public  class ProcessingDirection {

	private ProcessingDirection(){

	}
	/**
	* move the mower forward
	* @param mower position: initial position of the mower
	* @param coordinatesMax: coordinates of the lawn - upper right corner of the lawn
	* @return coordinates: new coordinates of the mower
	* @throws MowerException
	*/
	public static Position moveForwardMower(OrientedPosition positionMower, Position positionMax) throws MowerException
	{
		Position nextPosition = null;
		int x, y;
		switch (positionMower.getOrientationMower()) {
		case NORTH:
			x = positionMower.getPositionMower().getX();
			y = positionMower.getPositionMower().getY() + 1;
			break;
		case EAST:
			x = positionMower.getPositionMower().getX() + 1;
			y = positionMower.getPositionMower().getY();
			break;
		case SOUTH:
			x = positionMower.getPositionMower().getX();
			y = positionMower.getPositionMower().getY() - 1;
			break;
		case WEST:
			x = positionMower.getPositionMower().getX() - 1;
			y = positionMower.getPositionMower().getY();
			break;
		default:
			throw new MowerException(Utils.POSITION_INCORRECTE);
		}
		nextPosition = new Position(x, y);
		
		if (nextPosition != null
				&& positionMax.isHorsPositionMax(nextPosition)) {
			return nextPosition;
		} else {
			return positionMower.getPositionMower();
		}
	}
	
	/**
	* rotate the mower to the right
	* @param orientation: initial orientation of the mower
	* @return new orientation
	* @throws MowerException
	*/
	
	public static Orientation rotateRight(Orientation orientation) throws MowerException{
		Orientation nextOrientation = null ;
		switch (orientation){
			case NORTH : 
				nextOrientation =  Orientation.EAST;
				break;
			case EAST : 
				nextOrientation =  Orientation.SOUTH;
				break;
			case SOUTH : 
				nextOrientation =  Orientation.WEST;
				break;
			case WEST : 
				nextOrientation =  Orientation.NORTH;
				break;
			default : 
				throw new MowerException(Utils.ORIENTATION_INCORRECTE);
		}
		return nextOrientation;		
	}
	
	/**
	* pivot the mower to the left
	* @param orientation: initial orientation of the mower
	* @return new orientation
	* @throws MowerException
	*/
	public static Orientation rotateLeft(Orientation orientation) throws MowerException{
		Orientation nextOrientation = null ;
		switch (orientation){
			case NORTH : 
				nextOrientation =  Orientation.WEST; 
				break;
			case EAST : 
				nextOrientation =  Orientation.NORTH; 
				break;
			case SOUTH : 
				nextOrientation =  Orientation.EAST; 
				break;
			case WEST : 
				nextOrientation =  Orientation.SOUTH; 
				break;
			default : 
				throw new MowerException(Utils.ORIENTATION_INCORRECTE);
		}
		return nextOrientation;		
	}

	/**
	* execute a single Direction (A, D or G)
	* @param positionMower
	* @param direction
	* @param positionMax
	* @throws MowerException
	*/
	public static void executeDirection(OrientedPosition positionMower, DirectionMower direction,Position positionMax) throws MowerException{
		
		switch (direction){
			case AVANCER : 
				positionMower.setPositionMower(ProcessingDirection.moveForwardMower(positionMower, positionMax)); 
				break;
			case DROITE : 
				positionMower.setOrientationMower(ProcessingDirection.rotateRight(positionMower.getOrientationMower())); 
				break;
			case GAUCHE : 
				positionMower.setOrientationMower(ProcessingDirection.rotateLeft(positionMower.getOrientationMower())); 
				break;
			default: throw new MowerException(Utils.DIRECTION_INCORRECTE);
		}
	}
}