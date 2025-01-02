package databases.lists;

import databases.nodes.NodeTransaksi;
import models.ModelTransaksi;
import utils.Enums.StatusTransaksi;

public class ListTransaksi {
    NodeTransaksi head;
    NodeTransaksi tail;

    public NodeTransaksi getHead() {
        return head;
    }

    public void setHead(NodeTransaksi head) {
        this.head = head;
    }

    public void setTail(NodeTransaksi tail) {
        this.tail = tail;
    }

    public ModelTransaksi insert(ModelTransaksi data) {
        NodeTransaksi nn = new NodeTransaksi(data);

        if (tail == null) {
            nn.getData().setId(1);
            head = tail = nn;
        } else {
            nn.getData().setId(tail.getData().getId() + 1);
            tail.setNext(nn);
            nn.setPrev(tail);
            tail = nn;
        }
        return nn.getData();
    }

    public void setStatusCancel(ModelTransaksi data) {
            NodeTransaksi current = head;
            while (current != null) {
                if (current.getData() == data) {
                    current.getData().setStatus(StatusTransaksi.CANCELED);
                }
                current = current.getNext();
        }
    }

    public ModelTransaksi idSearchTransaksi(int data) {
        if (head == null) {
            return null;
        } else {
            if (head.getData().getId() == data) {
                return head.getData();
            } else {
                NodeTransaksi current = head;
                while (current != null) {
                    if (current.getData().getId() == data) {
                        return current.getData();
                    }
                    current = current.getNext();
                }
            }
            return null;
        }
    }

    public String printList() {
        NodeTransaksi current = head;
        String output = "";
        while (current != null) {
            output += "\n" + current.getData().info();
            if (current.getNext() != null) {
                output += "\n##############################\n";
            }
            current = current.getNext();
        }
        return output;
    }

    public String printStatus(StatusTransaksi statusTransaksi) {
        NodeTransaksi current = head;
        String output = "";
        while (current != null && current.getData().getStatus() == statusTransaksi) {
            output += "\n" + current.getData().info();
            if (current.getNext() != null) {
                output += "\n##############################\n";
            }
            current = current.getNext();
        }
        return output;
    }

    public void clearTransaksi() {
        head = null;
        tail = null;
    }
}
