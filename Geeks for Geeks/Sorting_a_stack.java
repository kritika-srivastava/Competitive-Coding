import java.util.*;


class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
	
 class LinkedList_Intersection
{
    Node head = null;  
	Node tail = null;

public void addToTheLast(Node node) 
{

  if (head == null) {
   head = node;
   tail = head;
  } else {
   //Node temp = head;
   //while (temp.next != null)
    //temp = temp.next;

   //temp.next = node;
   tail.next=node;
   tail = node;
  }
}

  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
    public static void main(String args[])
    {
       
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			LinkedList_Intersection llist1 = new LinkedList_Intersection();
		    LinkedList_Intersection llist2 = new LinkedList_Intersection();
			LinkedList_Intersection llist3 = new LinkedList_Intersection();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				Node tail1= head1;
				
				for (int i = 1; i < n1; i++) 
				{
					int a = sc.nextInt(); 
					tail1.next = (new Node(a));
					tail1= tail1.next;
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				Node tail2 = head2;
				for (int i = 1; i < n2; i++) 
				{
					int b = sc.nextInt();  
					tail2.next = (new Node(b));
					tail2= tail2.next;
				}
				
				int c1=sc.nextInt();
				Node head3= new Node(c1);
				tail1.next = head3;
				tail2.next = head3;
				Node tail3=head3;
				for (int i = 1; i < n3; i++) 
				{
					int c = sc.nextInt();   
					tail3.next = (new Node(c));
					tail3= tail3.next;
				}
				
				Intersect obj = new Intersect();
				System.out.println(obj.intersectPoint(head1, head2));
			t--;			
         }
    }
}
class Intersect
{
	int intersectPoint(Node headA, Node headB)
	{
		int c1 = getCount(headA);
		int c2 = getCount(headB);
		int d;
		
		if(c1 > c2)
		{
			d = c1-c2;
			return _getintersectionNode(d,headA,headB);
			
		}
		else
		{
			d = c2-c1;
			return _getintersectionNode(d,headB,headA);
		}
	}
	
	int _getintersectionNode(int d,Node node1,Node node2)
	{
		int i;
		Node current1 = node1;
		Node current2 = node2;
		for(i=0;i<d;i++)
		{
			if(current1 == null)
			{
				return -1;
			}
			current1 = current1.next;
		}
		while(current1 != null && current2 != null)
		{
			if(current1 == current2)
			{
				return current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;		
		}
		return -1;
	}
	
	int getCount(Node node)
	{
		Node current = node;
		int count = 0;
		while(current != null)
		{
			count++;
			current = current.next;
		}
		return count;
	}
}



