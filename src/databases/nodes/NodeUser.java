package databases.nodes;

import models.ModelUser;

public class NodeUser {
    private ModelUser data;
    private NodeUser next;
    private NodeUser prev;

    public NodeUser(ModelUser d) {
        data = d;
        next = null;
        prev = null;
    }

    public ModelUser getData() {
        return data;
    }

    public void setData(ModelUser data) {
        this.data = data;
    }

    public NodeUser getNext() {
        return next;
    }

    public void setNext(NodeUser next) {
        this.next = next;
    }

    public NodeUser getPrev() {
        return prev;
    }

    public void setPrev(NodeUser prev) {
        this.prev = prev;
    }    
}
