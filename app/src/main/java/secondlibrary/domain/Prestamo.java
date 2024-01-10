package secondlibrary.domain;

public class Prestamo {
    private int id;
    private int idComerciante;
    private int idUsuario;
    private String isbnComerciante;
    private String isbnUsuario;
    private String estadoIntercambio;
    private String estadoLibro;
    private String fechaCreacion;
    private String fechaFinalizacion;

    public Prestamo() {
    }

    public Prestamo(int id, int idComerciante, int idUsuario, String isbnComerciante, String isbnUsuario, String estadoIntercambio, String estadoLibro, String fechaCreacion, String fechaFinalizacion) {
        this.id = id;
        this.idComerciante = idComerciante;
        this.idUsuario = idUsuario;
        this.isbnComerciante = isbnComerciante;
        this.isbnUsuario = isbnUsuario;
        this.estadoIntercambio = estadoIntercambio;
        this.estadoLibro = estadoLibro;
        this.fechaCreacion = fechaCreacion;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdComerciante() {
        return idComerciante;
    }

    public void setIdComerciante(int idComerciante) {
        this.idComerciante = idComerciante;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIsbnComerciante() {
        return isbnComerciante;
    }

    public void setIsbnComerciante(String isbnComerciante) {
        this.isbnComerciante = isbnComerciante;
    }

    public String getIsbnUsuario() {
        return isbnUsuario;
    }

    public void setIsbnUsuario(String isbnUsuario) {
        this.isbnUsuario = isbnUsuario;
    }

    public String getEstadoIntercambio() {
        return estadoIntercambio;
    }

    public void setEstadoIntercambio(String estadoIntercambio) {
        this.estadoIntercambio = estadoIntercambio;
    }

    public String getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
