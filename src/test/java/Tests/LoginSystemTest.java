package Tests;

import Manager.LoginManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Anotación para indicar que las pruebas se ejecutarán con SerenityRunner
@RunWith(SerenityRunner.class)
public class LoginSystemTest {

    // Anotación para indicar que el WebDriver será administrado automáticamente por Serenity
    @Managed
    WebDriver driver;

    // Instancia de la clase LoginManager para realizar las pruebas de autenticación
    LoginManager loginManager = new LoginManager();

    // Prueba para verificar la autenticación básica
    @Test
    public void basicAuthenticationTest() {
        // Configura el autenticador como BASIC y realiza la autenticación
        loginManager.setAuthenticator("BASIC");
        assertTrue(loginManager.login("user1", "pass1")); // Debería autenticarse correctamente
        assertFalse(loginManager.login("user1", "wrongpass")); // Debería fallar la autenticación
    }

    // Prueba para verificar la autenticación OAuth
    @Test
    public void oauthAuthenticationTest() {
        // Configura el autenticador como OAUTH y realiza la autenticación
        loginManager.setAuthenticator("OAUTH");
        assertTrue(loginManager.login("oauthUser", "oauthPass")); // Debería autenticarse correctamente
        assertFalse(loginManager.login("oauthUser", "wrongpass")); // Debería fallar la autenticación
    }

    // Prueba para verificar la autenticación JWT
    @Test
    public void jwtAuthenticationTest() {
        // Configura el autenticador como JWT y realiza la autenticación
        loginManager.setAuthenticator("JWT");
        assertTrue(loginManager.login("jwtUser", "jwtPass")); // Debería autenticarse correctamente
        assertFalse(loginManager.login("jwtUser", "wrongpass")); // Debería fallar la autenticación
    }
}