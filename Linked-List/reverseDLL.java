class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data,Node next,Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
public class reverseDLL
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
        Node head = new Node(arr[0], null, null);
        Node mover = head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i], null, mover);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static void print(Node head)
    {
        Node temp = head;
        System.out.println("NULL");
        while(temp!=null)
        {
            System.out.print(temp.data+"<- ->");
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
        if(head.next ==null)
        {
            return head;
        }
        Node temp = head;
        Node back = null;
        while(temp!=null)
        {
            Node newNode = temp.next;
            temp.next = back;
            temp.prev = newNode;
            back = temp;
            temp = newNode;
        }
        return back;
    }
}
