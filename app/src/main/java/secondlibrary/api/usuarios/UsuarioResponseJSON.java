package secondlibrary.api.usuarios;

public class UsuarioResponseJSON {
    @com.squareup.moshi.Json(name = "idUsuario")
    private Integer idUsuario;
    @com.squareup.moshi.Json(name = "Estado_usuario_idEstado_usuario")
    private Integer estadoUsuarioIdEstadoUsuario;
    @com.squareup.moshi.Json(name = "Tipo_Usuario_idTipo_Usuario")
    private Integer tipoUsuarioIdTipoUsuario;
    @com.squareup.moshi.Json(name = "nombreUsuario")
    private String nombreUsuario;
    @com.squareup.moshi.Json(name = "contrasena")
    private String contrasena;
    @com.squareup.moshi.Json(name = "nombre")
    private String nombre;
    @com.squareup.moshi.Json(name = "apellidoPaterno")
    private String apellidoPaterno;
    @com.squareup.moshi.Json(name = "apellidoMaterno")
    private String apellidoMaterno;
    @com.squareup.moshi.Json(name = "matricula")
    private String matricula;
    @com.squareup.moshi.Json(name = "correo")
    private String correo;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getEstadoUsuarioIdEstadoUsuario() {
        return estadoUsuarioIdEstadoUsuario;
    }

    public void setEstadoUsuarioIdEstadoUsuario(Integer estadoUsuarioIdEstadoUsuario) {
        this.estadoUsuarioIdEstadoUsuario = estadoUsuarioIdEstadoUsuario;
    }

    public Integer getTipoUsuarioIdTipoUsuario() {
        return tipoUsuarioIdTipoUsuario;
    }

    public void setTipoUsuarioIdTipoUsuario(Integer tipoUsuarioIdTipoUsuario) {
        this.tipoUsuarioIdTipoUsuario = tipoUsuarioIdTipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
