

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
 // Méthode pour gérer les requêtes POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Définition du type de contenu de la réponse comme étant HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Récupération de la valeur du paramètre "username" du formulaire HTML
        String n = request.getParameter("username");

        // Affichage d'un message de bienvenue avec le nom d'utilisateur récupéré
        out.print("Bienvenue " + n);

        // Fermeture du flux de sortie
        out.close();
    }

}
