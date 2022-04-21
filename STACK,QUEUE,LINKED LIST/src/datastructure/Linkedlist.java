package datastructure;

import java.util.Scanner;

/**
 * Linked List has data node and next node
 * @author Admin
 */
public class Linkedlist {
	Scanner scanner = new Scanner(System.in);
	/**
	 * @author Admin
	 * Node is a class
	 * It contains data variable with integer data type and the object of Node  
	 */
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}
	
	/**
	 * Initialize head and tail to null
	 */
	public Node head = null;
	public Node tail = null;
	
	/**
	 * Initially it create a list 
	 */
	
	public void createlist() {
		Node temp = head;
		int choice;
		int insertdata;
		do {
			System.out.println("ENTER A VALUE TO INSERT ");
			insertdata = scanner.nextInt();
			Node newNode = new Node(insertdata);
			newNode.data = insertdata;
			newNode.next = null;
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			System.out.println("PRESS 1 TO CONTINUE AND 2 TO EXIT ");
			choice = scanner.nextInt();
		}while(choice == 1);
		
		System.out.println("THE ELEMENT CREATED IN THE LINKED LIST ARE ");
		temp = head;
		while(temp != null) {
			System.out.print(temp.data + "\t");
			temp = temp.next;
		}
	}
	
	/**
	 * This method add the data at the beginning
	 * @param data --> The element which we want to insert
	 */
	
	public void addAtBegin(int data)
	{
		Node newNode = new Node(data);
		newNode.data = data;
		newNode.next = head;
		head = newNode;
	}
	
	/**
	 * This method add the data at the specified index
	 * @param index --> It specifies the index of the value
	 * @param data  --> It specifies the value
	 */
	public void addnode(int index, int data) {
		Node newNode = new Node(data);
		Node temp = head;
		for(int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		newNode.data = data;
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	/**
	 * This method will add the data at the end 
	 * @param data --> It specifies the value 
	 */
	public void addAtEnd(int data) {
		Node newNode = new Node(data);
		newNode.data = data;
		newNode.next = null;
		tail.next = newNode;
		tail = newNode;
	}
	
	/**
	 * This method will delete the node at the beginning of the list
	 */
	
	public void deleteAtBeginning() {
		Node temp = head;
		if(temp == null) {
			System.out.println("EMPTY LIST");
		}
		else {
			head = head.next;
			temp.next = null;
		}

	}
	
	/**
	 * This method will delete the node at the specified index
	 * @param deleteIndex --> It specifies the index of the value which we want to delete
	 */
	
	public void deletenode(int deleteIndex) {
		Node current = head;
		if(head == null) {
			System.out.println("EMPTY LIST");
		}
		else {

			for(int i = 0; i < deleteIndex - 1 ;i++) {
				current = current.next;
			}
			current.next = current.next.next;

		}
		
	}
	
	/**
	 * This method will delete the node at the end
	 */
	public void deleteAtEnd()
	{
		Node temp = head;
		if(temp == null) {
			System.out.println("EMPTY LIST");
		}
		else {
			while(temp.next != tail) {
				temp = temp.next;
			}
			temp.next = null;
			tail = temp;
		}

	}
	
	/**
	 * This method will display all the nodes 
	 */
	
	public void display() {
		Node current = head;
		if(head == null) {
			System.out.println("EMPTY LIST");
		}
		else {
			System.out.println("THE ELEMENTS IN THE LIST ARE ");
			while(current != null) {
				System.out.println(current.data);
				current = current.next;
			}
		}

	}
	
	/**
	 * This method search that the value is present in the linked list or not
	 * @param searchElement --> It specifies the element which we want to search
	 */
	
	public boolean search(int searchElement) {
		Node temp = head;
		if(head == null) {
			System.out.println("EMPTY LIST");
		}
		else {
			while(temp != null) {
				if(temp.data == searchElement) {

					return true;
				}
				temp = temp.next;
				
			}

		}
		return false;

	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]) {
		Linkedlist linkedlist = new Linkedlist();
		int flag = 0;
		linkedlist.createlist();
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("ENTER YOUR CHOICE \n");
		System.out.println("1..ADD A NODE AT THE BEGINNING \n" + 
				           "2..ADD A NODE AT THE SPECIFIED INDEX \n" +
				           "3..ADD A NODE AT THE END \n" + 
				           "4..DELETE A NODE AT THE BEGINNING \n" +
				           "5..DELETE A NODE AT THE SPECIFIED INDEX \n" +
				           "6..DELETE AT END \n"+
				           "7..DISPLAY A LINKED LIST \n" +
				           "8..SEARCH \n" +
				           "9..EXIT \n\n");
		int choice = scanner.nextInt();
		while(choice != 9) {
			switch(choice) {
			case 1 : 		System.out.println("ENTER THE ELEMENT THAT YOU WANT TO ADD IN THE LINKED LIST");
							int addElement = scanner.nextInt();
							linkedlist.addAtBegin(addElement);
							break;
							
			case 2 : 		System.out.println("ENTER THE INDEX THAT YOU WANT TO ADD A ELEMENT");
							int addIndex = scanner.nextInt();;
							System.out.println("ENTER THE ELEMENT THAT YOU WANT TO ADD IN THE LINKED LIST");
							addElement = scanner.nextInt();
							linkedlist.addnode(addIndex,addElement);
							break;
							
			case 3 : 		System.out.println("ENTER THE ELEMENT THAT YOU WANT TO ADD IN THE LINKED LIST");
							addElement = scanner.nextInt();
							linkedlist.addAtEnd(addElement);
							break;
							
			case 4 : 		linkedlist.deleteAtBeginning();
							break;
					
			case 5 : 		System.out.println("ENTER THE INDEX THAT YOU WANT TO DELETE ");
							int deleteIndex = scanner.nextInt();
							linkedlist.deletenode(deleteIndex);
							break;
							
			case 6 :		linkedlist.deleteAtEnd();
							break;
							
			case 7 : 		linkedlist.display();
							break;	
							
			case 8 :		System.out.println("ENTER THE ELEMENT THAT YOU WANT TO SEARCH");
							int searchElement = scanner.nextInt();
							boolean search = linkedlist.search(searchElement);
							if(search) {
								System.out.println("SEARCH ELEMENT IS FOUND");
							}
							else {
								System.out.println("SEARCH ELEMENT IS NOT FOUND");
							}
							break;
							
			case 9 :		flag = 1;
							break;
			
			default :		System.out.println("ENTER THE CORRECT CHOICE");
							break;
			}
			if(flag == 1) {
				break;
			}
			System.out.println("ENTER YOUR CHOICE");
			choice = scanner.nextInt();
		}

		
	}
	
	
}
