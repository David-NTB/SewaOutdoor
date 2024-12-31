package databases.lists;

import databases.nodes.NodeBarang;
import models.ModelBarang;
import utils.Enums.StatusBarang;

public class ListBarang {
    private NodeBarang head;
    private NodeBarang tail;

    public NodeBarang getHead() {
        return head;
    }

    public ModelBarang insert(ModelBarang data) {
        NodeBarang nn = new NodeBarang(data);

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

    public ModelBarang insertItem(ModelBarang data) {
        NodeBarang nn = new NodeBarang(data);

        if (tail == null) {
            head = tail = nn;
        } else {
            tail.setNext(nn);
            nn.setPrev(tail);
            tail = nn;
        }
        return nn.getData();
    }

    public void delete(ModelBarang data) {
        if (head == null) {
            return;
        }
        NodeBarang current = head;
        if (head.getData() == data) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
            return;
        }
        while (current != null && current.getData() != data) {
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        } else {
            tail = current.getPrev();
        }
        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        }
    }

    public ModelBarang searchId(int data) {
        if (head == null) {
            return null;
        } else {
            if (head.getData().getId() == data) {
                return head.getData();
            } else {
                NodeBarang current = head;
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

    public ModelBarang searchNama(String data) {
        if (head == null) {
            return null;
        } else {
            if (head.getData().getNama() == data) {
                return head.getData();
            } else {
                NodeBarang current = head;
                while (current != null) {
                    if (current.getData().getNama() == data) {
                        return current.getData();
                    }
                    current = current.getNext();
                }
            }
            return null;
        }
    }

    public ListBarang searchStatus(StatusBarang data) {
        ListBarang listStatusBarang = new ListBarang();

        if (head == null) {
            return null;
        } else {
            if (head.getData().getStatus() == data) {
                listStatusBarang.insert(head.getData());
            } else {
                NodeBarang current = head;
                while (current != null) {
                    if (current.getData().getStatus() == data) {
                    }
                    current = current.getNext();
                    listStatusBarang.insert(current.getData());
                }
            }
            return listStatusBarang;
        }
    }

    public void printList() {
        NodeBarang current = head;
        while (current != null) {
            System.out.print("\n" + current.getData().info());
            current = current.getNext();
        }
    }

    public String printItem(ListBarang listBarang) {
        NodeBarang current = listBarang.head;
        String output = "";
        while (current != null) {
            output += "\n" + current.getData().info();
            current = current.getNext();
        }
        return output;
    }

    public double getHarga(ListBarang listItem){
        NodeBarang current = listItem.head;
        double harga = 0;
        while (current != null) {
            harga += current.getData().getHarga();
            current = current.getNext();
        }
        return harga;
        
    }
}
