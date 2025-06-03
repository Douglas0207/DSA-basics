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

public class test
{
    public static void main(String[] args) 
    {
        int arr [] = {23,62,11,21,56,43,26,87,95,45};
        Node head = createDoublyLinkedList(arr);
        print(head);
        head = deleteHead(head);
        print(head);
        head = deleteTail(head);
        print(head);
        head = deleteAtK(head,5);
        print(head);
        head = deleteNode(head,11);
        print(head);
    }
    public static void print(Node head)
    {
       Node temp = head;
       System.out.print("Null<- ->");
       while(temp!=null)
       {
        System.out.print(temp.data+"<- ->");
        temp=temp.next;
       }
       System.out.println("Null");
    }
    public static Node createDoublyLinkedList(int arr[])
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
    public static Node deleteHead(Node head)
    {
       if(head==null || head.next==null)
       {
        return null;
       }
       Node temp = head;
       head = head.next;
       temp.next=null;
       head.prev = null;
       return head;
    }
    public static Node deleteTail(Node head)
    {
        if(head==null || head.next==null)
        {
         return null;
        }
        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        Node newTail = temp.prev;
        newTail.next = null;
        temp.prev = null;
        return head;
    }
    public static Node deleteAtK(Node head,int k)
    {
        if(head==null)
        {
            return null;
        }
        if(k==1)
        {
            Node newHead = head.next;
            newHead.prev = null;
            head.next =null;
            return newHead;
        }
        Node temp = head;
        Node mover = null;
        for(int i=1;i<=k-1;i++)
        {
            if(temp==null)
            {
                System.out.println("Out of Bounds");
                return head;
            }
            mover = temp;
            temp = temp.next;
        }
        if(temp==null)
        {
            System.out.println("out of bounds");
            return head;
        }
        mover.next = temp.next;
        temp.next.prev = mover;
        temp.next = null;
        temp.prev = null;
        return head;
    }
    public static Node deleteNode(Node head,int ele)
    {
        if(head==null)
        {
            return null;
        }
        if(head.data==ele)
        {
            Node newHead = head.next;
            newHead.prev = null;
            head.next = null;
            return newHead;
        }
        Node temp = head;
        Node mover = null;
        while(temp!=null && temp.data!=ele)
        {
           mover = temp;
           temp = temp.next;
        }
        if(temp==null)
        {
            System.out.println("Out of Bounds");
            return head;
        }
        mover.next = temp.next;
        if(temp.next!=null)
        {
        temp.next.prev = mover;
        }
        temp.next = null;
        temp.prev = null;
        return head;
    }
}