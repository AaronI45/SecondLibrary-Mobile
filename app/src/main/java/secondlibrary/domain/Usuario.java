package secondlibrary.domain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.squareup.moshi.Json;

public class Usuario implements Parcelable {
    public static final int ESTADO_NO_ACTIVO = 1;
    public static final int ESTADO_ACTIVO = 2;
    public static final int ESTADO_BANEADO = 3;
    public static final int ROL_ADMINISTRADOR = 1;
    public static final int ROL_COMERCIANTE = 2;
    private int idUsuario;
    @Json(name="Estado_usuario_idEstado_usuario")
    private int idEstadoUsuario;
    @Json(name="Tipo_usuario_idTipo_usuario")
    private int idRol;
    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;
    private String correo;
    private String token;
    @Json(name = "menssage")
    private String mensaje;
    public Usuario() {
    }
    protected Usuario(@NonNull Parcel in) {
        idUsuario = in.readInt();
        idEstadoUsuario = in.readInt();
        idRol = in.readInt();
        nombreUsuario = in.readString();
        contrasena = in.readString();
        nombre = in.readString();
        apellidoPaterno = in.readString();
        apellidoMaterno = in.readString();
        matricula = in.readString();
        correo = in.readString();
        token = in.readString();
        mensaje = in.readString();
    }

    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return null;
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(int idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(idUsuario);
        parcel.writeInt(idEstadoUsuario);
        parcel.writeInt(idRol);
        parcel.writeString(nombreUsuario);
        parcel.writeString(contrasena);
        parcel.writeString(nombre);
        parcel.writeString(apellidoPaterno);
        parcel.writeString(apellidoMaterno);
        parcel.writeString(matricula);
        parcel.writeString(correo);
        parcel.writeString(token);
        parcel.writeString(mensaje);
    }
}
