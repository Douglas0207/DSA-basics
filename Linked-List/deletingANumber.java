class Node
{
    int data;
    Node next ;
    Node(int data,Node next)
    {
        this.data = data;
        this.next = next;
    }
}
public class deletingANumber
{
    public static void main(String[] args) {
        int arr[] = {73,523,42,42,3,4};
        int num = 523;
        Node head = createNodeHead(arr);
        head = deleteNumber(head,num);
        print(head);
    }
    private static Node createNodeHead(int arr[])
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
    private static Node deleteNumber(Node head,int num)
    {
        if(head == null)
        {
            return head;
        }
        if(head.data == num)
        {
            return head.next;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
            if(temp.data == num)
            {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
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
}