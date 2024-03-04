package entidades;

public class CentroEducativo {
	private int id;
	private String descripcion;

@Override
public String toString() {
	return descripcion ;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

}
