package mowitnow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mowitnow.action.FormatLine;
import mowitnow.action.ProcessingMower;
import mowitnow.data.Utils;
import mowitnow.parse.ParseMower;

public class Mower {

	protected static List<String> listResultats;

	public static void main(String... args) throws MowerException, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			Mower instance = new Mower();
			listResultats = instance.executeActionMower(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	* reading/validating the file and launching the clippers
	*
	* @param file
	* @throws MowerException
	* @throws IOException
	* @return List<String>: position of the Mower
	*/
	private List<String> executeActionMower(File fichier)
			throws MowerException, IOException {
		if (!fichier.isFile()) {
			throw new MowerException(Utils.ERREUR_FICHIER_INEXISTANT);
		} else {
			ParseMower parser = new ParseMower();
			Scanner scanner = new Scanner(fichier);
			try {
				executeFirstLigne(parser, scanner);
				return executeNextLigne(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	
	protected void executeFirstLigne(ParseMower parser, Scanner scanner)
			throws MowerException {
		if (scanner.hasNext()) {
			parser.setLawn(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new MowerException(
					Utils.ERREUR_DONNEES_INCORRECTES);
		}
	}


	private List<String> executeNextLigne(ParseMower parser,
			Scanner scanner) throws MowerException {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			parser.setMower(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setDirection(scanner.nextLine());
				listePositions.add(executeAction(parser));
			} else {
				throw new MowerException(Utils.ERREUR_DONNEES_INCORRECTES);
			}
		}
		return listePositions;
	}

	
	private String executeAction(ParseMower parser)
			throws MowerException {
		if (!parser.executeParse()) {
			throw new MowerException(Utils.ERREUR_DONNEES_INCORRECTES);
		} else {
			ProcessingMower traitement = new ProcessingMower();
			traitement.setLawn(FormatLine
					.formatLigneLawn(parser.getLawn()));
			traitement.setPositionMower(FormatLine
					.formatLigneMower(parser.getMower()));
			traitement.setListDirection(FormatLine
					.formatLigneDirection(parser.getDirection()));
			traitement.executeDirections();;
			System.out.println(traitement);
			return traitement.toString();
		}
	}
}