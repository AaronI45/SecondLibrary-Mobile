package secondlibrary.main.Activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import secondlibrary.api.usuarios.ApiUsuarioClient;
import secondlibrary.api.usuarios.UsuarioResponseJSON;
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
            service.login(usuarioLogin).enqueue(new Callback<UsuarioResponseJSON>() {
                @Override
                public void onResponse(Call<UsuarioResponseJSON> call, retrofit2.Response<UsuarioResponseJSON> response) {
                    if (response.isSuccessful()) {
                        UsuarioResponseJSON usuario = response.body();
                        String token = response.headers().get("x-token");
                        if (usuario != null) {
                            abrirMenuPrincipal(usuario, token);
                        } else {
                            Log.i("SDI", "onResponse: " + response.body());
                            Toast.makeText(login.this, "Usuario o contraseña incorrectos" + usuario.getNombreUsuario(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UsuarioResponseJSON> call, Throwable t) {
                    Toast.makeText(login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    Log.i("SDI", "onFailure: "+t.getMessage());
                }
            });
        });

        binding.tvRegistrar.setOnClickListener(v -> {
            abrirRegistro();
        });
    }
    private void abrirMenuPrincipal(UsuarioResponseJSON usuario, String token){
        Usuario usuarioLogin = new Usuario();
        usuarioLogin.setIdUsuario(usuario.getIdUsuario());
        usuarioLogin.setIdEstadoUsuario(usuario.getEstadoUsuarioIdEstadoUsuario());
        usuarioLogin.setIdRol(usuario.getTipoUsuarioIdTipoUsuario());
        usuarioLogin.setNombreUsuario(usuario.getNombreUsuario());
        usuarioLogin.setContrasena(usuario.getContrasena());
        usuarioLogin.setNombre(usuario.getNombre());
        usuarioLogin.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioLogin.setApellidoMaterno(usuario.getApellidoMaterno());
        usuarioLogin.setCorreo(usuario.getCorreo());
        usuarioLogin.setTokenLogin(token);
        Intent intent = new Intent(this, menu_principal.class);
        intent.putExtra(menu_principal.USUARIO_KEY, usuarioLogin);
        startActivity(intent);
    }

    private void abrirRegistro(){
        startActivity(new Intent(this, registrar_usuario.class));
    }

}
