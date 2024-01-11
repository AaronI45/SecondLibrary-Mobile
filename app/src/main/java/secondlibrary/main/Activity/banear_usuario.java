package secondlibrary.main.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import secondlibrary.main.R;

public class banear_usuario extends AppCompatActivity {

    public static String USUARIO_KEY = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banear_usuario);
    }
}