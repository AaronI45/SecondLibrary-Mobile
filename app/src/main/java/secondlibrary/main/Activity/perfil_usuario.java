package secondlibrary.main.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import secondlibrary.api.ApiClient;
import secondlibrary.api.UtilUsuario;
import secondlibrary.domain.OfertaIntercambio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import secondlibrary.domain.Intercambio;
import java.util.List;
import secondlibrary.main.databinding.PerfilUsuarioBinding;

public class perfil_usuario extends AppCompatActivity {
private PerfilUsuarioBinding binding;

public static String KEY_USUARIO = "usuario";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PerfilUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setUsuario(getIntent().getParcelableExtra(KEY_USUARIO));

        configurarInformacion();
        configurarBotones();
    }

    private void configurarInformacion(){
        binding.nombreUsuario.setText(binding.nombreUsuario.getText().toString() +" "+ binding.getUsuario().getNombre());
        binding.nombre.setText(binding.nombre.getText().toString() +" "+ binding.getUsuario().getNombre());
        binding.apellidoPaterno.setText(binding.apellidoPaterno.getText().toString() +" "+ binding.getUsuario().getApellidoPaterno());
        binding.apellidoMaterno.setText(binding.apellidoMaterno.getText().toString() +" "+ binding.getUsuario().getApellidoMaterno());
        binding.correo.setText(binding.correo.getText().toString() +" "+ binding.getUsuario().getCorreo());
        binding.matricula.setText(binding.matricula.getText().toString() +" "+ binding.getUsuario().getMatricula());
        if(binding.getUsuario().getIdRol() == UtilUsuario.ROL_ADMINISTRADOR){
            binding.btnBanear.setVisibility(View.VISIBLE);
        }

        configurarIntercambios();
    }

    private void configurarBotones(){
        binding.btnBanear.setOnClickListener(v -> {
            irABanearUsuario();
        });

        binding.btnEdicion.setOnClickListener(v -> {
            irAEdicion();
        });
    }

    private void irABanearUsuario(){
        Intent intent = new Intent(this, banear_usuario.class);
        intent.putExtra(banear_usuario.USUARIO_KEY, binding.getUsuario());
        startActivity(intent);
    }

    private void irAEdicion(){
        Intent intent = new Intent(this, editar_perfil.class);
        intent.putExtra(editar_perfil.USUARIO_KEY, binding.getUsuario());
        startActivity(intent);
    }

    private void configurarIntercambios(){
//
//        binding.recyclerPublicaciones.setLayoutManager(new LinearLayoutManager(this));
//
//        IntercambioAdapter adapter = new IntercambioAdapter(this);
//
//        binding.recyclerPublicaciones.setAdapter(adapter);

    }
}