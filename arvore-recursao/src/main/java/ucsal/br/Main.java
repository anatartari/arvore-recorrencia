package ucsal.br;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
        1 - Receber Recursão - OK
        2 - Tirando a recursão o que sobra? c.n (nível 0) - OK
        3 - Informações por nível (número de nós, soma de esforço [tempo] <-> tempo por nó, progressão da recursividade)
        4 - Theta(n)
        5 - Exibição dos níveis da árvore (nível 3 max. + i-ésimo)
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String input = "";
        HeadNode headNode = new HeadNode();

        Node node = new Node();
        System.out.println("T(n) = y T(n * x) + c");
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("digite o valor de Y: ");
        input = reader.readLine();

        if (input.isBlank() || input.isEmpty()) {
            node.setMultiplyExpression(1D);
        } else {
            node.setMultiplyExpression(Double.parseDouble(input));
        }

        System.out.println();
        System.out.println("--------------------------");
        System.out.println();

        System.out.println("digite o valor de x (caso seja fracao, utilize a '/'): ");

        input = reader.readLine();

        if(input.contains("/")){
            String[] div = input.split("/");
            node.setnValueMultiplyNumerator(Double.parseDouble(div[0]));
            node.setnValueMultiplyDenominator(Double.parseDouble(div[1]));
        }else{
            node.setnValueMultiplyNumerator(Double.parseDouble(input));
            node.setnValueMultiplyDenominator(1D);
        }

        headNode.setChild(node);

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        String levelCountExpression = getLevelCountExpression(headNode);

        String workExpression = getWorkExpression(headNode);

        System.out.println("levelCountExpression: " + levelCountExpression);
        System.out.println("workExpression: " + workExpression);

    }

    private static String getWorkExpression(HeadNode headNode) {

        return "Work Expression: " + "Σ_{i=0}^{log" +
                getLogBase(headNode) +
                " (n)" +
                "}" +
                "(" +
                HeadNode.getConstant() +
                " * " +
                headNode.getChild().getMultiplyExpression() +
                "^i" +
                " * " +
                headNode.getChild().getNValue() +
                "^i" +
                ")";
    }

    private static String getLevelCountExpression(HeadNode headNode) {

        return "Max Level Expression: log" + getLogBase(headNode) + " (n)";
    }

    private static String getLogBase(HeadNode headNode) {
        return headNode.getChild().getnValueMultiplyDenominator() != 1 ?
                headNode.getChild().getnValueMultiplyDenominator().toString() + "/" + headNode.getChild().getnValueMultiplyNumerator().toString() :
                headNode.getChild().getnValueMultiplyNumerator().toString();
    }




}