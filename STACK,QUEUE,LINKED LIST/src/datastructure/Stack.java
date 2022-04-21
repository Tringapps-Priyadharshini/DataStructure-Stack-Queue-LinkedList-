package datastructure;

import java.util.Scanner;

/**
 * Stack performs LIFO (Last In First Out)
 * The Element which is inserted last must be deleted first 
 * In this class, there are isEmpty, isFull, push, pop, display, show top element methods
 * @author ELCOT
 */

public class Stack {
	Scanner s = new Scanner(System.in);
	/**
	 * size   -- is the Number of elements in array
	 * top    -- is the top of the element in array
	 * values -- is the array that stores the elements
	 */
	int size;
	int top = -1;
	int[] values = new int[size];
	
	/**
	 * Constructor with 2 parameters -- elements and size
	 * @param values is an array of integer type
	 * @param size is the size of the array which is in integer type
	 */
	Stack(int values[],int size) {
		this.size = size;
		this.values = values;
	}
	
	/**
	 * This method check whether the stack(array) is empty or not
	 * @return true if there is no element in the array otherwise it returns false
	 */
	boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks whether the stack(array) is full or not
	 * top is the top of the element in the array
	 * @return true if top reaches the size of array otherwise false.
	 */
	boolean isFull() {
		if(top == size-1)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * This method is used to add new elements in the array
	 * First, It will check the array is full or not 
	 * If the stack is full then it displays stack is full
	 * Otherwise it push the element into the array(stack)
	 */
	public void push()
	{
		if(isFull()) {
			System.out.println("STACK IS FULL");
		}
		else {
			System.out.println("enter a number that you want to push ");
			int addElement = s.nextInt();
			values[++top] = addElement;
		}
	}
	
	/**
	 * This method is used to remove elements from the array
	 * It will check that the array is empty or not 
	 * If the array is empty then it displays stack is empty
	 * Otherwise it remove the top most element from the array
	 */
	public void pop() {

		if(isEmpty()) {
			System.out.println("STACK IS EMPTY");
		}
		else {
			int popelement = values[top];
			top--;
			System.out.println(popelement + " is popped");
		}
	}
	
	/**
	 * This method is used to display the elements in the array
	 * If the array is empty then it displays "stack is empty"
	 * Otherwise it displays the values which is present in the array
	 */
	public void display() {
		if(isEmpty()) {
			System.out.println("STACK IS EMPTY");
		}
		else {
			for(int i = 0; i<=top; i++)
			{
				System.out.println(values[i]);
			}
		}
	}
	
	/**
	 * This method will return the top most element in the stack(array)
	 * @return the element which is present at the top
	 */
	public int showtop() {
		return values[top];
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int flag = 0;
		System.out.println("ENTER THE SIZE OF THE STACK ");
		int size = s.nextInt();
		int values[] = new int[size];
		Stack stack = new Stack(values,size);   //create an object for the class Stack
		
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("1..PUSH  2..POP  3..DISPLAY ALL ELEMENTS  4..SHOW TOP ELEMENT  5..EXIT");
		int choice = s.nextInt(); 
		while(choice != 5) {
			switch(choice) 
			{
			case 1 :	stack.push();
						break;
			case 2 :	stack.pop();
						break;
			case 3 : 	stack.display();
						break;
			case 4 :	System.out.println("TOP VALUE IN THE STACK : " + stack.showtop());
						break;
			case 5 :  	System.out.println("END PROGRAM");
						flag = 1;
						break;
			default:	System.out.println("PLEASE ENTER THE CORRECT CHOICE");
						break;
			}
			if(flag == 1) {
				break;
			}
			else {
				System.out.println("enter your choice");
				choice = s.nextInt();
			}
		}

	}

}


