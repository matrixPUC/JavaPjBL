import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        new FirstFrame();

        // INSTANCIAÇÃO
        // CompanhiaAerea
        CompanhiaAerea latam = new CompanhiaAerea("Latam", "JJ");
        CompanhiaAerea gol = new CompanhiaAerea("Gol", "G3");
        CompanhiaAerea azul = new CompanhiaAerea("Azul", "AD");
        CompanhiaAerea qatarAirways = new CompanhiaAerea("Qatar Airways", "QR");
        CompanhiaAerea americanAirlines = new CompanhiaAerea("American Airlines", "AA");
        CompanhiaAerea allNipponAirways = new CompanhiaAerea("All Nippon Airways", "NH");
        CompanhiaAerea airFrance = new CompanhiaAerea("Air France", "AF");

        // Aeroporto
        Aeroporto curitiba = new Aeroporto("Aeroporto Internacional de Curitiba - Afonso Pena", "São José dos Pinhais, PR, Brasil", "CWB");
        Aeroporto guarulhos = new Aeroporto("Aeroporto Internacional de São Paulo - Guarulhos", "Guarulhos, SP, Brasil", "GRU");
        Aeroporto galeao = new Aeroporto("Aeroporto Internacional do Rio de Janeiro - Galeão", "Rio de Janeiro, RJ, Brasil", "GIG");
        Aeroporto qatar = new Aeroporto("Aeroporto Internacional de Hamad", "Doha, Qatar", "DOH");
        Aeroporto unitedstates = new Aeroporto("Aeroporto Internacional John F. Kennedy", "Queens, NY, Estados Unidos", "JFK");
        Aeroporto tokyo = new Aeroporto("Aeroporto Internacional de Tokyo", "Tokyo, Japão", "HND");
        Aeroporto paris = new Aeroporto("Aeroporto de Paris-Charles de Gaulle", "Paris, França", "CDG");

        // Voos
        try {
            BufferedReader reader = new BufferedReader(new FileReader("voos.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                // Processar cada linha e extrair as informações necessárias
                String[] data = line.split(";"); // Supondo que cada campo esteja separado por ponto e vírgula

                // Extrair os valores do array 'data' e criar objetos Voo
                String numeroVoo = data[0];
                String origemVoo = data[1];
                String destinoVoo = data[2];
                String dataPartida = data[3];
                String dataChegada = data[4];
                String companhiaAerea = data[5];
                int capacidade = Integer.parseInt(data[6]);
                float tarifa = Float.parseFloat(data[7]);

                // Verificar se o voo é nacional ou internacional e criar a instância adequada
                if (data.length == 9) {
                    double taxaDomestica = Double.parseDouble(data[8]);
                    new ColecaoVoos(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa, taxaDomestica);
                } else if (data.length == 11) {
                    String paisOrigem = data[8];
                    String paisDestino = data[9];
                    boolean necessitaVisto = Boolean.parseBoolean(data[10]);
                    new ColecaoVoos(numeroVoo, origemVoo, destinoVoo, dataPartida, dataChegada, companhiaAerea, capacidade, tarifa, paisOrigem, paisDestino, necessitaVisto);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Conta
        Conta conta01 = new Conta("Beatriz Khey", "beatriz@gmail.com", "Beatriz.", "Rua Ângelo Massignan, 820", "(+5541)999943781", "BR159357", "101.885.899-53", new Date(1997, 10, 20));
        Conta conta02 = new Conta("Bruno Marques", "bruno@gmail.com", "bRuno.", "Rua XV, 200", "(+5541)925648623", "BR456123", "684.546.645-56", new Date(2002, 02, 02));
        Conta conta03 = new Conta("João Fadel", "joao@gmail.com", "JoaO3", "Rua Sete de Setembro, 300", "(+5541)923651356", "BR202023", "654.631.131-65", new Date(2001, 05, 30));
        Conta conta04 = new Conta("Lohine Mussi", "lohine@gmail.com", "Lohine@", "Rua República Argentina, 520", "(+5541)931353242", "BR121212", "651.233.973-22", new Date(2002, 9, 05));
        Conta conta05 = new Conta("Ariana Grande", "ariana@gmail.com", "arigra12.", "Hollywood Boulevard, 6006", "(+1408)1235236", "CS265436", "\"does not apply\" ", new Date(1993, 06, 26));
        Conta conta06 = new Conta("Travis Scott", "travis@gmail.com", "scoTT@", "North Reese Avenue, 5396 ", "(+1408)1253248", "TS123123", "\"does not apply\" ", new Date(1991, 04, 30));

        // Passageiro
        Passageiro beatriz = new Passageiro("Beatriz Khey", "BR159357", "101.008.859-93", new Date(1997, 10, 20), conta01);
        Passageiro bruno = new Passageiro("Bruno Marques", "BR456123", "684.546.645-56", new Date(2002, 02, 02), conta02);
        Passageiro joao = new Passageiro("João Fadel", "BR202023", "654.631.131-65", new Date(2001, 05, 30), conta03);
        Passageiro lohine = new Passageiro("Lohine Mussi", "BR121212", "651.233.973-22", new Date(2002, 12, 05), conta04);
        Passageiro ariana = new Passageiro("Ariana Grande", "CS265436", "\"does not apply\" ", new Date(1993, 06, 26), conta05);
        Passageiro travis = new Passageiro("Travis Scott", "TS123123", "\"does not apply\" ", new Date(1991, 04, 30), conta06);
    }
}
