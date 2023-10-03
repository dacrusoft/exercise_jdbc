package jdbc_servlet.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc_servlet.utilidad.DbConexion;

@WebServlet("/SelectDetails")
public class SelectDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Definición de Driver
			Class.forName(DbConexion.driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {

			int id = 0;
			String nombre = "", email = "", telefono = "";

			// Se crea conexión usando DriverManager
			Connection conn = DriverManager.getConnection(DbConexion.url, DbConexion.user, DbConexion.password);
			System.out.println("conexión exitosa");
			
			// Se crea la instrucción sql
			PreparedStatement st = conn.prepareStatement("select * from estudiante where est_codigo=?");

			// Se le pasa el parámetro
			st.setInt(1, Integer.valueOf(request.getParameter("id")));

			// Se ejecuta el Statenment
			ResultSet rs = st.executeQuery();

			// Se hace un ciclo para listar toda la información de la tabla
			while (rs.next()) {
				id = rs.getInt(1);
				nombre = rs.getString(2);
				email = rs.getString(3);
				telefono = rs.getString(4);
			}

			// Se cierran las conexiones
			rs.close();
			st.close();
			conn.close();

			response.sendRedirect("Result.jsp?id=" + id + "&nombre=" + nombre + "&email=" + email + "&telefono=" + telefono);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
