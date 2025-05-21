

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
public class deletingHeadAndTail
{
    public static void main(String[] args) {
        int arr [] = {6,4,2,8,2,1,8,0,1};
        Node head = createNodes(arr);
        head = deleteHead(head);
        head = deleteTail(head);
        print(head);
    }
    private static Node createNodes(int arr[])
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
    private static Node deleteHead(Node head)
    {
        if(head==null)
        {
            return null;
        }
        return head.next;
    }
    private static Node deleteTail(Node head)
    {
        if(head.next == null || head == null)
        {
            return null;
        }
        Node temp = head;
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
        temp.next=null;
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
}