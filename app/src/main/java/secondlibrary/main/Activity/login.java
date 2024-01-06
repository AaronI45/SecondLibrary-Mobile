package secondlibrary.main.Activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import secondlibrary.api.usuarios.ApiUsuarioClient;
import secondlibrary.api.usuarios.UsuarioLogin;
import secondlibrary.domain.Usuario;
import secondlibrary.main.databinding.LoginBinding;

public class login extends AppCompatActivity {

    LoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String email = binding.editTextUsername.getText().toString();
        String password = binding.editTextPassword.getText().toString();

        configurarBotones();
    }

    private void configurarBotones(){
        binding.btnIniciarSesion.setOnClickListener(v -> {
            Usuario usuarioLogin = new Usuario();
            usuarioLogin.setNombreUsuario(binding.editTextUsername.getText().toString());
            usuarioLogin.setContrasena(binding.editTextPassword.getText().toString());
            ApiUsuarioClient.UsuarioService service = ApiUsuarioClient.getInstance().getService();
            service.login(usuarioLogin).enqueue(new Callback<UsuarioLogin>() {
                @Override
                public void onResponse(Call<UsuarioLogin> call, retrofit2.Response<UsuarioLogin> response) {
                    if (response.isSuccessful()) {
                        Usuario usuario = response.body().getUsuario();
                        usuario.setToken(response.body().getToken());
                        if (usuario != null) {
                            abrirMenuPrincipal(usuario);
                        } else {
                            Log.i("SDI", "onResponse: " + response.body());
                            Toast.makeText(login.this, "Usuario o contraseña incorrectos" + usuario.getNombreUsuario(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UsuarioLogin> call, Throwable t) {
                    Toast.makeText(login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    Log.i("SDI", "onFailure: "+t.getMessage());
                }
            });
        });

        binding.tvRegistrar.setOnClickListener(v -> {
            abrirRegistro();
        });
    }
    private void abrirMenuPrincipal(Usuario usuario){
        Log.i("Usuario", usuario.getNombre());
        Intent intent = new Intent(this, menu_principal.class);
        intent.putExtra(menu_principal.USUARIO_KEY, usuario);
        startActivity(intent);
    }

    private void abrirRegistro(){
        startActivity(new Intent(this, registrar_usuario.class));
    }

}
