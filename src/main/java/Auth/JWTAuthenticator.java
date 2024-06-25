package Auth;

/* Esta clase proporciona una implementación concreta del autenticador JWT (esta fue la que se agrego para verificar la extensibilidad del sistema).*/


public class JWTAuthenticator extends AbstractAuthenticator {

    /* Constructor que establece el método de autenticación como "JWT".*/

    public JWTAuthenticator() {
        this.authMethod = "JWT";
    }

    /* Método para autenticar usuarios utilizando tokens JWT.
     username: El nombre de usuario proporcionado para la autenticación.
     password: El token JWT proporcionado para la autenticación (en un caso real, esto sería decodificado y validado, como por dar un ejemplo).
     return: true si la autenticación es exitosa, false en caso contrario.
     Nota: Este método es un ejemplo simplificado. En un escenario real, se decodificaría y validaría el token JWT.*/

    @Override
    public boolean authenticate(String username, String password) {
        return "jwtUser".equals(username) && "jwtPass".equals(password);
    }
}