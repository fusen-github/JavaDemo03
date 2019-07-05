package packageSorted;

public class SortedLink
{
    private Node header;

    // {78, 102, 35, 52, 100, 12, 3, 2, 88, 9, 17, 4, 67, 7, 48,-20, -30};

    public void sortedArray(Comparable[] array)
    {
        int index = -1;

        for (Comparable obj : array)
        {
            index++;

            Node newNode = new Node(obj);

            if (this.header == null)
            {
                this.header = newNode;
            }
            else
            {
                Node tmpNode = this.header;

                Node previous = null;

                while (tmpNode != null)
                {
                    int rst = tmpNode.value.compareTo(newNode.value);

                    if (rst >= 0)
                    {
                        if (previous != null)
                        {
                            newNode.next = tmpNode;

                            previous.next = newNode;
                        }
                        else
                        {
                            Node oldHeader = this.header;

                            this.header = newNode;

                            this.header.next = oldHeader;
                        }

                        /// 挂到链表上了，跳出对链表的遍历
                        break;
                    }
                    else
                    {
                        if (tmpNode.next == null)
                        {
                            tmpNode.next = newNode;

                            /// 挂到链表上了，跳出对链表的遍历
                            break;
                        }
                        else
                        {
                            previous = tmpNode;

                            tmpNode = tmpNode.next;
                        }
                    }
                }
            }

            if (index == array.length - 1)
            {
                generateArray(index + 1);
            }
        }

        Node tmpNode = this.header;

        int i = 0;

        while (tmpNode != null)
        {
            array[i] = tmpNode.value;
            i++;
            tmpNode = tmpNode.next;
        }


    }

    private void generateArray(int count)
    {
        Comparable[] array = new Integer[count];

        Node tmpNode = this.header;

        int index = 0;

        while (tmpNode != null)
        {
            array[index] = tmpNode.value;
            index++;
            tmpNode = tmpNode.next;
        }

        System.out.println();
    }

    private void printLink()
    {
        Node node = this.header;

        System.out.print("中间打印: ");

        while (node != null)
        {
            System.out.print(node.value + ", ");

            node = node.next;
        }

        System.out.println();
    }

    /*
    private void insertNode(Node newNode) {
        Node tmpNode = this.header;

        Node previous = null;

        while (tmpNode != null) {
            if (tmpNode.value.compareTo(newNode.value) >= 0) {
                newNode.next = tmpNode;

                if (previous != null) {
                    previous.next = newNode;
                } else {
                    this.header = newNode;
                }
            }

            previous = tmpNode;

            tmpNode = tmpNode.next;
        }
    }
    */
}

class Node
{
    Comparable value;
    Node next;

    Node(Comparable value)
    {
        this.value = value;
    }

}
