package databases.lists;

import databases.nodes.NodeTransaksi;
import models.ModelTransaksi;

public class ListTransaksi {
    NodeTransaksi head;
    NodeTransaksi tail;

    public NodeTransaksi getHead() {
        return head;
    }

    public NodeTransaksi getTail() {
        return tail;
    }

    public ModelTransaksi insert(ModelTransaksi data) {
        NodeTransaksi nn = new NodeTransaksi(data);
        int id = 1;

        if (tail == null) {
            nn.getData().setId(id);
            head = tail = nn;
        } else {
            nn.getData().setId(id + 1);
            tail.setNext(nn);
            nn.setPrev(tail);
            tail = nn;
        }
        System.out.println("\n[ Barang Ditambahkan ]");
        return nn.getData();
    }

    public void delete(ModelTransaksi data) {
        NodeTransaksi current = head;
        while (current.getData() != data) {
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
    }

    public ModelTransaksi search(int data) {
        if (head == null) {
            System.out.println("[ Transaksi Tidak Ditemukan ]\n");
            return null;
        } else {
            if (head.getData().getId() == data) {
                System.out.println("[ Transaksi Ditemukan ]\n");
                return head.getData();
            } else {
                NodeTransaksi current = head;
                while (current != null) {
                    if (current.getData().getId() == data) {
                        System.out.println("[ Transaksi Ditemukan ]\n");
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
        System.out.println("List Transaksi : \n");
        while (current != null) {
            System.out.print(current.getData() + "\n");
            current = current.getNext();
        }
    }

}
