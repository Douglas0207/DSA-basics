public class findIntersectionPoint {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Utility methods
    static class LinkedListUtils {
        public static Node createNode(int[] arr) {
            if (arr.length == 0) return null;
            Node head = new Node(arr[0]);
            Node current = head;
            for (int i = 1; i < arr.length; i++) {
                current.next = new Node(arr[i]);
                current = current.next;
            }
            return head;
        }

        public static void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    // Main function
    public static void main(String[] args) {
        // Common part: 6 -> 2
        Node common = LinkedListUtils.createNode(new int[]{6, 2});

        // First list: 3 -> 1 -> 4 -> 6 -> 2
        Node head1 = LinkedListUtils.createNode(new int[]{3, 1, 4});
        Node tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }
        tail1.next = common;

        // Second list: 1 -> 2 -> 4 -> 5 -> 6 -> 2
        Node head2 = LinkedListUtils.createNode(new int[]{1, 2, 4, 5});
        Node tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        tail2.next = common;

        // Find intersection
        Node answer = findCollisionPoint(head1, head2);
        if (answer != null)
            System.out.println("Intersection at node: " + answer.data);
        else
            System.out.println("No intersection found");
    }

    // Optimal approach
    public static Node findCollisionPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        Node t1 = head1;
        Node t2 = head2;

        while (t1 != t2) {
            t1 = (t1 == null) ? head2 : t1.next;
            t2 = (t2 == null) ? head1 : t2.next;
        }

        return t1; // Intersection node or null
    }
}
