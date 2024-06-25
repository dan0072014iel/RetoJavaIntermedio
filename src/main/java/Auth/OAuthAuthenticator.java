package Auth;

/* Extiende la clase AbstractAuthenticator para heredar la funcionalidad común.*/

public class OAuthAuthenticator extends AbstractAuthenticator {

    /* Constructor que establece el método de autenticación como "OAUTH". */

    public OAuthAuthenticator() {
        this.authMethod = "OAUTH";
    }

    /* Método para autenticar usuarios utilizando el protocolo OAuth.
     username: El nombre de usuario proporcionado para la autenticación.
     password: La contraseña proporcionada para la autenticación (en OAuth, esto puede ser un token como por dar un ejemplo).
     return: true si la autenticación es exitosa, false en caso contrario.
     Nota: Este método es un ejemplo simplificado. En un escenario real, se realizaría una llamada a un proveedor de OAuth para verificar las credenciales.*/
    @Override
    public boolean authenticate(String username, String password) {
        return "oauthUser".equals(username) && "oauthPass".equals(password);
    }
}