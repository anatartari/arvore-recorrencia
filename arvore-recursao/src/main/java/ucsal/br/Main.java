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
        HeadNode headNode = new HeadNode();
        do{
            Node node = new Node();
            System.out.println("T(n) = y T(n * x) + n");
            System.out.println();
            System.out.println("--------------------------");
            System.out.println();
            System.out.println("digite o valor de Y: ");
            input = reader.readLine();

            if (input.isBlank() || input.isEmpty()) {
                node.setMultiplerExpression(1D);
            } else {
                node.setMultiplerExpression(Double.parseDouble(input));
            }

            System.out.println();
            System.out.println("--------------------------");
            System.out.println();

            System.out.println("digite o valor de x (caso seja fracao, utilize a '/'): ");

            input = reader.readLine();

            if(input.contains("/")){
                String[] div = input.split("/");
                node.setnValueMultiplerNumerator(Double.parseDouble(div[0]));
                node.setnValueMultiplerDenominator(Double.parseDouble(div[1]));
            }else{
                node.setnValueMultiplerNumerator(Double.parseDouble(input));
                node.setnValueMultiplerDenominator(1D);
            }

            headNode.getChilders().add(node);

            System.out.println();
            System.out.println("--------------------------");
            System.out.println();

            System.out.println("Digite E para adicionar uma nova expressão ou C para adicionar a constante: ");
            input = reader.readLine();


            System.out.println();
            System.out.println("--------------------------");
            System.out.println();

        }
        while (!input.toUpperCase().equals(STOP_CHAR));

        showInformation(headNode);

    }

    private static void showInformation(HeadNode headNode)  {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("EXPRESSÃO COMPLETA: \n");
        System.out.println(headNode.getFullExpression());
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("nivel 0: " + HeadNode.getConstant());
        System.out.println("qnt Nos: " + 1);
        System.out.println("--------------------------");
        System.out.println();

        System.out.println("nivel 1: ");
        for(Node node : headNode.getChilders()){
            System.out.println("  |  " + node.getNValueMultipler() + "  |  ");
        }
        System.out.println("qnt Nos: " + headNode.getChilders().stream().mapToDouble(Node::getMultiplerExpression).sum());

    }

}