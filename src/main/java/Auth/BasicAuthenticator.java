package Auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*Esta clase proporciona una implementación concreta del autenticador básico.
Extiende la clase AbstractAuthenticator para heredar la funcionalidad común.*/

public class BasicAuthenticator extends AbstractAuthenticator {

    /*Constructor que establece el método de autenticación como "BASIC".*/

    public BasicAuthenticator() {
        this.authMethod = "BASIC";
    }

    /*Método para autenticar usuarios utilizando autenticación básica y consultando una base de datos.
     username: El nombre de usuario proporcionado para la autenticación.
     password: La contraseña proporcionada para la autenticación.
     return: true si la autenticación es exitosa, false en caso contrario.*/

    @Override
    public boolean authenticate(String username, String password) {
        //-----------------------------------------------------------------------------------------
        // Implementación de autenticación básica: (no es parte del reto, pero quise colocar como seria
        // comprobar credenciales contra la base de datos en codigo para uno de los metodos)
        //-----------------------------------------------------------------------------------------

        // Intenta establecer una conexión a la base de datos utilizando JDBC
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BBDDLogin", "root", "1234")) {

            // Prepara la consulta SQL para verificar las credenciales del usuario
            String query = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Establece los parámetros de la consulta SQL con el nombre de usuario y contraseña proporcionados
            statement.setString(1, username);
            statement.setString(2, password);

            // Ejecuta la consulta SQL y obtiene el resultado
            ResultSet resultSet = statement.executeQuery();

            // Comprueba si la consulta SQL devuelve al menos una fila
            if (resultSet.next()) {
                // Si el recuento es mayor que cero, significa que se encontró al menos 1 resultado
                return resultSet.getInt(1) > 0;
            }
        } catch (Exception e) {
            // Si ocurre alguna excepción durante el proceso de autenticación, imprime la traza de la excepción
            e.printStackTrace();
        }
        // Si no se pudo autenticar por algún motivo, devuelve false
        return false;
    }
}