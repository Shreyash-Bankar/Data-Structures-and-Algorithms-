import java.util.*;
public class mergingList{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static Node intersection(Node l1, Node l2){
            Node temp1 = l1;
            while(temp1 != null){
            Node temp2 = l2;
                while(temp2 != null){
                    if(temp1 == temp2){
                        return temp1;
                    }
                    temp2 = temp2.next;
                }
                temp1 = temp1.next;
            }
            return null;
        }
    public static class LinkedList{
        Node head = null;
        Node tail = null;

        Node insert(int data){
            Node newNode = new Node(data); 
            if(head == null){
                head = tail =  newNode;
                return head;
            }
            tail.next = newNode;
            tail = newNode;
            return head;
        }
        
       
    } 


    public static void main(String args[]){
            LinkedList ll1 = new LinkedList();
            LinkedList ll2 = new LinkedList();
            Node root1 = ll1.insert(4);
            ll1.insert(5);
            ll1.insert(6);
            ll1.insert(7);

            Node root2 = ll2.insert(1);
            ll2.insert(2);
            ll2.insert(3);
            ll2.tail.next = root1.next.next;
            ll2.tail = ll1.tail;
            
            Node intersectionPoint = intersection(root1, root2);
            if(intersectionPoint == null){
                System.out.println("Null");
            }else{
                System.out.println(intersectionPoint.data);
            }

            
    }
}