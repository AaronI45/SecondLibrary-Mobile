package secondlibrary.main.Activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import secondlibrary.api.ApiClient;
import secondlibrary.api.Book.ApiBookClient;
import secondlibrary.api.Book.LibroResponseJSON;
import secondlibrary.domain.Libro;
import secondlibrary.domain.Usuario;
import secondlibrary.main.Activity.menuprincipal.menu_principal;
import secondlibrary.main.databinding.LoginBinding;

public class login extends AppCompatActivity {

    LoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configurarBotones();
    }

    private void configurarBotones(){


        binding.btnIniciarSesion.setOnClickListener(v -> {
            Usuario usuarioLogin = new Usuario();
            usuarioLogin.setNombreUsuario(binding.editTextUsername.getText().toString());
            usuarioLogin.setContrasena(binding.editTextPassword.getText().toString());
            ApiClient.UsuarioService service = ApiClient.getInstance().getUsuarioService();
            service.login(usuarioLogin).enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, retrofit2.Response<Usuario> response) {
                    if (response.isSuccessful()) {
                        Usuario usuario = response.body();
                        String token = response.headers().get("token");
                        Log.i("SDI", "onResponse: "+token);
                        if (usuario != null) {
                            abrirMenuPrincipal(usuario, token);
                        } else {
                            Log.i("SDI", "onResponse: " + response.body());
                            Toast.makeText(login.this, "Usuario o contraseña incorrectos" + usuario.getNombreUsuario(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    Toast.makeText(login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    Log.i("SDI", "onFailure: "+t.getMessage());
                }
            });
        });

        binding.tvRegistrar.setOnClickListener(v -> {
            abrirRegistro();
        });
    }
    private void abrirMenuPrincipal(Usuario usuario, String token){
        usuario.setTokenLogin(token);
        Log.i("TokenLogin", usuario.getTokenLogin());
        Intent intent = new Intent(this, menu_principal.class);
        intent.putExtra(menu_principal.USUARIO_KEY, usuario);
        startActivity(intent);
    }

    private void abrirRegistro(){
        startActivity(new Intent(this, registrar_usuario.class));
    }

}
