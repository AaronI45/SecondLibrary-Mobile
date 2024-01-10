package secondlibrary.domain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.squareup.moshi.Json;

import java.util.Objects;

@Entity(tableName = "intercambios")
public class Intercambio implements Parcelable {
    @PrimaryKey
    @Json (name = "idIntercambio")
    private int idIntercambio;
    @Json(name = "Comerciante_idComerciante")
    private int idComerciante;
    @Json(name = "Usuario_idUsuario")
    private int idUsuario;
    @Json(name = "isbnComerciante")
    private String isbnComerciante;
    @Json(name = "isbnUsuario")
    private String isbnUsuario;
    @Json(name = "estadoIntercambio")
    private String estadoIntercambio;
    @Json(name = "estadoLibro")
    private String estadoLibro;
    @Json(name = "fechaDeCreacion")
    private String fechaDeCreacion;
    @Json(name = "fechaDeFinalizacion")
    private String fechaDeFinalizacion;

    public Intercambio(int idIntercambio, int idComerciante, int idUsuario, String isbnComerciante, String isbnUsuario, String estadoIntercambio, String estadoLibro, String fechaDeCreacion, String fechaDeFinalizacion) {
        this.idIntercambio = idIntercambio;
        this.idComerciante = idComerciante;
        this.idUsuario = idUsuario;
        this.isbnComerciante = isbnComerciante;
        this.isbnUsuario = isbnUsuario;
        this.estadoIntercambio = estadoIntercambio;
        this.estadoLibro = estadoLibro;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    public Intercambio(){}

    protected Intercambio(@NonNull Parcel in) {
        idIntercambio = in.readInt();
        idComerciante = in.readInt();
        idUsuario = in.readInt();
        isbnComerciante = in.readString();
        isbnUsuario = in.readString();
        fechaDeCreacion = in.readString();
        fechaDeFinalizacion = in.readString();
    }

    public static final Creator<Intercambio> CREATOR = new Creator<Intercambio>() {
        @Override
        public Intercambio createFromParcel(Parcel in) {
            return new Intercambio(in);
        }

        @Override
        public Intercambio[] newArray(int size) {
            return new Intercambio[size];
        }
    };

    public int getIdIntercambio() {
        return idIntercambio;
    }

    public void setIdIntercambio(int idIntercambio) {
        this.idIntercambio = idIntercambio;
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

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    public void setFechaDeFinalizacion(String fechaDeFinalizacion) {
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(idIntercambio);
        parcel.writeInt(idComerciante);
        parcel.writeInt(idUsuario);
        parcel.writeString(isbnComerciante);
        parcel.writeString(isbnUsuario);
        parcel.writeString(estadoIntercambio);
        parcel.writeString(estadoLibro);
        parcel.writeString(fechaDeCreacion);
        parcel.writeString(fechaDeFinalizacion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intercambio that = (Intercambio) o;
        return idIntercambio == that.idIntercambio && idComerciante == that.idComerciante && idUsuario == that.idUsuario && Objects.equals(isbnComerciante, that.isbnComerciante) && Objects.equals(isbnUsuario, that.isbnUsuario) && Objects.equals(fechaDeCreacion, that.fechaDeCreacion) && Objects.equals(fechaDeFinalizacion, that.fechaDeFinalizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIntercambio, idComerciante, idUsuario, isbnComerciante, isbnUsuario, fechaDeCreacion, fechaDeFinalizacion);
    }
}
