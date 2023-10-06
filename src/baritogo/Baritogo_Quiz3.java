/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baritogo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class Circularqueue {
    Node front;
    Node rear;
    public void insertionBeginning(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }
    public void insertionEnd(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }
    public int deleteBeginning() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return -1; 
        } else {
            int data = front.data;
            front = front.next;
            if (front != null) {
                front.prev = null;
            } else {
                rear = null;
            }
            return data;
        }
    }
    public int deleteEnd() {
        if (rear == null) {
            System.out.println("Queue is empty.");
            return -1; 
        } else {
            int data = rear.data;
            rear = rear.prev;
            if (rear != null) {
                rear.next = null;
            } else {
                front = null;
            }
            return data;
        }
    }
    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class Baritogo_Quiz3 {
    
    public static void main(String[] args) {    
        main();
      }
    public static void main(){
         Scanner scn = new Scanner(System.in);
         System.out.println("\n\n\nPili asa ka gusto \n1. Sa imong crush? \n2. Sa naka crush nimo?\nor \n3. kay God?");
         int input = scn.nextInt();
         
         if (input == 1){
             uno();
         } else if (input == 2){
             dos();
         } else if (input == 3){
             tres();
         }
            else {
             System.out.println("Ayaw pasagad og type!!");         
         }               
    }
    public static void uno(){
         Queue<Integer> linearQueue = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            linearQueue.offer(i);
        }
        System.out.println("All 9 Elements in the linear queue:");
        while (!linearQueue.isEmpty()) {
            int element = linearQueue.poll();
            System.out.print(element + " ");    
         }
          main();
    }
     public static void dos(){
          Circularqueue Ciruqueue = new Circularqueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("xxxxxxxxxxxxxxxxxx");
            System.out.println("1. Insert sa una");
            System.out.println("2. Insert sa last");
            System.out.println("3. Delete sa una");
            System.out.println("4. Delete sa last");
            System.out.println("5. Display");
            System.out.println("6. FireExit");
            System.out.println("7. Balik!!!!");
            System.out.println("xxxxxxxxxxxxxxxxxx");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at Beginning: ");
                    int insertsauna = scanner.nextInt();
                    Ciruqueue.insertionBeginning(insertsauna);
                    break;
                case 2:
                    System.out.print("Enter element to insert at End: ");
                    int insertsalast = scanner.nextInt();
                    Ciruqueue.insertionEnd(insertsalast);
                    break;
                case 3:
                    int deletesafirst = Ciruqueue.deleteBeginning();
                    System.out.println("Sa sugod nga element na deleted: " + deletesafirst);
                    break;
                case 4:
                    int deletesalast = Ciruqueue.deleteEnd();
                    System.out.println("Sa last nga element na deleted: " + deletesalast);
                    break;
                case 5:
                    System.out.print("Queue: ");
                    Ciruqueue.display();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                case 7:
                    main();
                default:
                    System.out.println("Mag pasaad lagi ba");
            }
        }
    }
     public static void tres(){           
           System.exit(0);
     }
}

