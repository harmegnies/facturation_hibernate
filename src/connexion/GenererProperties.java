package connexion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class GenererProperties {

	/*
	 * code qui va cr�er un objet Properties et qui va sauvegarder les renseignements dans un fichier texte
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties props = new Properties();
		props.put("serveur", "localhost");
		props.put("admin", "root");
		props.put("password", "");
		props.put("database", "facturationmf");
		
		// �crire les donn�es du Properties dans un fichier texte
		String path = "properties/paramsJDBC.properties"; // chemin 
		File file = new File(path);
		try {
			FileWriter fw = new FileWriter(file);
			props.store(fw, "mes param�tres de connexion");
			// utilisation de la m�thode store pour sauvegarder directement
			fw.close();
			System.out.println("�criture r�ussie");
		} 
		catch (IOException e) {			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
