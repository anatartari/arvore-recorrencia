package ucsal.br;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Double multiplyExpression;
    private Double nValueMultiplyNumerator;
    private Double nValueMultiplyDenominator;
    private List<Node> childers;

    public String getNValue(){
        return nValueMultiplyDenominator != 1 ? "(" + nValueMultiplyNumerator + "/" + nValueMultiplyDenominator + ")" : nValueMultiplyNumerator.toString();
    }

    public String getExpression(){
        String expression = "T(" + getNValueMultipler();

        if(multiplyExpression > 1) {
            expression = multiplyExpression + " " + expression;
        }

        return expression + ")";
    }

    public String getNValueMultipler() {
        String nValueMultipler = "n * " + nValueMultiplyNumerator;
        if(nValueMultiplyDenominator > 1){
            nValueMultipler = nValueMultipler +"/" + nValueMultiplyDenominator;
        }
        return nValueMultipler;
    }


    public Node() {
        this.childers = new ArrayList<>();
    }

    public List<Node> getChilders() {
        return childers;
    }

    public void setChilders(List<Node> childers) {
        this.childers = childers;
    }

    public Double getMultiplyExpression() {
        return multiplyExpression;
    }

    public void setMultiplyExpression(Double multiplyExpression) {
        this.multiplyExpression = multiplyExpression;
    }

    public Double getnValueMultiplyNumerator() {
        return nValueMultiplyNumerator;
    }

    public void setnValueMultiplyNumerator(Double nValueMultiplyNumerator) {
        this.nValueMultiplyNumerator = nValueMultiplyNumerator;
    }

    public Double getnValueMultiplyDenominator() {
        return nValueMultiplyDenominator;
    }

    public void setnValueMultiplyDenominator(Double nValueMultiplyDenominator) {
        this.nValueMultiplyDenominator = nValueMultiplyDenominator;
    }
}
