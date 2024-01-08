package secondlibrary.api;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiBookClient {

    private static final String apiKey = "";

    public interface BookService {

    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api2.isbndb.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
}
