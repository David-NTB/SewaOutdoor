package databases.nodes;

import models.ModelBarang;

public class NodeBarang {
    private ModelBarang data;
    private NodeBarang next;
    private NodeBarang prev;

    public NodeBarang(ModelBarang d) {
        data = d;
        next = null;
        prev = null;
    }

    public ModelBarang getData() {
        return data;
    }

    public void setData(ModelBarang data) {
        this.data = data;
    }

    public NodeBarang getNext() {
        return next;
    }

    public void setNext(NodeBarang next) {
        this.next = next;
    }

    public NodeBarang getPrev() {
        return prev;
    }

    public void setPrev(NodeBarang prev) {
        this.prev = prev;
    }   
    
}
