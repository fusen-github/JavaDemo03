package BinaryTree;

public class SearchBinaryTree01 {

    public static void main(String[] args) {

    }
}


class Tree
{
    private Node root;

    public void insertNode(int id, double dd)
    {
        Node newNode = new Node();

        newNode.anInt = id;
        newNode.aDouble = dd;

        if (this.root == null)
        {
            this.root = newNode;
            return;
        }

        Node current = root;

        while (current != null)
        {
            if (id < current.anInt)
            {
                /// 如果当前的左子树是空，就把新节点设置为左子树
                if (current.leftChild == null)
                {
                    current.leftChild = newNode;

                    return;
                }
                else
                {
                    current = current.leftChild;
                }
            }
            else
            {
                if (current.rightChild == null)
                {
                    current.rightChild = newNode;

                    return;
                }
                else
                {
                    current = current.rightChild;
                }
            }
        }
    }

    public Node findNode(int key)
    {
        Node target = this.root;

        while (target != null)
        {
            if (key < target.anInt)
            {
                /// 左子树
                target = target.leftChild;
            }
            else if (key > target.anInt)
            {
                /// 右子树
                target = target.rightChild;
            }
            else
            {
                break;
            }
        }

        return target;
    }


    public Node deleteNode(int key)
    {
        /// 记录父节点
        Node parent = null;

        Node target = this.root;

        /// 寻找目标节点
        while (target != null)
        {
            if (key < target.anInt) /// 左子树
            {
                parent = target;

                target = target.leftChild;
            }
            else if (key > target.anInt) // 右子树
            {
                parent = target;

                target = target.rightChild;
            }
            else
            {
                break;
            }
        }

        /// 返回null，就是没有找到要删除的点
        if (target == null)
        {
            return null;
        }


        /*
        * 找到要删除的节点后分三种情况
        * 1、待删除节点没有子节点
        * 2、待删除节点有一个子节点
        * 3、待删除节点有两个子节点
        * */

        if (target.leftChild == null && target.rightChild == null)
        {
            if (target == this.root)
            {
                this.root = null;
            }
            else
            {
                if (parent.leftChild == target)
                {
                    parent.leftChild = null;
                }
                else
                {
                    parent.rightChild = null;
                }
            }
        }
        else if (target.rightChild == null)
        {
            if (target == this.root)
            {
                this.root = target.leftChild;
            }
            else
            {
                if (parent.leftChild == target)
                {
                    parent.leftChild = target.leftChild;
                }
                else
                {
                    parent.rightChild = target.leftChild;
                }
            }
        }
        else if (target.leftChild == null)
        {
            if (target == this.root)
            {
                this.root = target.rightChild;
            }
            else
            {
                if (parent.leftChild == target)
                {
                    parent.leftChild = target.rightChild;
                }
                else
                {
                    parent.rightChild = target.rightChild;
                }
            }
        }
        else
        {
            /// 继承节点(右子树的最后一个左子孙节点)
            Node successor = target.rightChild;

            Node successorParent = null;

            while (successor.leftChild != null)
            {
                successorParent = successor;

                successor = successor.leftChild;
            }

            ///  继承节点不是待删除节点的右节点
            if (successorParent != null)
            {
                successorParent.leftChild = successor.rightChild;

                successor.rightChild = target.rightChild;
            }

            successor.leftChild = target.leftChild;

            if (parent.leftChild == target)
            {
                parent.leftChild = successor;
            }
            else
            {
                parent.rightChild = successor;
            }
        }


        return null;
    }

}

class Node
{
    public int anInt;
    public double aDouble;
    public Node leftChild;
    public Node rightChild;

    public void displayNode()
    {
        System.out.println("{anInt:" + anInt + ", aDouble:" + aDouble + "}");
    }
}
