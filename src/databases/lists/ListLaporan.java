package databases.lists;

import databases.nodes.NodeLaporan;
import databases.nodes.NodeTransaksi;
import models.ModelLaporan;

public class ListLaporan {
    NodeLaporan head;
    NodeLaporan tail;

    public NodeLaporan getHead() {
        return head;
    }

    public ModelLaporan insert(ModelLaporan data) {
        NodeLaporan nn = new NodeLaporan(data);

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

    public ModelLaporan idSearchLaporan(int data) {
        if (head == null) {
            return null;
        } else {
            if (head.getData().getId() == data) {
                return head.getData();
            } else {
                NodeLaporan current = head;
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
        NodeTransaksi current = head.getData().getTransaksi().head;
        while (current != null) {
            System.out.print("\n" + current.getData().info());
            if (current.getNext() != null) {
                System.out.print("\n##############################\n");
            }
            current = current.getNext();
        }
    }

    public void printAll() {
        NodeLaporan current = head;
        while (current != null) {
            System.out.println("\n" + current.getData().infoo());
            current = current.getNext();
        }
    }
}
