package Factory;

import Auth.*;

/*Esta clase es una fábrica para obtener instancias de autenticadores basadas en el tipo proporcionado.*/
public class AuthenticatorFactory {

    /*Devuelve una instancia del autenticador correspondiente al tipo especificado.
     type: El tipo de autenticador deseado ("BASIC", "OAUTH" o "JWT").
     return: Una instancia del autenticador correspondiente al tipo especificado.
     throws: IllegalArgumentException Si se proporciona un tipo desconocido.*/

    public static Authenticator getAuthenticator(String type) {
        switch (type.toUpperCase()) {
            case "BASIC":
                return new BasicAuthenticator();
            case "OAUTH":
                return new OAuthAuthenticator();
            case "JWT":
                return new JWTAuthenticator();
            default:
                throw new IllegalArgumentException("Tipo de autenticador desconocido: " + type);
        }
    }
}