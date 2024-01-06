package secondlibrary.domain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.squareup.moshi.Json;

public class Intercambio implements Parcelable {
    private int idIntercambio;
    @Json(name = "id_libro")
    private int idComerciante;
    @Json(name = "Usuario_idUsuario")
    private int idUsuario;
    private String isbnComerciante;
    private String isbnUsuario;
    private String fechaDeCreacion;
    private String fechaDeFinalizacion;

    public Intercambio(int idIntercambio, int idComerciante, int idUsuario, String isbnComerciante, String isbnUsuario, String fechaDeCreacion, String fechaDeFinalizacion) {
        this.idIntercambio = idIntercambio;
        this.idComerciante = idComerciante;
        this.idUsuario = idUsuario;
        this.isbnComerciante = isbnComerciante;
        this.isbnUsuario = isbnUsuario;
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
            parcel.writeString(fechaDeCreacion);
            parcel.writeString(fechaDeFinalizacion);
    }
}
