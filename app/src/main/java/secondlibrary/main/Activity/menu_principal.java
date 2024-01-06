package secondlibrary.main.Activity;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import secondlibrary.api.usuarios.UsuarioLogin;
import secondlibrary.domain.Usuario;
import secondlibrary.main.R;
import secondlibrary.main.databinding.MenuPrincipalBinding;

public class menu_principal extends AppCompatActivity {

    public static final String USUARIO_KEY = "usuario";

    MenuPrincipalBinding binding;
    Usuario usuarioIniciado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        usuarioIniciado = extras.getParcelable(USUARIO_KEY);

        Log.i("SDI", "onCreate: "+usuarioIniciado.getNombreUsuario());

        //binding.textView2.setText(usuarioIniciado.getNombreUsuario());
    }
}