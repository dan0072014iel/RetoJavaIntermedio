package Manager;

import Factory.AuthenticatorFactory;
import Auth.Authenticator;

/*Esta clase gestiona el proceso de inicio de sesión de usuarios.*/

public class LoginManager {

    private Authenticator authenticator;

    /*Establece el autenticador que se utilizará para verificar las credenciales de inicio de sesión.
     authType: El tipo de autenticador a utilizar ("BASIC", "OAUTH" o "JWT").*/
    public void setAuthenticator(String authType) {
        this.authenticator = AuthenticatorFactory.getAuthenticator(authType);
    }

    /*Intenta iniciar sesión con las credenciales proporcionadas utilizando el autenticador configurado.
     username: El nombre de usuario para iniciar sesión.
     password: La contraseña asociada al nombre de usuario.
     return: true si el inicio de sesión es exitoso, false en caso contrario.
     throws IllegalStateException: Si el autenticador no está configurado.*/

    public boolean login(String username, String password) {
        if (authenticator == null) {
            throw new IllegalStateException("El autenticador no está configurado");
        }
        return authenticator.authenticate(username, password);
    }
}


