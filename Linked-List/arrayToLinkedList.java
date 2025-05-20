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
public class arrayToLinkedList
{
    public static void main(String[] args) {
        int arr[] = {2,5,7,9};
        Node head = convert(arr);
        System.out.println(head.data);
    }
    private static Node convert(int arr[])
    {
       Node head = new Node(arr[0]);
       Node mover = head;
       
       for(int i=0;i<arr.length;i++)
       {
        Node temp = new Node(arr[i]);
        mover.next = temp;
        mover = temp;
       }
       return head;
    }
}