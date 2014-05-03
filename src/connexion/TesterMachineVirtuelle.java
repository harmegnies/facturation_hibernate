package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TesterMachineVirtuelle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		// les param�tres de connexion
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.1.5:3306/prof";
		String admin = "prof";
		String password = "prof";		
		// v�rifier si le driver est connu
		try {
			Class.forName(driver);
			System.out.println("driver ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("driver inconnu");
		}			
		// cr�er une connexion au serveur via JDBC
		Connection conn = null;		
		try {
			conn = DriverManager.getConnection(url,admin,password);
			System.out.println("param�tres corrects");		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("probl�me de connexion");
		}
	}
}
