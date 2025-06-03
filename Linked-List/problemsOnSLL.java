class Node
{
    int data;
    Node next;

    Node(int data,Node next)
    {
        this.data = data;
        this.next = next;
    }
}
public class problemsOnSLL
{
    public static void main(String[] args) 
    {
        int arr[] = {1,2,3,4,5};
        Node head = createNode(arr);
        print(head);
        head = reverse(head);
        print(head);
    }
    public static Node createNode(int arr[])
    {
        Node head = new Node(arr[0], null);
        Node mover = head;
        for(int  i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i], null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void print(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static Node reverse(Node head)
    {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
           Node nextNode = temp.next;
           temp.next = prev;
           prev = temp;
           temp = nextNode;
        }
        return prev;
    }
}