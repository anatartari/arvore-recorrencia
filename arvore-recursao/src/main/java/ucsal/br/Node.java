package ucsal.br;

import java.util.List;

public class Node {

    private String funcition;
    private List<Node> childrens;

    public Node(String funcition, List<Node> childrens) {
        this.funcition = funcition;
        this.childrens = childrens;
    }

    public String getFuncition() {
        return funcition;
    }

    public void setFuncition(String funcition) {
        this.funcition = funcition;
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }
}
