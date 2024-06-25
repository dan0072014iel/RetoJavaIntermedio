package Auth;

/*Esta interfaz define un contrato para autenticar usuarios.*/

public interface Authenticator {

    /*Autentica a un usuario basándose en el nombre de usuario y la contraseña proporcionados:
     username: El nombre de usuario del usuario que intenta autenticarse.
     password: La contraseña asociada con el nombre de usuario proporcionado.
     boolean: true si la autenticación es exitosa, false en caso contrario.
     */
    boolean authenticate(String username, String password);
}