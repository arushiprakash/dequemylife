package MyDataStructures;

import java.util.Date;

public class Queue {

    Node first, last;
    int size;

    public Queue()
    {
        size = 0;
    }

    public void enqueue(String t, Date d)
    {
        // Adds new nodes to the MyDataStructures.Queue

        if (first != null)
        // MyDataStructures.Queue has objects already
        {
            last.next = new Node(t,d);
            last = last.next;
        }

        else
            // MyDataStructures.Queue is empty
        {
            last = new Node(t,d);
            first = last;
        }

        size++;
    }

    public Node dequeue()
    {
        // Deletes the first node from the MyDataStructures.Queue

        if (first != null)
        {
            String task = first.task;
            Date time = first.date;
            first = first.next;
            size--;
            return new Node(task,time);
        }
        else
            return null;
    }

    public String printQueue()
    {
        // Prints the entire MyDataStructures.Queue
        // Strings separated by new line
        StringBuilder q = new StringBuilder();
        Node temp = first;

        while (temp != null)
            // If there are objects in the queue
        {
            q = q.append(temp.toString() + "\n");
            temp = temp.next;
        }

        return q.toString();
    }

    public boolean isEmpty()
    {
        // Checks if MyDataStructures.Queue is empty

        boolean empty = false;
        if (first == null)
            empty = true;

        return empty;
    }

    public void clear()
    {
        // Delete all objects in the MyDataStructures.Queue
        // How does this affect memory?
        first = null;
        last = null;
        size = 0;
    }

    public String peek()
    {
        // Shows first element of the MyDataStructures.Queue
        String top = "MyDataStructures.Queue is empty";
        if (first != null)
            top = first.task;

        return top;
    }

    public int getSize()
    {
        return size;
    }

}
