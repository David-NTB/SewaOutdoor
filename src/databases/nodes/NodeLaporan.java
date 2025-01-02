package databases.nodes;

import models.ModelLaporan;

public class NodeLaporan {
    ModelLaporan data;
    NodeLaporan next;
    NodeLaporan prev;

    public NodeLaporan(ModelLaporan d) {
        data = d;
        next = null;
        prev = null;
    }

    public ModelLaporan getData() {
        return data;
    }

    public void setData(ModelLaporan data) {
        this.data = data;
    }

    public NodeLaporan getNext() {
        return next;
    }

    public void setNext(NodeLaporan next) {
        this.next = next;
    }

    public NodeLaporan getPrev() {
        return prev;
    }

    public void setPrev(NodeLaporan prev) {
        this.prev = prev;
    }

    
}
