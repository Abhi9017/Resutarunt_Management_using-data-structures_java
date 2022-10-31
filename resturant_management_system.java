import java.util.Scanner;
public class resturant_management_system
{
	static Scanner sc=new Scanner(System.in);
	public static Node head;
	public static int size,size2;
	public static  class Node

	{
		String data;
		Node next;
		float price;
		Node(String data,float price )
		{
			this.data=data;
			this.price=price;
			next=null;
			
			size++;
		}
	}
	/*admin menu*/
public static Node insert()

{
	System.out.println("Enter the Item to Add to Menu");
	String item=sc.next();
	System.out.println("Enter the Price of the "+item+" ");
	Float pris=sc.nextFloat();
	Node n=new Node(item,pris);
	if(head==null)
	{
		head=n;
	}
	else{
	Node t=head;
	while(t.next!=null)
	{
		t=t.next;
	}
	t.next=n;
	}
	return head;
}
		
	//javac -cp mysql-connector-j-8.0.31.jar;. j.java
	public static void admin_print()
	{
		System.out.println("Displaying Items in Menu");
		if(head==null)
		{
			return;
		}
		Node t=head;
		while(t!=null)
		{
			for(int i=1;i<=size;i++)
			{
			System.out.println(i+" " +"."+" "+t.data+"       " +t.price+"$");
			t=t.next;
			}
		}
	}
	public static Node insert_at_n_position()
	{
		System.out.println("enter item to add to menu");
		String item=sc.nextLine();
		
		System.out.println("enter position to Add as Number addressed in Menu Card");
		int Position=sc.nextInt();
		
		System.out.println("Enter the Price of the "+item+" ");
	      Float pris=sc.nextFloat();
		
		Node n=new Node(item,pris);
		if(head==null)
		{
			head=n;
			System.out.println("Added"+item+"to Menu card");
		}
		else if(Position>size)
		{
			System.out.println("Check the Number You have Entered");
		}
		else
		{
			Node h=head;
			int i=1;
			while(i<Position)
			{
				i++;
				h=h.next;
			}
			n.next=h.next;
			h.next=n;
		}
		return head;
	}
	public static Node delete_first()
	{
		if(head==null)
		{
			return null;
		}
		
		head=head.next;
		size--;
		return head;
	}
	public static Node delete_at_any_position()
	{
		System.out.println("Enter the Addrssed number Which You want to delete");
		int pos=sc.nextInt();
	    if(head==null)
		{
			return null;
		}
		else
		{
			Node secondlast=head;
			Node lastnode=head.next;
			int i=1;
			
			while(i<pos-1)
			{
				i++;
				secondlast=secondlast.next;
				lastnode=lastnode.next;
			}
			secondlast.next=lastnode.next;
			size--;
		}
		return head;
	}
	public static void no_of_sales()
	
	{
		if(head2==null)
		{
			System.out.println("NO ITEMS ARE SOLD TILL NOW");
		}
		else
		{
			System.out.println("No of Items Sold till now is :"+ size2);
		}
	}
	//customermenu starts**//
	public static class Node2
	{
		String data;
		Node2 next;
		float price;
		Node2(String data,float price)
		{
			this.data=data;
			next=null;
			this.price=price;
			size2++;
		}
	}
	public static Node2 head2;
	public static Node2 insert_customer()
	{
		if(head==null)
		{
			System.out.println("Menu Items Are Empty");
		}
		if(head2==null)
		{
			System.out.println("Enter Indexed Number to Add to Cart");
			int cartcount=sc.nextInt();
			int i=1;
			Node t=head;
			while(i<cartcount)
			{
				i++;
				t=t.next;
			}
			
			String s=t.data;
			float p=t.price;
			Node2 n=new Node2(s,p);
			head2=n;
			
		}
		else 
		{
			System.out.println("Enter Indexed Number to Add to Cart");
			int cartcount=sc.nextInt();
			int i=1;
			Node t=head;
			while(i<cartcount)
			{
				i++;
				t=t.next;
			}
			
			String s=t.data;
			float p=t.price;
			Node2 n=new Node2(s,p);
			Node2 t2=head2;
			while(t2.next!=null)
			{
				t2=t2.next;
			}
			t2.next=n;
			
		}
		return head2;
	}
	
	public static Node2 customer_delete_first()
	{
		if(head2==null)
		{
			return null;
		}
		
		head2=head2.next;
		size2--;
		return head2;
	}
	public static Node2 customer_delete_any()
	{
			System.out.println("Enter the Addrssed number Which You want to delete");
		int pos=sc.nextInt();
	    if(head2==null)
		{
			return null;
		}
		else
		{
			Node2 secondlast=head2;
			Node2 lastnode=head2.next;
			int i=1;
			
			while(i<pos-1)
			{
				i++;
				secondlast=secondlast.next;
				lastnode=lastnode.next;
			}
			secondlast.next=lastnode.next;
			size2--;
		}
		return head2;
	}
	public static void customer_print() 
	{
		System.out.println("Displaying Items in cart");
		if(head2==null)
		{
			return;
		}
		Node2 t=head2;
		while(t!=null)
		{
			for(int i=1;i<=size2;i++)
			{
			System.out.println(i+" " +"."+" "+t.data+"           "+t.price);
			t=t.next;
		}
		}
	}
	public static void customer_bill_print() 
	{
		
		if(head2==null)
		{
			return;
		}
		float bill=0;
		Node2 t=head2;
		while(t!=null)
		{
			for(int i=1;i<=size2;i++){
			bill=bill+t.price;
			
			t=t.next;
		}
		}
		System.out.println("Your Items Bill in cart"+"  "+bill+"$");
	}
	
	public static void backmenu_of_admin()
	{
		           System.out.println("1.Display the Number of Sales Today");
                   System.out.println("2.Add item to Menu");
				   System.out.println("3.Delete the Menu in Item ");
				   System.out.println("4.Display the Menu Items");
				   System.out.println("0.Back to Main Menu");
				   int option2=sc.nextInt();
				   switch(option2)
				   {
					   case 1:
					        no_of_sales();
							System.out.println("Enter 0 to go back to main menu");
							int r=sc.nextInt();
							switch(r)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
							break;
							
				       case 2:
					       System.out.println("2.Add item In Menu inorder");
					       System.out.println("2.Add item at Particuar Item");
						   int g=sc.nextInt();
						   switch(g)
						   {
							 case 1:  
					         System.out.println("Enter Number of Itemsare to be Adding");
							 int j=sc.nextInt();
							 for(int i=1;i<=j;i++){
					         insert();
							 }
							 admin_print();
							 System.out.println("Enter 0 to go back to main menu");
							int u=sc.nextInt();
							switch(u)
							{
								case 0:
								   backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
							 break;
							 case 2:
							 insert_at_n_position();
							 admin_print();
							 System.out.println("Enter 0 to go back to main menu");
							int t=sc.nextInt();
							switch(t)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
							 break;
						   }
							 break;
					   case 3:
                          System.out.println("1.Delete the First Item");
						  System.out.println("2.Delete the Item at Indexed Based");
						  int h=sc.nextInt();
						  switch(h)
						  {
							  case 1:
							        delete_first();
									admin_print();
									System.out.println("Enter 0 to go back to main menu");
							int l=sc.nextInt();
							switch(l)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									backmenu_of_admin();
									 break;
							}
									break;
						     case 2:
							        delete_at_any_position();
									admin_print();
									System.out.println("Enter 0 to go back to main menu");
							int q=sc.nextInt();
							switch(q)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
									break;
						  }
						  break;
                      case 4:
                            
							admin_print();
							System.out.println("Enter 0 to go back to main menu");
							int v=sc.nextInt();
							switch(v)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									backmenu_of_admin();
									 break;
							}
                            break;
                       case 0:
                           stater();
                         break;							
				   }
			       
	}
	public static void customer_main_menu()
	{
		System.out.println("1.Add Item to Cart");
				 System.out.println("2.Remove Item from Cart");
				 System.out.println("3.Display The Cart Items");
				 System.out.println("4.Display the Item Bills");
				 System.out.println("0.Back to Main Menu");
		         int kl=sc.nextInt();
				 switch(kl)
				 {
				 case 1:
				      admin_print();
				      insert_customer();
					  customer_print();
					  customer_main_menu();
				       break;
			    case 2:
				      System.out.println("1.Delete First Item in  the Cart ");
					  System.out.println("2.Delete the Item As Indexed Incart");
				     int gh=sc.nextInt();
					 switch(gh)
					 {
						 case 1:
						 customer_delete_first();
						 customer_print();
						 break;
						 case 2:
						 customer_print();
						 customer_delete_any();
						 customer_print();
						 break;
						 case 0:
						    customer_main_menu();
					 }
			    case 3:
				      customer_print();
					   customer_main_menu();
					   break;
				  case 4:
				        customer_print();
				        customer_bill_print();
						customer_main_menu();
						break;
			    case 0:
				
				   stater();
				   break;
			
				 }
			
			
	}
	
	public static void stater()
	{
		System.out.println("1.admin");
		System.out.println("2.customer");
		System.out.println("0.To Exit");
		System.out.println("Enter Your Above Choice");
		int option=sc.nextInt();
		switch(option)
		{
			
			case 1:
			       System.out.println("1.Display the Number of Sales Today");
                   System.out.println("2.Add item to Menu");
				   System.out.println("3.Delete the Menu in Item ");
				   System.out.println("4.Display the Menu Items");
				   System.out.println("0.Back to Main Menu");

				   int option2=sc.nextInt();
				   switch(option2)
				   {
					   case 1:
					        no_of_sales();
							System.out.println("Enter 0 to go back to main menu");
							int r=sc.nextInt();
							switch(r)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
							break;
							
				       case 2:
					       System.out.println("1.Add item In Menu inorder");
					       System.out.println("2.Add item at Particuar Item");
						   int g=sc.nextInt();
						   switch(g)
						   {
							 case 1:  
					         System.out.println("Enter Number of Itemsare to be Adding");
							 int j=sc.nextInt();
							 for(int i=1;i<=j;i++){
					         insert();
							 }
							 admin_print();
							 System.out.println("Enter 0 to go back to main menu");
							int u=sc.nextInt();
							switch(u)
							{
								case 0:
								   backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									backmenu_of_admin();
									 break;
							}
							 break;
							 case 2:
							 insert_at_n_position();
							 admin_print();
							 System.out.println("Enter 0 to go back to main menu");
							int t=sc.nextInt();
							switch(t)
							{
								case 0:
								   backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
							 break;
						   }
							 break;
					   case 3:
                          System.out.println("1.Delete the First Item");
						  System.out.println("2.Delete the Item at Indexed Based");
						  int h=sc.nextInt();
						  switch(h)
						  {
							  case 1:
							        delete_first();
									admin_print();
									System.out.println("Enter 0 to go back to main menu");
							int l=sc.nextInt();
							switch(l)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
									break;
						     case 2:
							        delete_at_any_position();
									admin_print();
									System.out.println("Enter 0 to go back to main menu");
							int q=sc.nextInt();
							switch(q)
							{
								case 0:
								  backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									backmenu_of_admin();
									 break;
							}
									break;
						  }
						  break;
                      case 4:
                            
							admin_print();
							System.out.println("Enter 0 to go back to main menu");
							int v=sc.nextInt();
							switch(v)
							{
								case 0:
								    backmenu_of_admin();
								    break;
							    default:
								     System.out.println("Choose the Correct Options");
									 backmenu_of_admin();
									 break;
							}
                            break;
                       case 0:
                          backmenu_of_admin();
                         break;							
				   }
			       break;
		    case 2:
			
			     System.out.println("1.Add Item to Cart");
				 System.out.println("2.Remove Item from Cart");
				 System.out.println("3.Display The Cart Items");
				 System.out.println("4.Display the Items Bill");
				 System.out.println("0.Back to Main Menu");
		         int kl=sc.nextInt();
				 switch(kl)
				 {
				 case 1:
				      admin_print();
				      insert_customer();
					  customer_print();
					  customer_main_menu();
				       break;
			    case 2:
				      System.out.println("1.Delete First Item in  the Cart ");
					  System.out.println("2.Delete the Item As Indexed Incart");
					  System.out.println("0.Get back to menu");
				     int gh=sc.nextInt();
					 switch(gh)
					 {
						 case 1:
						 customer_delete_first();
						 customer_print();
						 break;
						 case 2:
						 customer_print();
						 customer_delete_any();
						 customer_print();
						 break;
						 case 0:
						    customer_main_menu();
					 }
			    case 3:
				     customer_print();
					
					 break;
			    case 4:
				        customer_print();
				        customer_bill_print();
						customer_main_menu();
						break;
			    case 0:
				
				    stater();
				   break;
			
				 }
				 
				case 0:      
			   break;
			   
			   
		}
		
	}
	public static void main(String args[]) 
	{
		stater();
	}
    
}