package mowitnow;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import mowitnow.data.Utils;

public class MowerTest {
	final String PATH_FILE = "./src/test/resources/"; 

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test(expected = IllegalArgumentException.class)
	public void main_file_error_args() throws MowerException, IOException {
		Mower.main("1", "2");
	}
	
	@Test
	public void main_file_error_file_noexiste() throws MowerException, IOException {
		expectedEx.expect(MowerException.class);
		expectedEx.expectMessage(Utils.ERREUR_FICHIER_INEXISTANT);
		Mower.main("fichierinexistant");
	}
	
	@Test
	public void main_file_error_1_line() throws MowerException, IOException {
		expectedEx.expect(MowerException.class);
		expectedEx.expectMessage(Utils.ERREUR_DONNEES_INCORRECTES);
		Mower.main(PATH_FILE + "file_1_ligne.txt");
	}
	
	@Test
	public void main_file_error_2_lines() throws MowerException, IOException {
		expectedEx.expect(MowerException.class);
		expectedEx.expectMessage(Utils.ERREUR_DONNEES_INCORRECTES);
		Mower.main(PATH_FILE + "file_2_ligne.txt");
	}
	@Test
	public void main_file_missing_line_error() throws MowerException, IOException {
		expectedEx.expect(MowerException.class);
		expectedEx.expectMessage(Utils.ERREUR_DONNEES_INCORRECTES);
		Mower.main(PATH_FILE + "file_missing_line.txt");

	}
	@Test
	public void main_file_error_empty_file() throws MowerException, IOException {
		expectedEx.expect(MowerException.class);
		expectedEx.expectMessage(Utils.ERREUR_DONNEES_INCORRECTES);
		Mower.main(PATH_FILE + "empty_file.txt");

	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia_ko() throws MowerException, IOException {
		expectedEx.expect(MowerException.class);
		expectedEx.expectMessage(Utils.ERREUR_DONNEES_INCORRECTES);
		Mower.main(PATH_FILE + "file_ko.txt");
	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia() throws MowerException, IOException {
		Mower.main(PATH_FILE + "file_ok.txt");
		assertThat(Mower.listResultats).isNotNull();
		assertThat(Mower.listResultats).hasSize(2).contains("1 3 N").contains("5 1 E");
		
	}
}