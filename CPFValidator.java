public class CPFValidator {
    public static boolean isValidCPF(String cpf) {
        cpf = cpf.replace(".", "").replace("-", ""); // Remover pontos e traços do CPF
        if (cpf.length() != 11) {
            return false;
        }

        for (int i = 0; i < 10; i++) {
            if (cpf.substring(0, 10).equals(String.valueOf(i).repeat(10))) {
                return false;
            }
        }

        int digito1 = calcularDigitoVerificador(cpf.substring(0, 9), 10);
        int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1, 11);

        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
    }

    private static int calcularDigitoVerificador(String parteCPF, int multiplicador) {
        int soma = 0;
        for (int i = 0; i < parteCPF.length(); i++) {
            soma += Character.getNumericValue(parteCPF.charAt(i)) * multiplicador;
            multiplicador--;
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}