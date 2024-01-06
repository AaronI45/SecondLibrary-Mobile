package secondlibrary.api.usuarios;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import secondlibrary.domain.Usuario;

public class ApiUsuarioClient{
    public interface UsuarioService {
        @POST("usuarios/login")
        Call<UsuarioLogin> login (@Body Usuario usuario);

        @POST("usuarios/")
        Call<Usuario> registrar (@Body Usuario usuario);
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.102:8081/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    private UsuarioService service;

    private static final ApiUsuarioClient apiClient = new ApiUsuarioClient();

    public static ApiUsuarioClient getInstance(){
        return apiClient;

    }

    private ApiUsuarioClient(){}

    public UsuarioService getService(){
        if(service==null) {
            service = retrofit.create(UsuarioService.class);
        }
        return service;
    }
}
