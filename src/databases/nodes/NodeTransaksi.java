package databases.nodes;

import models.ModelTransaksi;

public class NodeTransaksi {
    private ModelTransaksi data;
    private NodeTransaksi next;
    private NodeTransaksi prev;

    public NodeTransaksi(ModelTransaksi d) {
        data = d;
        next = null;
        prev = null;
    }

    public ModelTransaksi getData() {
        return data;
    }

    public void setData(ModelTransaksi data) {
        this.data = data;
    }

    public NodeTransaksi getNext() {
        return next;
    }

    public void setNext(NodeTransaksi next) {
        this.next = next;
    }

    public NodeTransaksi getPrev() {
        return prev;
    }

    public void setPrev(NodeTransaksi prev) {
        this.prev = prev;
    }
    
}
