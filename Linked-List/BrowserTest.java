/*
 * homepage(google)
 * visit(insta)
 * visit(facebook)
 * visit(youtube)
 * back(1)
 * back(1)
 * forward(1)
 * visit(google)
 * forward(2)
 * back(2)
 * back(7)
 */
class Node {
    String data;
    Node prev;
    Node next;

    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class Browser
{
    Node current;

    public Browser(String homepage)
    {
        current = new Node (homepage);
    }
    public void visit(String url)
    {
        Node newNode = new Node (url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }
    public String back(int steps)
    {
        while(steps > 0 && current.prev != null)
        {
            current = current.prev;
            steps--;
        }
        return current.data;
    }
    public String forward(int steps)
    {
        while(steps > 0 && current.next != null)
        {
            current = current.next;
            steps--;
        }
        return current.data;
    }
}
public class BrowserTest {
    public static void main(String[] args) {
        Browser browser = new Browser("google");
        browser.visit("insta");
        browser.visit("facebook");
        browser.visit("youtube");
        System.out.println(browser.back(1));      
        System.out.println(browser.back(1));     
        System.out.println(browser.forward(1));   
        browser.visit("google");
        System.out.println(browser.forward(2));   
        System.out.println(browser.back(2));      
        System.out.println(browser.back(7));     
    }
}

