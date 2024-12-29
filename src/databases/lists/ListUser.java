package databases.lists;

import databases.nodes.NodeUser;
import models.ModelUser;

public class ListUser {
    NodeUser head;

    public ModelUser insert(ModelUser data) {
        NodeUser nn = new NodeUser(data);
        NodeUser current = head;
        int id = 1;

        if (current == null) {
            nn.getData().setId(id);
            nn.setNext(null);
            head = nn;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
                id++;
            }
            nn.getData().setId(id);
            current.setNext(nn);
        }
        return nn.getData();
    }

    public ModelUser idSearch(int data) {
        if (head == null) {
            return null;
        } else {
            if (head.getData().getId() == data) {
                return head.getData();
            } else {
                NodeUser current = head;
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
    
    public ModelUser emailSearch(String data) {
        if (head == null) {
            return null;
        } else {
            if (head.getData().getEmail().equals(data)) {
                return head.getData();
            } else {
                NodeUser current = head;
                while (current != null) {
                    if (current.getData().getEmail().equals(data)) {
                        return current.getData();
                    }
                    current = current.getNext();
                }
            }
            return null;
        }
    }

    public void delete(ModelUser data) {
        if (head == null) {
            System.out.println("[ User Tidak Ditemukan ]");
        } else {
            if (head.getData() == data) {
                head = head.getNext();
                System.out.println("\n[ User Dihapus ]");
            } else {
                NodeUser current = head;
                NodeUser prec = head;
                while (current != null) {
                    if (current.getData() == data) {
                        prec.setNext(current.getNext());
                        current.setNext(null);
                        System.out.println("\n[ User Dihapus ]");
                    }
                    prec = current;
                    current = current.getNext();
                }
            }
        }
    }

    public void printList() {
        NodeUser current = head;
        System.out.println("List User : \n");
        while (current != null) {
            System.out.print(current.getData() + "\n");
            current = current.getNext();
        }
    }

}
