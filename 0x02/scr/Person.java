package src;

public class Person {
    
    // Valida o nome de usuário
    public boolean checkUser(String username) {
        if (username == null || username.length() < 8) {
            return false;
        }
        return username.matches("[a-zA-Z0-9]+"); // Apenas letras e números, sem caracteres especiais
    }

    // Valida a senha
    public boolean checkPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = password.matches(".*[A-Z].*"); // Pelo menos uma letra maiúscula
        boolean hasDigit = password.matches(".*\\d.*");      // Pelo menos um número
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"); // Pelo menos um caractere especial

        return hasUpperCase && hasDigit && hasSpecialChar;
    }
}
s