package secondlibrary.main.Activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import secondlibrary.api.usuarios.ApiUsuarioClient;
import secondlibrary.domain.Usuario;
import secondlibrary.main.R;
import secondlibrary.main.databinding.RegistrarUsuarioBinding;

public class registrar_usuario extends AppCompatActivity {

    RegistrarUsuarioBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RegistrarUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setButtons();
    }

    private void setButtons(){
        binding.btnRegistrarUsuario.setOnClickListener(v -> {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(binding.editTextRegistrarNombreUsuario.getText().toString());
            usuario.setContrasena(binding.editTextRegistrarPassword.getText().toString());
            usuario.setNombre(binding.editTextRegistrarNombre.getText().toString());
            usuario.setMatricula(binding.editTextRegistrarMatricula.getText().toString());
            usuario.setApellidoPaterno(binding.editTextRegistrarApellidoPaterno.getText().toString());
            usuario.setApellidoMaterno(binding.editTextRegistrarApellidoMaterno.getText().toString());
            usuario.setCorreo(binding.editTextRegistrarCorreo.getText().toString());
            registrarUsuario(usuario);
        });
    };

    private void registrarUsuario(Usuario usuario){
        ApiUsuarioClient.UsuarioService service = ApiUsuarioClient.getInstance().getService();
        service.registrar(usuario).enqueue(new retrofit2.Callback<Usuario>() {
            @Override
            public void onResponse(retrofit2.Call<Usuario> call, retrofit2.Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario usuario = response.body();
                    if (usuario != null) {
                        Toast.makeText(registrar_usuario.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                        irMenuPrincipal();
                    } else {
                        Toast.makeText(registrar_usuario.this, "Error al registrar usuario: " + response.body().getMensaje(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Usuario> call, Throwable t) {
                Toast.makeText(registrar_usuario.this, "Error al registrar usuario ", Toast.LENGTH_SHORT).show();
                Log.e("SDI", "onFailure: "+t.getMessage());
            }
        });
    }

    private void irMenuPrincipal(){
        Intent intent = new Intent(this, menu_principal.class);
        startActivity(intent);
    }
}