public class LinkedListUtils 
{
    public static Node createNode(int arr[])
    {
        Node head = new Node(arr[0],null);
        Node mover = head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i],null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void printList(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
