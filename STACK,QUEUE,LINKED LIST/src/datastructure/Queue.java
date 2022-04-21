package datastructure;

import java.util.Scanner;

/**
 * Queue performs FIFO ( First In First Out )
 * The element which is inserted first must be deleted first
 * @author Admin
 *
 */

public class Queue {
	
	/**
	 * size   -- number of elements in array
	 * front  -- initialized to -1
	 * rear   -- initialized to -1
	 * values -- array 
	 */
	int size;
	int front = -1, rear = -1;
	int values[] = new int[size];
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Constructor with 2 parameters -- elements and size
	 * @param elements is an array of int data type
	 * @param size     is number of elements stored in array
	 */
	Queue(int elements[],int size){
		values = elements;
		this.size = size;
	}
	
	/**
	 * This method checks whether the array is empty or not
	 * @return true if the array is empty (i.e) rear is equal to -1 or front is greater than rear otherwise false.
	 */
	boolean underflow() {
		if(rear == -1 || front>rear) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks whether the queue(array) is full or not
	 * @return true if the rear is equal to number of elements in the array - 1 otherwise false. 
	 */
	boolean overflow() {
		if(rear == size-1) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method will add elements in the array
	 * If array is full then it displays queue is full
	 * Otherwise it add elements to the array
	 */
	public void enqueue() {
		if(overflow()) {
			System.out.println("QUEUE IS FULL (OVERFLOW) ");
		}
		else {
			if(front == -1) {
				front = 0;
			}
			System.out.println("ENTER AN ELEMENT THAT YOU WANT TO ADD IN THE QUEUE");
			int addElement = scanner.nextInt();
			values[++rear] = addElement;
		}
	}
	
	/**
	 * This method remove a first element from the array
	 * If the array is empty then it displays "queue is empty"
	 * Otherwise It remove an element from the array
	 */
	public void dequeue() {
		if(underflow()) {
			System.out.println("QUEUE IS EMPTY (UNDERFLOW) ");
		}
		else {
			int removeElement = values[front++];
			System.out.println(removeElement + " is popped");
		}
	}
		
	/**
	 * This method will display all the element in the array
	 * If the array is empty then it displays queue is empty
	 * Otherwise it displays the elements in the array
	 */
	public void display() {
		if(underflow()) {
			System.out.println("QUEUE IS EMPTY (UNDERFLOW) ");
		}
		else {
			System.out.println("The elements are ");
			for(int i=front; i<=rear; i++) {
				System.out.println(values[i]);
			}
		}
	}
	
	/**
	 * This method returns the first element from the array
	 * @return first element from the array
	 */
	public int peek() {
		return values[front];
	}
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENTER THE SIZE OF THE QUEUE");
		int size = scanner.nextInt();
		int flag = 0;
		int elements[] = new int[size];
		Queue queue = new Queue(elements,size); //Creating an object of Queue class
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("1..ENQUEUE  2..DEQUEUE  3..DISPLAY  4..SHOW FRONT ELEMENT  5..EXIT");
		int choice = scanner.nextInt();
		while(choice != 5) {
			switch(choice) {
				case 1 : queue.enqueue();
				break;
				case 2 : queue.dequeue();
				break;
				case 3 : queue.display();
				break;
				case 4 : int frontElement = queue.peek();
						 System.out.println(frontElement + " is the first element in queue");
				break;
				case 5 : System.out.println("END PROGRAM");
				flag = 1;
				break;
				default: System.out.println("ENTER YOUR CORRECT CHOICE");
				break;
			}
			if(flag == 1) {
				break;
			}
			else {
				System.out.println("ENTER YOUR CHOICE ");
				choice = scanner.nextInt();
			}
		}
	}

}