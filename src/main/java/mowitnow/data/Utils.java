package mowitnow.data;


public class Utils {
	
	private Utils(){
		
	}
	
	public static enum Orientation {
		NORTH('N', "North"),
		EAST('E', "East"),
		WEST('W', "West"),
		SOUTH('S', "South");
		
		private char cdOrientation;
		private String labelOrientation;
		
		private Orientation(char codeOrientation, String labelOrientation){
			this.cdOrientation = codeOrientation;
			this.labelOrientation = labelOrientation;
		}
		public char getCdOrientation() {
			return cdOrientation;
		}
		public String getLabelOrientation() {
			return labelOrientation;
		}
	}
	
	
	public static enum DirectionMower{
		DROITE('D', "Pivoter à droite"),
		GAUCHE('G', "Pivoter à gauche"),
		AVANCER('A', "Avancer");
		
		private String labelDirection;
		private char cdDirection;
		
		private DirectionMower(char pCodeDirection, String labelDirection) {
			this.labelDirection = labelDirection;
			this.cdDirection = pCodeDirection;
		}
		
		public String getLabelDirection() {
			return labelDirection;
		}
		public char getCodeDirection() {
			return cdDirection;
		}

	}


	public static final String ERREUR_DONNEES_INCORRECTES= "données incorrectes";
	public static final String ERREUR_FICHIER_INEXISTANT= "fichier inexistant";
	public static final String ORIENTATION_INCORRECTE = "orientation incorrecte";
	public static final String DIRECTION_INCORRECTE = "direction incorrecte";
	public static final String POSITION_INCORRECTE = "position incorrecte";
}