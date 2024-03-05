package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.CentroEducativo;


public class ControladorCentro {
	

	public static String nombreTabla = "centro.centroeducativo";
	
	public static List<CentroEducativo> getTodos() {
		List<CentroEducativo> l = new ArrayList<CentroEducativo>();
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + nombreTabla);
			while (rs.next()) {
				CentroEducativo o = getEntidadfromCurso(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}
	private static CentroEducativo getEntidadfromCurso(ResultSet rs) throws SQLException {
		CentroEducativo o = null;

		o = new CentroEducativo();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));

		return o;
	}
}
