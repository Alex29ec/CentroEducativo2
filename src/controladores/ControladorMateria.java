package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Materia;

public class ControladorMateria {
	public static String nombreTabla = "centro.materia";

	public static List<Materia> getTodos(int idNivel) {
		List<Materia> l = new ArrayList<Materia>();
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("SELECT * FROM centro.materia where idNivel=" + idNivel);
			while (rs.next()) {
				Materia o = getEntidadfromCurso(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}

	public static Materia getEntidadfromCurso(ResultSet rs) throws SQLException {
		Materia o = null;

		o = new Materia();
		o.setId(rs.getInt("id"));
		o.setNombre(rs.getString("nombre"));
		o.setIdnivel(rs.getInt("idNivel"));
		o.setCodigo(rs.getString("codigo"));
		o.setUrlClassroom(rs.getString("urlClassroom"));
		o.setAdmitematricula(rs.getBoolean("admiteMatricula"));
		o.setFechaInicio(rs.getString("fechaInicio"));

		return o;
	}
}
