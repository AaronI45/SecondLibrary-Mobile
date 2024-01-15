package secondlibrary.main.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import secondlibrary.main.R;

public class chat extends AppCompatActivity {

    private EditText mensajeIngresado;
    private FrameLayout layoutSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        mensajeIngresado = findViewById(R.id.mensajeIngresado);
        layoutSend = findViewById(R.id.layoutSend);

        layoutSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = mensajeIngresado.getText().toString();

                //Enviar el mensaje al servidor
                clienteGrpc.enviarMensaje(mensaje);
            }
        });
    }
}