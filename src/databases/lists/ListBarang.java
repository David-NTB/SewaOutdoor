package databases.lists;

import databases.nodes.NodeBarang;
import models.ModelBarang;

public class ListBarang {
    NodeBarang head;
    NodeBarang tail;

    public NodeBarang getHead() {
        return head;
    }
    
    public NodeBarang getTail() {
        return tail;
    }

    public void insert(ModelBarang data) {
        NodeBarang nn = new NodeBarang(data);
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
    }

    public void delete(ModelBarang data) {
        NodeBarang current = head;
        while (current.getData() != data) {
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
    }

    public ModelBarang search(int data) {
        if (head == null) {
            System.out.println("[ Barang Tidak Ditemukan ]\n");
            return null;
        } else {
            if (head.getData().getId() == data) {
                System.out.println("[ Barang Ditemukan ]\n");
                return head.getData();
            } else {
                NodeBarang current = head;
                while (current != null) {
                    if (current.getData().getId() == data) {
                        System.out.println("[ Barang Ditemukan ]\n");
                        return current.getData();
                    }
                    current = current.getNext();
                }
            }
            return null;
        }
    }

    public void printList() {
        NodeBarang current = head;
        System.out.println("List Barang : \n");
        while (current != null) {
            System.out.print(current.getData() + "\n");
            current = current.getNext();
        }
    }

}
