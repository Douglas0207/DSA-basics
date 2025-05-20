

class Node{
    int data;
    Node next;
    Node(int data1,Node next1)
    {
        this.data=data1;
        this.next = next1;
    }
    Node(int data1)
    {
        this.data=data1;
        this.next = null;
    }
}
public class traversalInLinkedList
{
    public static void main(String[] args) {
        int arr[] = {2,5,7,9};
        Node head = convert(arr);
        Node temp = head;
        int ctr=0;
        int value = 7;
        int yes=0;
        while(temp!=null)
        {
            if(temp.data == value)
            {
               yes=1;
            }
           System.out.print(temp.data+ " ");
           temp = temp.next;
           ctr++;
        }
        System.out.println("");
        System.out.println("the head of the linked list is "+head.data);
        System.out.println("Length of the Linked List is "+ctr);
        if(yes==1)
        {
            System.out.println("The given value "+value+" is there in the linked list");
        }
        else
        {
            System.out.println("Value is not there");
        }
    }
    private static Node convert(int arr[])
    {
       Node head = new Node(arr[0]);
       Node mover = head;
       
       for(int i=1;i<arr.length;i++)
       {
        Node temp = new Node(arr[i]);
        mover.next = temp;
        mover = temp;
       }
       return head;
    }
}