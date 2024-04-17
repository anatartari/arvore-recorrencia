package ucsal.br;

import java.util.ArrayList;
import java.util.List;

public class HeadNode {

    private List<Node> childers;

    public String getFullExpression(){
        StringBuilder fullExpression = new StringBuilder("T(n) = ");

        for(int i =0 ; i<childers.size() ; i++){
            if(i+1 >= childers.size() || i > 0){
                fullExpression.append(" + ");
            }

            fullExpression.append(childers.get(i).getExpression());
        }

        fullExpression.append(" + n");

        return fullExpression.toString();
    }

    public HeadNode() {
        this.childers = new ArrayList<>();
    }

    public static String getConstant() {
        return "n";

    }

    public List<Node> getChilders() {
        return childers;
    }

    public void setChilders(List<Node> childers) {
        this.childers = childers;
    }
}
