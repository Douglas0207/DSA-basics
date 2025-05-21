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
public class deletingHead
{
    public static void main(String[] args) {
        int arr [] = {4,1,3,2,7,1,4,2};
        Node head = createNode(arr);
        head = deleteNode(head);
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
    private static Node createNode(int arr[])
    {
        Node head = new Node(arr[0],null);
        Node mover = head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i], null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    private static Node deleteNode(Node head)
    {
        if(head==null)
        {
            return null;
        }
        return head.next;
    }
}