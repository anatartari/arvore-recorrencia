package ucsal.br;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Double multiplerExpression;
    private Double nValueMultiplerNumerator;
    private Double nValueMultiplerDenominator;
    private List<Node> childers;

    public String getExpression(){
        String expression = "T(n * " + getNValueMultipler();

        if(multiplerExpression > 1) {
            expression = multiplerExpression + " " + expression;
        }

        return expression + ")";
    }

    public String getNValueMultipler() {
        String nValueMultipler = "n * " + nValueMultiplerNumerator;
        if(nValueMultiplerDenominator > 1){
            nValueMultipler = nValueMultipler +"/" + nValueMultiplerDenominator;
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

    public Double getMultiplerExpression() {
        return multiplerExpression;
    }

    public void setMultiplerExpression(Double multiplerExpression) {
        this.multiplerExpression = multiplerExpression;
    }

    public Double getnValueMultiplerNumerator() {
        return nValueMultiplerNumerator;
    }

    public void setnValueMultiplerNumerator(Double nValueMultiplerNumerator) {
        this.nValueMultiplerNumerator = nValueMultiplerNumerator;
    }

    public Double getnValueMultiplerDenominator() {
        return nValueMultiplerDenominator;
    }

    public void setnValueMultiplerDenominator(Double nValueMultiplerDenominator) {
        this.nValueMultiplerDenominator = nValueMultiplerDenominator;
    }
}
