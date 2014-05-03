package testdao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import outils.OutilsConnexion;
import pojo.Pays;
import connexion.MyException;
import connexion.Singleton;
import dao.PaysDao;

public class TesterPaysDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * faire un truncate de la table pour supprimer tous les enregistrements
		 * et recommencer un d�compte de la PK AI � partir de 1
		 * SET FOREIGN_KEY_CHECKS = 0;
		 * instruction pour ne pas tenir compte de l'int�grit� r�f�rentielle
		 * remettre � 1 apr�s op�ration ...
		 */
		
		// r�cup�rer Properties
		String path = "properties/paramsJDBC.properties";
		Properties props = OutilsConnexion.chargerProps(path);
		Connection conn = null;
		PaysDao paysdao = null;
		Pays p = null;
		List<Pays> listePays = null;
		
		// r�cup�rer la liste des pays
		String pathFile = "properties/liste_pays.txt";
		File file = new File(pathFile);
		listePays = new ArrayList();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String ligne = "";
			String[] tab = null;
			while ( (ligne = br.readLine()) != null ){
				tab = ligne.split(";");
				p = new Pays();
				p.setNomPays(tab[1]);
				listePays.add(p);
			}
		} 
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(listePays.toString());
		
		
		// ins�rer ces pays via la classe Dao
		try {
			conn = Singleton.getInstance(props); // utiliser Singleton
			paysdao = new PaysDao(conn);
			paysdao.insert(listePays);
			
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
		System.out.println("Pays ins�r�s dans la table ...");
	}
}
