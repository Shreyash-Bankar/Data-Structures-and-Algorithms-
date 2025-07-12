import java.util.*;
public class basic{
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

    }
    public static class LinkedList {
        public static Node head = null;
        public static Node tail = null;
        static int size = 0;
        public static Node insertEnd(int data){
            size ++;
            Node newNode = new Node(data);
            if(tail == null){
                head = tail = newNode;
                return head; 
            }
            tail.next = newNode;
            tail = tail.next;
            return head;
        }
        public static Node insertFirst(int data){
            size++;
            Node newNode = new Node(data);
            if(tail == null){
                head = tail = newNode;
                return head;
            }
            newNode.next = head;
            head = newNode;
            return head;
        }
        public static Node insertMid(int data,int index){
            size++;
            if(index == 0){
                insertFirst(data);
                return head;
            }else if(index == size){
                insertEnd(data);
                return head;
            }
            int i = 0;
            Node temp = new Node(-1);
            temp.next = head;
            while(i != index){
                i++;
                temp = temp.next;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
            return head;
        }
        
        public static Node deletionFirst(Node head){
            size--;
            if(head == null){
                return head;
            }
            head = head.next;
            return head;
        }
        public static Node deletionMid(Node head, int index){
            size--;
            Node temp = new Node(-1);
            temp.next = head;
            int i = 0;
            while(i != index){
                i++;
                temp = temp.next;
            }
            Node delete = temp.next;
            temp.next = temp.next.next;
            delete.next = null;
            return head;
        }
        public static Node deletionEnd(Node head){
            size--;
            if(head == null){
                return head;
            }
            Node temp = new Node(-1);
            temp.next = head;
            
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            return head;
        }

        public static int search( Node temp, int index, int target ){
            if(target == temp.data){
                return index;
            }
            if(temp == null){
                return -1;
            }
            return search(temp.next,index+1,target);

        }
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        Node root = ll.insertFirst(1);
        ll.insertEnd(2);
        ll.insertEnd(3);
        ll.insertMid(4,3);
        // ll.deletionEnd(root);
        // root = ll.deletionFirst(root);
        // ll.deletionMid(root,1);
        
        System.out.println(ll.search(root,0,3));
        print(root);
    }   
}