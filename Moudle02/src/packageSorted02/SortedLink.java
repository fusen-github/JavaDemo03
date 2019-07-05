package packageSorted02;

public class SortedLink {

    private Node header;

    public static void sortedArray(Comparable[] array)
    {
        SortedLink link = new SortedLink();

        for (Comparable comparable : array)
        {
            link.insertValue(comparable);
        }

        Node current = link.header;

        int index = 0;

        while (current != null)
        {
            array[index] = current.getValue();
            current = current.next;
            index++;
        }

    }

    private SortedLink()
    {

    }

    private void insertValue(Comparable value)
    {
        Node newNode = new Node(value);

        Node currentNode = this.header;

        Node previousNode = null;

        while (currentNode != null && currentNode.getValue().compareTo(value) < 0)
        {
            previousNode = currentNode;

            currentNode = currentNode.next;
        }

        if (previousNode == null)
        {
            this.header = newNode;
        }
        else
        {
            previousNode.next = newNode;
        }

        newNode.next = currentNode;
    }

}

class Node
{
    public Node next;

    private Comparable value;

    public Node(Comparable value)
    {
        this.value = value;
    }

    public Comparable getValue()
    {
        return this.value;
    }

}
