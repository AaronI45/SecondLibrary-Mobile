package secondlibrary.main.Activity.menuprincipal;

import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import secondlibrary.RequestStatus;
import secondlibrary.domain.OfertaIntercambio;
import secondlibrary.main.Activity.detalles_publicacion;
import secondlibrary.main.Activity.perfil_usuario;
import secondlibrary.main.databinding.MenuPrincipalBinding;

public class menu_principal extends AppCompatActivity {

    public static final String USUARIO_KEY = "usuario";


    MenuPrincipalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configurarBotones();
        Bundle extras = getIntent().getExtras();
        binding.setUsuario(extras.getParcelable(USUARIO_KEY));

        Log.i("TOKEN_MENU", binding.getUsuario().getTokenLogin());

        OfertaIntercambioViewModel viewModel = new ViewModelProvider(this,
                new OfertaIntercambioViewModelFactory(getApplication())).get(OfertaIntercambioViewModel.class);

        binding.librosPrestamoRecycler.setLayoutManager(new LinearLayoutManager(this));

        OfertaIntercambioAdapter adapter = new OfertaIntercambioAdapter(this);

        adapter.setOnItemClickListener(ofertaIntercambio -> abrirDetallesOfertaIntercambio(ofertaIntercambio));
        binding.librosPrestamoRecycler.setAdapter(adapter);

        viewModel.getStatusWithDescriptionMutableLiveData().observe(this, statusWithDescription -> {
            if(statusWithDescription.getStatus() == RequestStatus.LOADING){
                binding.loadingWheel.setVisibility(android.view.View.VISIBLE);
            }else{
                binding.loadingWheel.setVisibility(android.view.View.GONE);
            }
            if(statusWithDescription.getStatus() == RequestStatus.ERROR){
                android.widget.Toast.makeText(this,"Comprueba tu conexion a internet", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.descargarOfertaIntercambios();

        viewModel.getListaIntercambios().observe(this, listaIntercambios -> {
            adapter.submitList(listaIntercambios);
        });
    }

    private void abrirDetallesOfertaIntercambio(OfertaIntercambio ofertaIntercambio){
        Log.d("SDI", "abrirDetallesIntercambio: "+ofertaIntercambio.getIdIntercambio());
        Intent intent = new Intent(this, detalles_publicacion.class);
        intent.putExtra(detalles_publicacion.INTERCAMBIO_KEY, ofertaIntercambio);
        intent.putExtra(detalles_publicacion.USUARIO_KEY, binding.getUsuario());
        startActivity(intent);
    }

    private void abrirPerfil(){
        Intent intent = new Intent(this, secondlibrary.main.Activity.perfil_usuario.class);
        intent.putExtra(perfil_usuario.KEY_USUARIO, binding.getUsuario());
        startActivity(intent);
    }


    private void configurarBotones(){
        binding.ivUsuario.setOnClickListener(v -> {
            abrirPerfil();
        });
//        binding.imageIntercambios.setOnClickListener(v -> {
//            abrirPublicacionintercambios();
//        });
//        binding.btnBuscar.setOnClickListener(v -> {
//            abrirBuscar();
//        });
//        binding.btnMisIntercambios.setOnClickListener(v -> {
//            abrirMisIntercambios();
//        });
    }
}