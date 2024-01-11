package secondlibrary.main.Activity;

import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import secondlibrary.api.ApiClient;
import secondlibrary.domain.Intercambio;
import secondlibrary.domain.Usuario;
import secondlibrary.main.R;
import secondlibrary.main.databinding.OrganizarIntercambioBinding;

public class organizar_intercambio extends AppCompatActivity {

    public static String INTERCAMBIO = "intercambio";
    public static String LIBRO = "libro";

    public static String USUARIO_KEY = "usuario";

    private OrganizarIntercambioBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = OrganizarIntercambioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        binding.setIntercambio(extras.getParcelable(INTERCAMBIO));
        binding.setUsuario(extras.getParcelable(USUARIO_KEY));
        binding.setLibro(extras.getParcelable(LIBRO));

        configurarTexto();

        binding.btnRegistrarIntercambio.setOnClickListener(v -> {
            String isbn = binding.editTextIsbn.getText().toString();
            if (isbn.isEmpty()) {
                Toast.makeText(this, "Ingresa un ISBN", Toast.LENGTH_SHORT).show();
            }else{
                int idOfertaIntercambio = binding.getIntercambio().getIdIntercambio();
                Intercambio intercambioRegistro = new Intercambio();
                intercambioRegistro.setIdOfertaIntercambio(idOfertaIntercambio);
                intercambioRegistro.setIsbnUsuario(isbn);
                intercambioRegistro.setIdUsuario(binding.getUsuario().getIdUsuario());

                ApiClient.IntercambioService service = ApiClient.getInstance().getIntercambioService();
                service.registrarIntercambio(binding.getUsuario().getTokenLogin(), intercambioRegistro).enqueue(new Callback<Intercambio>() {
                    @Override
                    public void onResponse(Call<Intercambio> call, Response<Intercambio> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(organizar_intercambio.this, "Intercambio registrado", Toast.LENGTH_SHORT).show();
                            irMenuPrincipal();
                        }else{
                            Log.i("Error", response.message());
                            Toast.makeText(organizar_intercambio.this, "Error al registrar intercambio", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Intercambio> call, Throwable t) {
                        Log.i("Error", t.getMessage());
                        Toast.makeText(organizar_intercambio.this, "Error al registrar intercambio", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void configurarTexto(){
        binding.tituloLibro.setText(binding.getLibro().getTitulo());
        binding.tituloLibro.setText(binding.getLibro().getAutores().get(0));
        binding.edicionLibro.setText(binding.getLibro().getEdicion());

        configurarUsuario();
    }

    private void configurarUsuario(){
        ApiClient.UsuarioService service = ApiClient.getInstance().getUsuarioService();
        service.getUsuario(binding.getIntercambio().getIdComerciante()).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario comerciante = response.body();
                if(comerciante != null){
                    binding.comercianteDuenio.setText(comerciante.getNombreUsuario());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    private void irMenuPrincipal(){
        finish();
    }
}