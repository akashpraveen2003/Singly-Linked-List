package linked_list;

import java.util.Scanner;


public class Linked_List {
	static Node head;
	static Node tail;
	static int length;
	
	private void prepend(int element) {
		
		Node node=new Node(element);
		
		if(head==null)
		{
			head=node;
			tail=node;
		}
		else
		{
		
		node.next=head;
		head=node;
		}
		length++;
	}
	
	public static void append(int i)
	{
		Node node=new Node(i);
		if(length==0)
		{
			head=node;
			tail=node;
			
		}
		else
		{
		Node temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=node;
		tail=node;
		}
		length++;
	}
	
	private  boolean addIndex(int element, int index) {
	
		if(index<0 || index>length)
		{
			System.out.println("Enter valid index from 0 to "+(length-1));
			return false;
		}
		else if(index==0)
		{
			prepend(element);
			
		}
		else if(index==length-1)
		{
			append(element);
			
		}
		else
		{
			Node newNode=new Node(element);
			Node temp=head;
			for(int i=0;i<index-1;i++)
			{
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
			length++;
		}
		return true;
	}
	private static Node Remove_Last() {  
		if(length<=0)
		{
			return null;
		}
		 if(length==1)
		{
			length--;
			Node temp=head;
			head=null;
			tail=null;
			return temp;
			
		}
		else if(length==2)
		{
			length--;
			Node temp=head.next;
			head.next=null;
			tail=head;
			return temp;
		}
		else
		{
			length--;
			Node temp=head;
			while(temp.next.next!=null)
			{
				temp=temp.next;
			}
			System.out.println(temp.next.value);
			temp.next=null;
			tail=temp;
			return temp.next;
		}
	}
	private static Node Remove_First() {
		if(head==null)
		{
			return null;
		}
		head=head.next;
		length--;
		return head;
	}
	private Node RemoveIndex(int index) {
		
		if(head==null)
		{
			System.out.println("No element present in the list");
		}
		if(index<0 || index>length)
	    {
	    	System.out.println("Enter a valid index from 0 to "+ (length-1));
	    	return null;
	    }
		else if(index==0)
		{
			return Remove_First();
		}
		else if(index==length)
		{
			return Remove_Last();
		}
		else
		{
			Node temp=head;
			Node temp1=head.next;
			for(int i=0;i<index-1;i++)
			{
				temp=temp1;
				temp1=temp1.next;
			}
			temp.next=temp1.next;
			return temp1;
		}
		
	}
	private static Node getElement(int index) {
		if(index<0 || index>=length)
		{
			return null;
		}
		else if(index==0)
		{
			return head;
		}
		else if(index==length-1)
		{
			return tail;
		}
		else
		{
			Node temp=head;
			for(int i=0;i<index;i++)
			{
				temp=temp.next;
			}
			return temp;
		}
	}
	private boolean SetElement(int index,int element) {
		if(index<0 || index>=length)
		{
			return false;
		}
		else
		{
			Node temp=getElement(index);
			temp.value=element;
			return true;
			
		}
	}
	private static Node getTail() {
		
		return tail;
		
	}
	private static Node getHead() {
		return head;
	}
	private static void display() {
		
		if(length==0)
		{
			System.out.println("Empty List");
		}
		System.out.print (length+  "      The elements in the list are : ");
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.value+"  ");
			temp=temp.next;
		}
		System.out.println();
		
	}
	private static void reverse() {
		
		tail=head;
		Node answer=null;
		Node current=head;
		while(current!=null)
		{
			Node nextNode=current.next;
			current.next=answer;
			answer=current;
			current=nextNode;
		}
		head=answer;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linked_List node =new Linked_List();
		Scanner scanner=new Scanner(System.in);
	
		while(true)
		{
			System.out.println("Enter the input \n 1) Add an element at first \n 2) Add an element at particular index   \n 3)  Append an element at last   \n "
					+ "4) Remove an element at first \n 5) Remove an element at particular index in the list  \n 6) Remove an element at last  "
					+ " \n 7) Get the head of the list  \n 8) Get the tail of the list \n 9) Get the value present in the index \n"
					+ " 10) Update the value present in the index \n 11) Reverse the LinkedList");
			
		
			int choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter the element to be prepended : ");
				int element=scanner.nextInt();
				node.prepend(element);
				System.out.println(element + " is successfully inserted");
				node.display();
				break;
				
				
			}
			case 2:
			{
				System.out.println("Enter the element : ");
				int element=scanner.nextInt();
				System.out.println("Enter the index ");
				int index=scanner.nextInt();
				if(node.addIndex(element,index))
				{
					System.out.println(element + " is successfully inserted");
				}
				
				node.display();
				break;
				
				
			
				
			}
			case 3:
			{
				

				System.out.println("Enter the element to be appended : ");
				int element=scanner.nextInt();
				node.append(element);
				System.out.println(element + " is successfully inserted");
				node.display();
				break;
				
				
				
			}
			case 4:
			{
				Node temp=node.Remove_First();
				if(temp==null)
				{
					System.out.println("List is empty");
				}
				else
				{
				System.out.println(temp.value);
				}
				node.display();
				break;
				
			}
			case 5:
			{
				System.out.println("Enter the element of the index to be removed ");
				int index=scanner.nextInt();
				Node element=node.RemoveIndex(index);
				if(element==null)
				{
					System.out.println("List is Empty");
				}
				else
				{
				System.out.println(element.value + " is successfully deleted");
				
				}
				node.display();
				break;
			}
			case 6:
			{
				Node element=node.Remove_Last();
				if(element!=null)
				{
				System.out.println(element.value+ " is successfully deleted");
				node.display();
				}
				else
				{
					System.out.println("Empty List");
				}
				
				break;
			}
			case 7:
			{
				Node element=node.getHead();
				if(element==null)
				{
					System.out.println("Empty List");
				}
				else
				{
					System.out.println(element.value);
				}
				break;
			}
			case 8:
			{
				Node element=node.getTail();
				if(element==null)
				{
					System.out.println("Empty List");
				}
				else
				{
					System.out.println(element.value);
				}
				break;
			}
			case 9:
			{
				System.out.println("Enter the index of the element to be fetched ");
				int index=scanner.nextInt();
				Node element=node.getElement(index);
				if(element==null)
				{
					System.out.println("Entered index is invalid");
				}
				else
				{
				System.out.println("The element present in the given index is "+element.value);
				}
				break;
			}
			case 10:
			{
				System.out.println("Enter the index of the element to be updated ");
				int index=scanner.nextInt();
				System.out.println("Enter the value to be updated ");
				int element=scanner.nextInt();
				if(!node.SetElement(index,element))
				{
					System.out.println("Entered index is invalid");
				}
				else
				{
				System.out.println("The element present in the given index is updated");
				}
				node.display();
				break;
				
			}
			case 11:
			{
				reverse();
				System.out.println("List after reversed ");
				node.display();
				break;
			}
			default:
			{
				System.out.println("Enter a valid input");
			}
			}
		
	}
	}
}

	