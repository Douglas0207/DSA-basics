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
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class basicsOfDLL
{
  public static void main(String[] args) {
      int arr[] = {1,2,3,4,5,6,7,8};
      Node head = createNode(arr);
      print(head);
      head = deleteHead(head);
      print(head);
      head = deleteTail(head);
      print(head);
      head = deleteAtK(head,4);
      print(head);
  }
  public static Node createNode(int arr[])
  {
    Node head = new Node(arr[0]);
    Node mover = head;
    for(int i=1;i<arr.length;i++)
    {
        Node temp = new Node(arr[i],null,mover);
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
   public static Node deleteHead(Node head)
   {
    if(head==null || head.next==null)
    {
      return null;
    }
    Node temp = head;
    head = head.next;
    head.prev = null;
    temp.next = null;
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
    Node newlast = temp.prev;
    newlast.next = null;
    temp.prev = null;
    return head;
   }
public static Node deleteAtK(Node head, int k)
{
  if(head==null)
  {
    return null;
  }
  if(k==1)
  {
    Node newHead = head.next;
    if(newHead!=null)
    {
      newHead.prev = null;
    }
    return newHead;
  }
  Node temp = head;
  Node mover = null;
   for(int i=1;i<=k-1;i++)
   {
    mover = temp;
     temp = temp.next;
   }
   if(temp==null)
   {
    return head;
   }
   mover.next = temp.next;
   if(temp.next!=null)
   temp.next.prev = mover;
   temp.next = null;
   temp.prev = null;
  return head;
}
}