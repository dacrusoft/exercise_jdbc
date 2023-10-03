package jdbc_servlet.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc_servlet.utilidad.DbConexion;

/**
 * Servlet implementation class InsertDetails
 */
public class InsertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName(DbConexion.driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		
		try {
			Connection conn = DriverManager.getConnection(DbConexion.url,DbConexion.user, DbConexion.password);
			System.out.println("connection successful");

			// Query/statement to insert the values
			PreparedStatement st = conn.prepareStatement("insert into estudiante values(?, ?, ?, ?)");

			// set values into the query
			st.setInt(1, Integer.valueOf(request.getParameter("id")));
			st.setString(2, request.getParameter("nombre"));
			st.setString(3, request.getParameter("email"));
			st.setString(4, request.getParameter("telefono"));

			// Execute the query
			st.executeUpdate();

			st.close();
			conn.close();

			// Redirect the response to success page
			response.sendRedirect("Success.jsp?msg=Insert");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
