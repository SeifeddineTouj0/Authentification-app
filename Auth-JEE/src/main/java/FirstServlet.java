

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
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

        // Récupération des valeurs du formulaire HTML (nom d'utilisateur et mot de passe)
        String n = request.getParameter("username");
        String p = request.getParameter("userpass");

        // Validation des informations d'identification en appelant la méthode validate du LoginDao
        if(LoginDao.validate(n, p)) {
            // Si les informations d'identification sont valides, rediriger vers le deuxième servlet (servlet2)
            RequestDispatcher rd = request.getRequestDispatcher("servlet2");
            rd.forward(request,response);
        } else {
            // Si les informations d'identification ne sont pas valides, afficher un message d'erreur et inclure à nouveau le formulaire de connexion
            out.print("Désolé, nom d'utilisateur ou mot de passe incorrect");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.include(request,response);
        }

        out.close();
    }

}
