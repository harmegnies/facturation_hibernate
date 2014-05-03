package testdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import outils.OutilsCollection;
import outils.OutilsConnexion;
import pojo.Adresse;
import pojo.Pays;
import connexion.MyException;
import connexion.Singleton;
import dao.AdresseDao;
import dao.PaysDao;


// objectifs: tester les classes DAO pour Pays et Adresse (voir Pojo)
public class TesterAdresse_PaysDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// r�cup�rer Properties
		String path = "properties/paramsJDBC.properties";
		Properties props = OutilsConnexion.chargerProps(path);
		Connection conn = null;
		PaysDao paysdao = null;
		AdresseDao adressedao = null;

		try {
			conn = Singleton.getInstance(props); // utiliser Singleton
			
			
			// tester PaysDao ...
			// tester Insert
			/*
			Pays pays1 = new Pays();
			pays1.setIdPays(new Integer(0));
			pays1.setNomPays("Belgique");
			paysdao = new PaysDao(conn);
			paysdao.insert(pays1);
			System.out.println("le pays Belgique a �t� ins�r� ...");
			*/
			/*
			Pays[] tabpays = new Pays[3];
			Pays pays1 = new Pays();
			pays1.setIdPays(new Integer(0));
			pays1.setNomPays("France");
			tabpays[0] = pays1;
			Pays pays2 = new Pays();
			pays2.setIdPays(new Integer(0));
			pays2.setNomPays("Allemagne");
			tabpays[1] = pays2;
			Pays pays3 = new Pays();
			pays3.setIdPays(new Integer(0));
			pays3.setNomPays("Angleterre");
			tabpays[2] = pays3;
			paysdao = new PaysDao(conn);
			paysdao.insert(tabpays);
			System.out.println("le tableau des pays a �t� ins�r� ...");
			*/
			/*
			List<Pays> listepays = new ArrayList<Pays>();
			Pays pays1 = new Pays();
			pays1.setIdPays(new Integer(0));
			pays1.setNomPays("Gr�ce");
			listepays.add(pays1);
			Pays pays2 = new Pays();
			pays2.setIdPays(new Integer(0));
			pays2.setNomPays("Espagne");
			listepays.add(pays2);
			paysdao = new PaysDao(conn);
			paysdao.insert(listepays);
			System.out.println("la liste des pays a �t� ins�r� ...");
			*/
			/*
			Pays[] tabpays = new Pays[2];
			Pays pays1 = new Pays();
			pays1.setIdPays(new Integer(0));
			pays1.setNomPays("Italie");
			tabpays[0] = pays1;
			Pays pays2 = new Pays();
			pays2.setIdPays(new Integer(0));
			pays2.setNomPays("Suisse");
			tabpays[1] = pays2;
			paysdao = new PaysDao(conn);
			paysdao.insert2(tabpays);
			System.out.println("le tableau des pays a �t� ins�r� ...");
			*/
			// ok pour les m�thodes insert voir autres m�thodes ...
			
			// r�cup�rer pays belgique
			paysdao = new PaysDao(conn);
			Pays pays = paysdao.find(new Integer(1));
			System.out.println(pays);
			
			// tester insertion Adresse ...
			/*
			Adresse adresse = new Adresse();
			adresse.setNumero("100");
			adresse.setRue("rue des champs");
			adresse.setZipcode("7000");
			adresse.setVille("Mons");
			adresse.setPays(pays);			
			adressedao = new AdresseDao(conn);
			adressedao.insert(adresse);
			System.out.println("Adresse ins�r�e ...");
			*/
			// tester insertion tableau ...
			/*
			Adresse[] tabadresse = new Adresse[2];
			Adresse adresse1 = new Adresse();
			adresse1.setNumero("150");
			adresse1.setRue("rue des champs");
			adresse1.setZipcode("6000");
			adresse1.setVille("Charleroi");
			adresse1.setPays(pays);	
			tabadresse[0] = adresse1;
			Adresse adresse2 = new Adresse();
			adresse2.setNumero("35");
			adresse2.setRue("rue des pr�s");
			adresse2.setZipcode("7100");
			adresse2.setVille("La Louvi�re");
			adresse2.setPays(pays);	
			tabadresse[1] = adresse2;
			
			adressedao = new AdresseDao(conn);
			adressedao.insert(tabadresse);
			System.out.println("tableau des Adresses ins�r� ...");
			*/
			/*
			Adresse[] tabadresse = new Adresse[2];
			Adresse adresse1 = new Adresse();
			adresse1.setNumero("10");
			adresse1.setRue("rue du canal");
			adresse1.setZipcode("6000");
			adresse1.setVille("Charleroi");
			adresse1.setPays(pays);	
			tabadresse[0] = adresse1;
			Adresse adresse2 = new Adresse();
			adresse2.setNumero("100");
			adresse2.setRue("avenue de la lib�ration");
			adresse2.setZipcode("7100");
			adresse2.setVille("La Louvi�re");
			adresse2.setPays(pays);	
			tabadresse[1] = adresse2;
			
			adressedao = new AdresseDao(conn);
			adressedao.insert2(tabadresse);
			System.out.println("tableau des Adresses ins�r� ...");
			*/
			
			// r�cup�rer toutes les adresses
		
			/*
			adressedao = new AdresseDao(conn);
			List<Adresse> liste = adressedao.findAll();
			for (Adresse a : liste)
				System.out.println(a);
			// ok
			*/
			/*
			adressedao = new AdresseDao(conn);
			Adresse addr = adressedao.find(new Integer(5));
			System.out.println(addr);
			// modifier
			Pays p = new Pays();
			p.setIdPays(new Integer(0));
			p.setNomPays("Portugal");
			addr.setPays(p);
			//addr.setPays(null);
			addr.setNumero("1");
			addr.setRue("Bonaventura");
			addr.setVille("Porto");
			addr.setZipcode("4000");
			adressedao.update(addr);
			System.out.println("adresse updat�e ...");
			*/
			
		} 
		catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			if ( conn != null ){
				try {
					conn.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Singleton.reinitialize();
			} 
			catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
