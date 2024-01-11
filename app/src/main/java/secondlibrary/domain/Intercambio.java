package secondlibrary.domain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.squareup.moshi.Json;

import java.util.Objects;

public class Intercambio implements Parcelable {
    @Json(name = "idIntercambio")
    private int idIntercambio;
    @Json (name = "Oferta_Intercambio_idOferta_Intercambio")
    private int idOfertaIntercambio;
    @Json(name = "Usuario_idUsuario")
    private int idUsuario;
    @Json(name = "isbnUsuario")
    private String isbnUsuario;
    @Json(name = "fechaDeFinalizacion")
    private String fechaDeFinalizacion;

    public Intercambio() {
    }

    public Intercambio(int idIntercambio, int idOfertaIntercambio, int idUsuario, String isbnUsuario, String fechaDeFinalizacion) {
        this.idIntercambio = idIntercambio;
        this.idOfertaIntercambio = idOfertaIntercambio;
        this.idUsuario = idUsuario;
        this.isbnUsuario = isbnUsuario;
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    protected Intercambio(@NonNull Parcel in){
        idIntercambio = in.readInt();
        idOfertaIntercambio = in.readInt();
        idUsuario = in.readInt();
        isbnUsuario = in.readString();
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

    public int getIdOfertaIntercambio() {
        return idOfertaIntercambio;
    }

    public void setIdOfertaIntercambio(int idOfertaIntercambio) {
        this.idOfertaIntercambio = idOfertaIntercambio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIsbnUsuario() {
        return isbnUsuario;
    }

    public void setIsbnUsuario(String isbnUsuario) {
        this.isbnUsuario = isbnUsuario;
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
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(idIntercambio);
        dest.writeInt(idOfertaIntercambio);
        dest.writeInt(idUsuario);
        dest.writeString(isbnUsuario);
        dest.writeString(fechaDeFinalizacion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intercambio that = (Intercambio) o;
        return idIntercambio == that.idIntercambio && idOfertaIntercambio == that.idOfertaIntercambio && idUsuario == that.idUsuario && Objects.equals(isbnUsuario, that.isbnUsuario) && Objects.equals(fechaDeFinalizacion, that.fechaDeFinalizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIntercambio, idOfertaIntercambio, idUsuario, isbnUsuario, fechaDeFinalizacion);
    }
}
