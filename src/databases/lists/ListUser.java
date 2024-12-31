package databases.lists;

import databases.nodes.NodeUser;
import models.ModelUser;
import utils.Enums.Role;

public class ListUser {
    private NodeUser head;
    private NodeUser tail;

    public NodeUser getHead() {
        return head;
    }

    public ModelUser insert(ModelUser data) {
        NodeUser nn = new NodeUser(data);

        if (tail == null) {
            nn.getData().setId(1);
            head = tail = nn;
        } else {
            nn.getData().setId(tail.getData().getId()+1);
            tail.setNext(nn);
            nn.setPrev(tail);
            tail = nn;
        }
        return nn.getData();
    }

    public void delete(ModelUser data) {
        if (head == null) {
            return;
        }
        NodeUser current = head;
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

    public ModelUser searchId(int data) {
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
    
    public ModelUser searchNama(String data) {
        if (head == null) {
            return null;
        } else {
            if (head.getData().getNama().equals(data)) {
                return head.getData();
            } else {
                NodeUser current = head;
                while (current != null) {
                    if (current.getData().getNama().equals(data)) {
                        return current.getData();
                    }
                    current = current.getNext();
                }
            }
            return null;
        }
    }
    
    public ModelUser searchEmail(String data) {
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

    public ListUser searchRole(Role data) {
        ListUser listRole = new ListUser();

        if (head == null) {
            return null;
        } else {
            if (head.getData().getRole() == data) {
                listRole.insert(head.getData());
            } else {
                NodeUser current = head;
                while (current != null) {
                    if (current.getData().getRole() == data) {
                    }
                    current = current.getNext();
                    listRole.insert(current.getData());
                }
            }
            return listRole;
        }
    }

    public void printList() {
        NodeUser current = head;
        while (current != null) {
            System.out.print("\n" + current.getData().info());
            current = current.getNext();
        }
    }
    
    public void printList(NodeUser listUser) {
        NodeUser current = listUser;
        while (current != null) {
            System.out.print("\n" + current.getData().info());
            current = current.getNext();
        }
    }

}
