package secondlibrary.api.Book;

import com.squareup.moshi.Json;
import secondlibrary.domain.Libro;

public class LibroResponseJSON {
    @Json(name="book")
    private Libro libroResponse;

    public LibroResponseJSON(Libro libroResponse) {
        this.libroResponse = libroResponse;
    }

    public Libro getLibroResponse() {
        return libroResponse;
    }
}
