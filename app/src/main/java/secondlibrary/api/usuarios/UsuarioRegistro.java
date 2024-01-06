package secondlibrary.api.usuarios;

import com.squareup.moshi.Json;

public class UsuarioRegistro extends UsuarioLogin{
    @Json(name = "menssage")
    private String mensaje;

    public UsuarioRegistro(){}
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
