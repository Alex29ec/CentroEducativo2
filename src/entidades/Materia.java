package entidades;

public class Materia {
	
	private int id;
	private String nombre;
	private int idnivel;
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdnivel() {
		return idnivel;
	}
	public void setIdnivel(int idnivel) {
		this.idnivel = idnivel;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUrlClassroom() {
		return urlClassroom;
	}
	public void setUrlClassroom(String urlClassroom) {
		this.urlClassroom = urlClassroom;
	}
	public boolean isAdmitematricula() {
		return admitematricula;
	}
	public void setAdmitematricula(boolean admitematricula) {
		this.admitematricula = admitematricula;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	String codigo;
	String urlClassroom;
	boolean admitematricula;
	String fechaInicio;
}

