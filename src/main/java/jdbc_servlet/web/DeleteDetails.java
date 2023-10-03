package jdbc_servlet.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc_servlet.utilidad.DbConexion;

@WebServlet("/DeleteDetails")
public class DeleteDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Definición de Driver
			Class.forName(DbConexion.driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			// Se crea conexión usando DriverManager
			Connection conn = DriverManager.getConnection(DbConexion.url, DbConexion.user, DbConexion.password);
			System.out.println("Coneción exitosa");
			
			// Se crea la instrucción sql
			PreparedStatement st = conn.prepareStatement("delete from estudiante where est_codigo=?");

			// Se le pasa el parámetro
			st.setInt(1, Integer.valueOf(request.getParameter("id")));

			// Se ejecuta el Statenment
			st.executeUpdate();

			// Cerrar Conexión y Statenment
			st.close();
			conn.close();

			// Se envía mensaje al view
			response.sendRedirect("Success.jsp?msg=Delete");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
