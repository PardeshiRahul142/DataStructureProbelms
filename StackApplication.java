package org.techhub;
import java.util.*;
class MyStack
{
	int arr[]=new int[5];
	int top=-1;
	
	void push(int value)
	{
		if(top==(arr.length-1))
		{
			System.out.println("Stack overflow");
		}
		else
		{
			top=top+1;
			arr[top]=value;
			System.out.println("values inseted successfully");
		}
	}
	int pop()
	{
		if(top == -1)
		{
			return -1;
		}
		else
		{
			int value=arr[top];
			top=top-1;
			return value;
		}
	}
	void display()
	{
		if(top==-1)
		{
			System.out.println("Stack underFlow");
		}
		else
		{
			for(int i=top ; i>=0;i--)
			{
				System.out.printf("%d\n",arr[i]);
			}
		}
	}
}
public class StackApplication {

	public static void main(String[] args) {
		MyStack stack=new MyStack();
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("1.push");
			System.out.println("2.pop");
			System.out.println("3.Disply");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				    System.out.println("Enter the value is stack");
				    int value=sc.nextInt();
				    stack.push(value);
				    break;
				   
			case 2:
				  value =stack.pop();
			      if(value == -1)
			      {
			   	   System.out.println("Stack underflow");
			      }
			      else
			      {
			    	  System.out.println("Removed value from stack :"+value);
			      }
			       break;
			case 3:
				   stack.display();
				   break;
			case 4:
				    System.exit(0);
				    break;
	         default :
	        	           System.out.println("wrong input");
	}
		}
		

	}

}
