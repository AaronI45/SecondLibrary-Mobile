package secondlibrary.domain;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.squareup.moshi.Json;

public class Libro implements Parcelable {
    @Json(name="title")
    private String titulo;
    @Json(name="authors")
    private String[] autores;
    @Json(name="publisher")
    private String editorial;
    @Json(name="image")
    private String imagenUrl;
    private String isbn;

    public Libro(String titulo, String[] autores, String editorial, String imagenUrl, String isbn) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.imagenUrl = imagenUrl;
        this.isbn = isbn;
    }

    public Libro() {
    }

    protected Libro(@NonNull Parcel in){
        titulo = in.readString();
        autores = in.createStringArray();
        editorial = in.readString();
        imagenUrl = in.readString();
        isbn = in.readString();
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return null;
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeStringArray(autores);
        parcel.writeString(editorial);
        parcel.writeString(imagenUrl);
        parcel.writeString(isbn);
    }
}
