package ucsal.br;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

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
        String y = reader.readLine();

        node.setMultiplyExpression(Integer.parseInt(y));

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

        printTreeAndData(headNode);
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

    private static void printTreeAndData(HeadNode headNode) {
        StringBuilder levelString = new StringBuilder();
        int level = 0;
        int numNodes = 1;
        Double nodeWorkValue = 0.0;
        String nodeWork = "cn";
        String recursiveCall = "T(n)";
        String sumOfLevelWork = "cn";

        System.out.println();
        System.out.println("Tree:");
        for (; level < 3; level++) {
            if (level != 0) {
                numNodes = (int) Math.pow(headNode.getChild().getMultiplyExpression(), level);
                nodeWorkValue = Math.pow(headNode.getChild().getnValueMultiplyNumerator()/headNode.getChild().getnValueMultiplyDenominator(), level);
                nodeWork = "c*" + nodeWorkValue + "*n";
                sumOfLevelWork = "c*" + String.format("%.2f", nodeWorkValue*numNodes) + "*n";
                recursiveCall = "n*" + String.format("%.2f", nodeWorkValue);
            };

            System.out.println("Level " + level);
            levelString.append(("|" + nodeWork + "|").repeat(numNodes));
            System.out.println(levelString);
            System.out.println("Nodes: " + numNodes);
            System.out.println("Sum Of Work: " + sumOfLevelWork);
            System.out.println("Recursive Call: " + recursiveCall);
            levelString.setLength(0);
            System.out.println();
        }
    };


}