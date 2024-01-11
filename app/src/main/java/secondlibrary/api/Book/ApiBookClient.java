package secondlibrary.api.Book;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import secondlibrary.domain.Libro;

public class ApiBookClient {

    public interface BookService {
        @Headers({
                "Content-Type: application/json",
                "Authorization: 51338_263bca0ac8ea693171ea0ac17771d185"})
        @GET("book/{isbn}")
        Call<LibroResponseJSON> getBook(@Path("isbn") String isbn);
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api2.isbndb.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    private BookService service;

    private static final ApiBookClient apiClient = new ApiBookClient();

    public static ApiBookClient getInstance(){
        return apiClient;
    }

    private ApiBookClient(){
    }

    public BookService getService(){
        if(service==null) {
            service = retrofit.create(BookService.class);
        }
        return service;
    }
}
