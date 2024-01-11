package secondlibrary.api;

import com.squareup.moshi.Json;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.*;
import secondlibrary.domain.Intercambio;
import secondlibrary.domain.OfertaIntercambio;
import secondlibrary.domain.Usuario;

import java.util.List;
import java.util.Map;

public class ApiClient {
    public interface UsuarioService{
        @POST("usuarios/login")
        Call<Usuario> login(@Body Usuario usuario);
        @POST("usuarios")
        Call<Usuario> registrar(@Body Usuario usuario);
        @GET("usuarios/{idUsuario}")
        Call<Usuario> getUsuario(@Path("idUsuario") int idUsuario);
        @PUT("usuarios/{idUsuario}")
        Call<Usuario> actualizarUsuario(@HeaderMap Map<String, String> headers, @Path("idUsuario") int idUsuario, @Body Usuario usuario);
    }

    public interface OfertaIntercambioService{
        @GET("ofertaIntercambios")
        Call<List<OfertaIntercambio>> getOfertasIntercambios();
    }

    public interface ComentarioService{
        @GET("comentarios/comerciantes/calificacion/{idComerciante}")
        Call<Double> getCalificacionComerciante(@Path("idComerciante") int idComerciante);
        @GET("comentarios/comerciantes/count/{idComerciante}")
        Call<Integer> getNumeroComentariosComerciante(@Path("idComerciante") int idComerciante);
    }

    //intercambios ya finalizados
    public interface IntercambioService{
        @GET("intercambios")
        Call<List<Intercambio>> getIntercambios();
        @POST("intercambios")
        Call<Intercambio> registrarIntercambio(@Header("x-token") String token,@Body Intercambio intercambio);
        @GET("intercambios/usuario{idUsuario}")
        Call<List<Intercambio>> getIntercambioPorIdUsuario(@Path("idUsuario") int idIntercambio);
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.107:8081/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
    private UsuarioService usuarioService;

    private OfertaIntercambioService ofertaIntercambiosService;

    private ComentarioService comentarioService;

    private IntercambioService intercambioService;

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

    public IntercambioService getIntercambioService(){
        if(intercambioService==null) {
            intercambioService = retrofit.create(IntercambioService.class);
        }
        return intercambioService;
    }
}
