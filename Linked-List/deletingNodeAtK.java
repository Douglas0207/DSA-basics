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
public class deletingNodeAtK
{
    public static void main(String[] args) {
        int arr[] = { 6,4,7};
        int k = 5;
        Node head = createNodeHead(arr);
        head = deleteNodeAtK(head,k);
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
    private static Node deleteNodeAtK(Node head, int k)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        if(k<=0)
        {
            return head;
        }
        if(k==1)
        {
            return head.next;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
            count++;
          if(count == k)
          {
            prev.next = prev.next.next;
            break;
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