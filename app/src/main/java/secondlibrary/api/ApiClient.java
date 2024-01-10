package secondlibrary.api;

import com.squareup.moshi.Json;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import secondlibrary.domain.Intercambio;
import secondlibrary.domain.OfertaIntercambio;
import secondlibrary.domain.Usuario;

import java.util.List;

public class ApiClient {
    public interface UsuarioService{
        @POST("usuarios/login")
        Call<Usuario> login(@Body Usuario usuario);
        @POST("usuarios")
        Call<Usuario> registrar(@Body Usuario usuario);
    }

    public interface OfertaIntercambioService{
        @GET("ofertaIntercambios")
        Call<List<OfertaIntercambio>> getOfertasIntercambios();
    }

    public interface ComentarioService{

    }


    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.130:8081/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
    private UsuarioService usuarioService;

    private OfertaIntercambioService ofertaIntercambiosService;

    private ComentarioService comentarioService;

    private static final ApiClient apiClient = new ApiClient();

    public static ApiClient getInstance(){
        return apiClient;
    }

    private ApiClient(){

    }

    public UsuarioService getUsuarioService(){
        if(usuarioService==null) {
            usuarioService = retrofit.create(UsuarioService.class);
        }
        return usuarioService;
    }

    public OfertaIntercambioService getOfertaIntercambioService(){
        if(ofertaIntercambiosService==null) {
            ofertaIntercambiosService = retrofit.create(OfertaIntercambioService.class);
        }
        return ofertaIntercambiosService;
    }

    public ComentarioService getComentarioService(){
        if(comentarioService==null) {
            comentarioService = retrofit.create(ComentarioService.class);
        }
        return comentarioService;
    }
}
