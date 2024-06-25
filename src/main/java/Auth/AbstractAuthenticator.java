package Auth;

/*Esta clase abstracta proporciona una implementación parcial de la interfaz Authenticator.
Las clases concretas que extienden esta clase deben proporcionar una implementación completa del método authenticate.*/

public abstract class AbstractAuthenticator implements Authenticator {

    //El método de autenticación utilizado por este autenticador.
    protected String authMethod;

    /*Obtiene el método de autenticación utilizado por este autenticador.
     retorna El método de autenticación.*/
    public String getAuthMethod() {
        return authMethod;
    }

    /*Establece el método de autenticación utilizado por este autenticador.
     authMethod: El método de autenticación a establecer. */
    public void setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }
}