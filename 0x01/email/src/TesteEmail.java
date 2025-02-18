package email;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteEmail {

    @Test
    public void testar_email_com_arroba() {
        String email = "email_teste@dominio.com.br";
        assertTrue(Pessoa.emailValid(email), "O email com '@' deveria ser válido.");
    }

    @Test
    public void testar_email_sem_arroba() {
        String email = "email_testedominio.com.br";
        assertFalse(Pessoa.emailValid(email), "O email sem '@' deveria ser inválido.");
    }

    @Test
    public void testar_email_mais_50_caracteres() {
        String email = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";
        assertEquals(false, Pessoa.emailValid(email), "O email com mais de 50 caracteres deveria ser inválido.");
    }
}
