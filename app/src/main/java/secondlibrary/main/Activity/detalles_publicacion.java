package secondlibrary.main.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import secondlibrary.api.ApiClient;
import secondlibrary.api.Book.ApiBookClient;
import secondlibrary.api.Book.LibroResponseJSON;
import secondlibrary.domain.Libro;
import secondlibrary.main.R;
import secondlibrary.main.databinding.DetallesPublicacionBinding;

import static secondlibrary.main.Activity.organizar_intercambio.INTERCAMBIO;
import static secondlibrary.main.Activity.organizar_intercambio.LIBRO;

public class detalles_publicacion extends AppCompatActivity {

    public static String INTERCAMBIO_KEY = "intercambio";

    public static String USUARIO_KEY = "usuario";

    DetallesPublicacionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetallesPublicacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        binding.setIntercambio(extras.getParcelable(INTERCAMBIO_KEY));
        binding.setUsuario(extras.getParcelable(USUARIO_KEY));

        cargarInformacionLibro();
        binding.txtDescripcion.setText(binding.getIntercambio().getEstadoLibro());
        cargarInformacionComentarios();

        binding.btnOrganizarIntercambio.setOnClickListener(v -> {
           irAOrganizarIntercambio();
        });
    }

    private void cargarInformacionComentarios(){
        ApiClient.ComentarioService service = ApiClient.getInstance().getComentarioService();
        service.getCalificacionComerciante(binding.getIntercambio().getIdComerciante()).enqueue(new Callback<Double>() {
            @Override
            public void onResponse(Call<Double> call, Response<Double> response) {
                if(response.isSuccessful()){
                    Double calificacion = response.body();
                    if(calificacion != null){
                        binding.txtValoracion.setText(calificacion.toString());
                    }else{
                        binding.txtValoracion.setText("0");
                    }
                }
            }

            @Override
            public void onFailure(Call<Double> call, Throwable t) {

            }
        });
        service.getNumeroComentariosComerciante(binding.getIntercambio().getIdComerciante()).enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if(response.isSuccessful()){
                    Integer numeroComentarios = response.body();
                    binding.txtTotalResenas.setText(numeroComentarios.toString());
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });
    }

    private void cargarInformacionLibro(){
        ApiBookClient.BookService service = ApiBookClient.getInstance().getService();
        service.getBook(binding.getIntercambio().getIsbnComerciante()).enqueue(new Callback<LibroResponseJSON>() {
            @Override
            public void onResponse(Call<LibroResponseJSON> call, Response<LibroResponseJSON> response) {
                if(response.isSuccessful()){
                    LibroResponseJSON libroResponseJSON = response.body();
                    if(libroResponseJSON != null){
                        Libro libro = libroResponseJSON.getLibroResponse();
                        binding.setLibro(libro);
                        binding.tituloLibro.setText(libro.getTitulo());
                        binding.edicionLibro.setText("Edición libro: " + libro.getEdicion());
                        ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
                        ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                                .data(libro.getImagenUrl())
                                .target(binding.imagenLibro)
                                .build();
                        imageLoader.enqueue(request);
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<secondlibrary.api.Book.LibroResponseJSON> call, Throwable t) {

            }
        });
    }

    public void irAOrganizarIntercambio() {
        Intent intent = new Intent(this, organizar_intercambio.class);
        intent.putExtra(organizar_intercambio.INTERCAMBIO, binding.getIntercambio());
        intent.putExtra(organizar_intercambio.USUARIO_KEY, binding.getUsuario());
        intent.putExtra(organizar_intercambio.LIBRO, binding.getLibro());
        startActivity(intent);
    }
}