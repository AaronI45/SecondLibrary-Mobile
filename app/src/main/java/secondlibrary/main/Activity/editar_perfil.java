package secondlibrary.main.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import secondlibrary.main.R;
import secondlibrary.main.databinding.EditarPerfilBinding;

public class editar_perfil extends AppCompatActivity {

public static String USUARIO_KEY = "usuario";

private EditarPerfilBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = EditarPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}