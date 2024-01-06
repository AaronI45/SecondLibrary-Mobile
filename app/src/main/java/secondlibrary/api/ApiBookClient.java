package secondlibrary.api;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiBookClient {

    private static final String apiKey = "51338_263bca0ac8ea693171ea0ac17771d185";

    public interface BookService {

    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api2.isbndb.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
}
