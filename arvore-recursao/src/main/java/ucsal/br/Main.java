package ucsal.br;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String STOP_CHAR = "C";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String input = "";
        do{
            input = reader.readLine();

        }
        while (!input.equals(STOP_CHAR));

        System.out.println(input);
    }
}