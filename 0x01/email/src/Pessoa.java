package email;

public class Pessoa {

    public static boolean emailValid(String email) {
        if (email == null) {
            return false;
        }

        // Verifica se contém "@" e se o comprimento é <= 50 caracteres
        return email.contains("@") && email.length() <= 50;
    }
}
