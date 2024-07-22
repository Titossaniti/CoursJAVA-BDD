import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start bdd connexion");
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

        //CREATE TABLE
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url2, user, passwd);
            System.out.println("Connecté");

            String newTable = "CREATE TABLE IF NOT EXISTS nouvelleTable(nom VARCHAR(50), prenom VARCHAR(50))";
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

        // INSERTION DANS UNE TABLE
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(url2, user, passwd);
//            System.out.println("Connecté");
//            String ajoutDansTable = "INSERT INTO nouvelletable(nom,prenom) VALUES(?,?)";
//            PreparedStatement st = conn.prepareStatement(ajoutDansTable);
//            st.setString(1, "Max");
//            st.setString(2, "Verstapen");
//            st.execute();
//            st.close();
//            conn.close();
//            System.out.println("Personne ajoutée");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Erreur");
//            System.exit(0);
//        }

        // SELECT POUR AFFICHER
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url2, user, passwd);
            System.out.println("Connecté");

            String displayTable = "SELECT * FROM nouvelleTable WHERE nom=?";
            PreparedStatement st = conn.prepareStatement(displayTable);
            st.setString(1, "Alesi");
            ResultSet rs = st.executeQuery();
            int count = 0;
            while (rs.next()) {
                count ++;
                System.out.println(count + " : " + rs.getString(1) + "\t" + rs.getString(2));
            }

            st.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur");
            System.exit(0);
        }

    }

}