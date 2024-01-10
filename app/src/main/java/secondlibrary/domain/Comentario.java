package secondlibrary.domain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.squareup.moshi.Json;

public class Comentario implements Parcelable {
    private int idComentario;
    @Json(name = "Comerciante_idComerciante")
    private int idComerciante;
    @Json(name = "Usuario_idUsuario")
    private int idUsuario;
    private String titulo;
    private float calificacion;
    private String descripcion;

    public Comentario() {
    }

    protected Comentario(@NonNull Parcel in) {
        idComentario = in.readInt();
        idComerciante = in.readInt();
        idUsuario = in.readInt();
        titulo = in.readString();
        calificacion = in.readFloat();
        descripcion = in.readString();
    }

    public static final Creator<Comentario> CREATOR = new Creator<Comentario>() {
        @Override
        public Comentario createFromParcel(Parcel in) {
            return new Comentario(in);
        }

        @Override
        public Comentario[] newArray(int size) {
            return new Comentario[size];
        }
    };

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(idComentario);
        parcel.writeInt(idComerciante);
        parcel.writeInt(idUsuario);
        parcel.writeString(titulo);
        parcel.writeFloat(calificacion);
        parcel.writeString(descripcion);
    }
}
