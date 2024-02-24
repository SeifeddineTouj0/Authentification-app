import java.sql.*;

public class LoginDao {

    // Méthode pour valider les informations de connexion de l'utilisateur
    public static boolean validate(String name, String pass) {
        boolean status = false; // Initialiser le statut à false

        try {
            // Charger le pilote JDBC MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Établir une connexion à la base de données MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jeetpauth?characterEncoding=latin1",
                "root",
                "seif2001"
            );

            // Préparer une requête SQL pour récupérer les informations d'utilisateur depuis la base de données
            PreparedStatement ps = con.prepareStatement(
                "select * from userreg where name=? and pass=?"
            );

            // Définir les paramètres pour la requête préparée (nom d'utilisateur et mot de passe)
            ps.setString(1, name);
            ps.setString(2, pass);

            // Exécuter la requête pour récupérer les résultats
            ResultSet rs = ps.executeQuery();

            // Si le jeu de résultats contient des lignes, définir le statut à true (indiquant une connexion valide)
            status = rs.next();

            // Fermer le jeu de résultats, la requête préparée et la connexion
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            // Si une exception se produit, afficher le message d'erreur
            System.out.println(e);
        }

        // Renvoyer le statut indiquant si les informations de connexion sont valides
        return status;
    }
}