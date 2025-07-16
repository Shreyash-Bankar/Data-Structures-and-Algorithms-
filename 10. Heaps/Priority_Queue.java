import java.util.PriorityQueue;
import java.util.Comparator;
public class Priority_Queue{
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]){
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        pq.add(6);       
        pq.add(3);       
        pq.add(5);       
        pq.add(1);       
        while(!pq.isEmpty()){
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
        System.out.println();
        PriorityQueue <Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(6);       
        pq2.add(3);       
        pq2.add(5);       
        pq2.add(1);       
        while(!pq2.isEmpty()){
            System.out.print(pq2.peek()+" ");
            pq2.remove();
        }
        System.out.println();
        PriorityQueue <Student> pq3 = new PriorityQueue<>();
        pq3.add(new Student("A",1));
        pq3.add(new Student("B",3));
        pq3.add(new Student("C",2));
        pq3.add(new Student("D",4));
            
        while(!pq3.isEmpty()){
            System.out.print((pq3.peek()).name+" ");
            pq3.remove();
        }
        System.out.println();

    }
}