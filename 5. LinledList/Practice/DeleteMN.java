// Delete N Nodes After M Nodes of a Linked List
// We have a linked list and two integers M and N. Traverse the linked list such that you retain M
// nodes then delete next N nodes, continue the same till end of the linked list. Difficulty Level:
// Rookie.
// Sample Input 1 : M=2 N=2 LL: 1->2->3->4->5->6->7->8
// Sample Output 1 : 1->2->5-

import java.util.*;
public class DeleteMN{
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
    
    public static void delete(Node head,int m,int n){

        
        Node temp = head;
        while(temp != null){
            for(int i = 1; i < m && temp != null; i++){
                temp = temp.next;
            }
            if(temp == null){
                return;
            }
            Node temp2 = temp.next;
            for(int i = 1; i < n && temp2 != null; i++){
                temp2 = temp2.next;
            }
            if(temp2 == null){
                temp.next = null;
                return;
            }
            temp.next = temp2.next;
            temp2.next = null;
            temp = temp.next;

        }

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
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        Node root = ll.insert(4);
        ll.insert(5);
        ll.insert(6);
        ll.insert(7);
        ll.insert(8);
        print(root);
        delete(root,2,2);
        print(root);


    }
}