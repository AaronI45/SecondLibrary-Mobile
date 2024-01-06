package secondlibrary.api.usuarios;

import secondlibrary.domain.Usuario;

public class UsuarioLogin {
    @com.squareup.moshi.Json(name = "usuario")
    private Usuario usuario;
    @com.squareup.moshi.Json(name = "token")
    private String token;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
