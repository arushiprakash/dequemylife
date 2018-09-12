package MyDataStructures;

import java.util.Date;

public class Node {
    Node next = null;
    String task; // Task that you want to do
    Date date; // Date the task was added


    public Node(String t, Date d) {
        task = t;
        date = d;
    }

    public String toString()
    {
        return this.date+"\t"+this.task ;
    }

    public Date getDate()
    {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setNext(Node n)
    {
        next = n;
    }
}
