package databases.lists;

import databases.nodes.NodeTransaksi;
import models.ModelTransaksi;
import utils.Enums.StatusTransaksi;

public class ListLaporan {
    NodeTransaksi head;
    NodeTransaksi tail;

    public NodeTransaksi getHead() {
        return head;
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

    public ModelTransaksi searchId(int data) {
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

    public void printList() {
        NodeTransaksi current = head;
        while (current != null) {
            System.out.print("\n" + current.getData().info());
            if (current.getNext() != null) {
                System.out.print("\n##############################\n");
            }
            current = current.getNext();
        }
    }

}
