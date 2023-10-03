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

@WebServlet("/UpdateDetails")
public class UpdateDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
			System.out.println("conexión exitosa");
			
			// Se crea la instrucción sql
			PreparedStatement st = conn
					.prepareStatement("update estudiante set est_nombre=?, est_email=?, est_telefono=? where est_codigo=?");

			// Se le pasa el parámetro
			st.setString(1, request.getParameter("nombre"));
			st.setString(2, request.getParameter("email"));
			st.setString(3, request.getParameter("telefono"));
			st.setInt(4, Integer.valueOf(request.getParameter("id")));

			// Se ejecuta el Statenment
			st.executeUpdate();

			// Se cierran las conexiones
			st.close();
			conn.close();

			response.sendRedirect("Success.jsp?msg=Update");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
