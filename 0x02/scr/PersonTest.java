package src;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    private static Person person;

    @BeforeAll
    public static void setup() {
        person = new Person(); // Inicializa a instância de Person
    }

    // Teste para nomes de usuário válidos
    @ParameterizedTest
    @ValueSource(strings = { "PaulMcCartney2", "NeilArms2" })
    void check_user_valid(String username) {
        assertTrue(person.checkUser(username));
    }

    // Teste para nomes de usuário inválidos (contêm caracteres especiais)
    @ParameterizedTest
    @ValueSource(strings = { "Paul#McCartney", "Neil@Arms" })
    void check_user_not_valid(String username) {
        assertFalse(person.checkUser(username));
    }

    // Teste para senhas sem letras
    @ParameterizedTest
    @ValueSource(strings = { "123456789", "#$%1234" })
    void does_not_have_letters(String password) {
        assertFalse(person.checkPassword(password));
    }

    // Teste para senhas sem números
    @ParameterizedTest
    @ValueSource(strings = { "Abcabcdefgh@", "#hbtn@%tc" })
    void does_not_have_numbers(String password) {
        assertFalse(person.checkPassword(password));
    }

    // Teste para senhas com menos de 8 caracteres
    @ParameterizedTest
    @ValueSource(strings = { "Abc@123", "12$@hbt" })
    void does_not_have_eight_chars(String password) {
        assertFalse(person.checkPassword(password));
    }

    // Teste para senhas válidas
    @ParameterizedTest
    @ValueSource(strings = { "abC123456$", "Hbtn@1234", "Betty@1#2", "Hbtn@123" })
    void check_password_valid(String password) {
        assertTrue(person.checkPassword(password));
    }
}
