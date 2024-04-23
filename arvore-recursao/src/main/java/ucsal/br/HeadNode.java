package ucsal.br;


public class HeadNode {

    private Node child;

    public String getFullExpression(){
        StringBuilder fullExpression = new StringBuilder("T(n) = ");

        fullExpression.append(child.getExpression());

        fullExpression.append(" + n");

        return fullExpression.toString();
    }

    public HeadNode() {
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public static String getConstant() {
        return "c";

    }


}
