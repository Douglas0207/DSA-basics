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
public class insertionOfDLL
{
    public static void main(String[] args) 
    {
        int arr[] = {2,3,5,7,8,10};
        Node head = createNode(arr);
        print(head);
        head = insertBeforeHead(head);
        print(head);
        head = insertBeforeTail(head);
        print(head);
        head = insertBeforeK(head,5,4);
        print(head);
        Node findNode = find(head,7);
        insertBeforeNode(findNode,6);
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
        System.out.print("NULL<- ->");
        while(temp!=null)
        {
            System.out.print(temp.data+"<- ->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static Node insertBeforeHead(Node head)
    {
        if(head==null)
        {
            return new Node(1, null, null);
        }
        Node newHead = new Node(1, head, null);
        head.prev = newHead;
        return newHead;
    }
    public static Node insertBeforeTail(Node head)
    {
        if(head==null)
        {
            return new Node(9,null,null);
        }
        if(head.next==null)
        {
            Node newHead = new Node(9, head, null);
            head.prev = newHead;
            return newHead;
        }
        Node temp = head;
        Node back = null;
        while(temp.next!=null)
        {
            back = temp;
            temp = temp.next;
        }
        Node newNode = new Node(9, temp, back);
        back.next=newNode;
        temp.prev=newNode;
        return head;
    }
    public static Node insertBeforeK(Node head,int k,int ele)
    {
        if(head==null)
        {
            return new Node(ele, null, null);
        }
        if(k==1)
        {
            Node newHead = new Node(ele, head, null);
            head.prev = newHead;
            return newHead;
        }
        Node temp = head;
        Node back = null;
        for(int i=1;i<k-1;i++)
        {
            back = temp;
            temp = temp.next;
        }
        if(temp==null)
        {
            System.out.println("Out of bounds");
            return head;
        }
        Node newNode = new Node(ele, temp, back);
        back.next = newNode;
        temp.prev = newNode;
        return head;
    }
    public static Node find(Node head, int val)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==val)
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public static void insertBeforeNode(Node node, int value)
    {
       Node back = node.prev;
       Node newNode = new Node(value,node,back);
       back.next = newNode;
       node.prev = newNode;
    }
}