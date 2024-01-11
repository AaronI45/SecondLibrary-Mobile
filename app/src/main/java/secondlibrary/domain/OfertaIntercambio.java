package secondlibrary.domain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.squareup.moshi.Json;

import java.util.Objects;

@Entity(tableName = "oferta_intercambios")
public class OfertaIntercambio implements Parcelable {
    @PrimaryKey
    @Json(name = "idOferta_Intercambio")
    private int idIntercambio;
    @Json(name = "Comerciante_idComerciante")
    private int idComerciante;
    @Json(name = "isbnComerciante")
    private String isbnComerciante;
    @Json(name = "estadoIntercambio")
    private String estadoIntercambio;
    @Json(name = "estadoLibro")
    private String estadoLibro;
    @Json(name = "fechaDeCreacion")
    private String fechaDeCreacion;
    public OfertaIntercambio() {
    }

    public OfertaIntercambio(int idIntercambio, int idComerciante, String isbnComerciante, String estadoIntercambio, String estadoLibro, String fechaDeCreacion, Libro libroIntercambio) {
        this.idIntercambio = idIntercambio;
        this.idComerciante = idComerciante;
        this.isbnComerciante = isbnComerciante;
        this.estadoIntercambio = estadoIntercambio;
        this.estadoLibro = estadoLibro;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    protected OfertaIntercambio(@NonNull Parcel in) {
        idIntercambio = in.readInt();
        idComerciante = in.readInt();
        isbnComerciante = in.readString();
        estadoIntercambio = in.readString();
        estadoLibro = in.readString();
        fechaDeCreacion = in.readString();
    }

    public static final Creator<OfertaIntercambio> CREATOR = new Creator<OfertaIntercambio>() {
        @Override
        public OfertaIntercambio createFromParcel(Parcel in) {
            return new OfertaIntercambio(in);
        }

        @Override
        public OfertaIntercambio[] newArray(int size) {
            return new OfertaIntercambio[size];
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

    public String getIsbnComerciante() {
        return isbnComerciante;
    }

    public void setIsbnComerciante(String isbnComerciante) {
        this.isbnComerciante = isbnComerciante;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfertaIntercambio that = (OfertaIntercambio) o;
        return idIntercambio == that.idIntercambio && idComerciante == that.idComerciante && Objects.equals(isbnComerciante, that.isbnComerciante) && Objects.equals(estadoIntercambio, that.estadoIntercambio) && Objects.equals(estadoLibro, that.estadoLibro) && Objects.equals(fechaDeCreacion, that.fechaDeCreacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idIntercambio, idComerciante, isbnComerciante, estadoIntercambio, estadoLibro, fechaDeCreacion);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeInt(idIntercambio);
            dest.writeInt(idComerciante);
            dest.writeString(isbnComerciante);
            dest.writeString(estadoIntercambio);
            dest.writeString(estadoLibro);
            dest.writeString(fechaDeCreacion);
    }
}
