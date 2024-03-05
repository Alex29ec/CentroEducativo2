package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Nivel;

public class ControladorNivel {
	public static String nombreTabla = "centro.nivel";

	public static List<Nivel> getTodos(int idCentro) {
		List<Nivel> l = new ArrayList<Nivel>();
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("SELECT * FROM centro.nivel where idCentro=" + idCentro);
			while (rs.next()) {
				Nivel o = getEntidadfromCurso(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}

	private static Nivel getEntidadfromCurso(ResultSet rs) throws SQLException {
		Nivel o = null;

		o = new Nivel();
		o.setId(rs.getInt("id"));
		o.setDesccripcion(rs.getString("descripcion"));
		o.setIdCentro(rs.getInt("idCentro"));
		return o;
	}
}
