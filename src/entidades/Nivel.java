package entidades;

public class Nivel {
private int id;
private String descripcion;
private int idCentro;

public int getId() {
	return id;
}
@Override
public String toString() {
	return descripcion;
}
public void setId(int id) {
	this.id = id;
}
public String getDesccripcion() {
	return descripcion;
}
public void setDesccripcion(String desccripcion) {
	this.descripcion = desccripcion;
}
public int getIdCentro() {
	return idCentro;
}
public void setIdCentro(int idCentro) {
	this.idCentro = idCentro;
}
}
