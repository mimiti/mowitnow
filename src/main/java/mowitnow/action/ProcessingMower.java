package mowitnow.action;
import java.util.ArrayList;
import java.util.List;

import mowitnow.MowerException;
import mowitnow.data.Lawn;
import mowitnow.data.OrientedPosition;
import mowitnow.data.Utils;
import mowitnow.data.Utils.DirectionMower;
public class ProcessingMower {

	private Lawn lawn;
	private OrientedPosition positionMower;
	private List<Utils.DirectionMower> listeDirection;
	
	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}
	
	public void setPositionMower(OrientedPosition positionMower) {
		this.positionMower = positionMower;
	}

	public void setListDirection(
			List<Utils.DirectionMower> pListeDirection) {
		this.listeDirection = pListeDirection;
		if(pListeDirection == null){
			listeDirection = new ArrayList<DirectionMower>();
		}
	}
	
	public void executeDirections() throws MowerException{
		for(DirectionMower instruction : listeDirection){
			ProcessingDirection.executeDirection(positionMower,
					instruction, this.lawn.getPositionMax());
		}
	}

	public String toString(){
		return 	positionMower.getPositionMower().getX() 
				+ " " 
				+ positionMower.getPositionMower().getY()
				+ " " 
				+ positionMower.getOrientationMower().getCdOrientation() ;
	}
}