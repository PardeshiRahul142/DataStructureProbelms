//1.Undo Feature in a Text Editor
//Scenario: You're building a simple text editor. Implement an undo functionality using stacks.
//Requirements:
//Create a TextEditor class.
//Use a stack to store each operation (insert, delete).
//Implement undo() method to revert the last change.

package org.techhub;
import java.util.Scanner;
class Stack
{
	 int a[]=new int[5];
	 int top=-1;
	 String lastOp="";
	 int lastVal;
	 
	 void insert(int value)
	 {
		 if(top == a.length-1)
		 {
			 System.out.println("Stack overflow");
		 }
		 else
		 {
			 top = top + 1; 
			 a[top]=value;
			 lastVal=value;
			 lastOp="insert";
			 System.out.println("Value inset successfully");
		 }
	 }
	 void delete()
	 {
		 if(top == -1)
		 {
			 System.out.println("Stack empty");
		 }
		 else
		 {
			int value=a[top];
			 top=top-1;
			 lastVal=a[top+1];
			 lastOp="delete";
			 System.out.println("Element deleted :"+value);
		 }
	 }
	 void undo()
	 {
		 if(lastOp.equalsIgnoreCase("insert"))
		{
		  System.out.println("previous operation inserted :"+lastVal);
		}
		else if(lastOp.equalsIgnoreCase("delete"))
		{
			System.out.println("previous operation deleted :"+lastVal);
		}
		else
		{
			System.out.println("No operation perform");
		}
	 }
}
public class TextEditor {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
	    Stack stack=new Stack();
      
	while(true)
	{
		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("Enter choice :");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			   System.out.println("insert element");
			   int value=sc.nextInt();
			   stack.insert(value);			  
			   break;
		case 2:
			  
			   stack.delete();
			   break;	  
		case 3:
			   stack.undo();
			   break;
		case 4:
			   System.exit(0);
			   break;
        default:
        	        System.out.println("Choice miss match");
			    break;
		}
	}
		
	}

}
