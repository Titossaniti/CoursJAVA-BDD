import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's go.");
        String BDD = "mySQL";
        String url = "jdbc:mysql://localhost:3306/" + BDD + "?characterEncoding=utf8";
        String user = "root";
        String passwd = "";
        String db2 = "user_management";
        String url2 = "jdbc:mysql://localhost:3306/" + db2 +"?characterEncoding=utf8";

        // Vérif connexion à la BDD
        /*
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connecter");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }
        */

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url2, user, passwd);
            System.out.println("Connecté");

            String newTable = "CREATE TABLE IF NOT EXISTS secondeTable(nom VARCHAR(50), prenom VARCHAR(50))";
            PreparedStatement st = conn.prepareStatement(newTable);
            st.execute(newTable);
            st.close();
            conn.close();
            System.out.println("Table crée");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }

    }

}