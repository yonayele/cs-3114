package project1;
//-------------------------------------------------------------------------
/**
 * A basic node stored in an unbalanced binary search tree.
 * This class is not accessible outside of this package.
 *
 * @param <T> The type of data element contained in the node.
 * @author Yonatan Ayele (yonayele)
 * @version 2020.02.14
 */
class BinaryNode<T extends Comparable<? super T>> implements BinNode<T>
{
    //~ Instance/static variables .............................................

    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a node with all null fields
     */
    BinaryNode() {
        left = right = null;
        element = null;
    }
    
    /**
     * Creates a node with no children.
     * @param theElement the element to store in this node.
     */
    BinaryNode(T theElement)
    {
        element = theElement;
        left = null;
        right = null;
    }

    /**
     * Creates a node with element and children
     */
    BinaryNode(T theElement, BinaryNode<T> l, BinaryNode<T> r) {
        element = theElement;
        left = l;
        right = r;
    }
    
    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Get the current data value stored in this node.
     * @return the element
     */
    public T getElement()
    {
        return element;
    }


    // ----------------------------------------------------------
    /**
     * Set the data value stored in this node.
     * @param value the new data value to set
     */
    public void setElement(T value)
    {
        element = value;
    }


    // ----------------------------------------------------------
    /**
     * Get the left child of this node.
     * @return a reference to the left child.
     */
    public BinaryNode<T> getLeft()
    {
        return left;
    }


    // ----------------------------------------------------------
    /**
     * Set this node's left child.
     * @param value the node to point to as the left child.
     */
    public void setLeft(BinaryNode<T> value)
    {
        left = value;
    }


    // ----------------------------------------------------------
    /**
     * Get the right child of this node.
     * @return a reference to the right child.
     */
    public BinaryNode<T> getRight()
    {
        return right;
    }


    // ----------------------------------------------------------
    /**
     * Set this node's right child.
     * @param value the node to point to as the right child.
     */
    public void setRight(BinaryNode<T> value)
    {
        right = value;
    }

    /**
     * Returns boolean of whether this node is a leaf node or not
     */
    public boolean isLeaf() {
        return (left == null && right == null);
    }
    
    // ----------------------------------------------------------
    /**
     * Provides an in-order representation of the string
     * @return a string representation of the node
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (left != null)
        {
            builder.append(left.toString() + ", ");
        }
        builder.append(element.toString());
        if (right != null)
        {
            builder.append(", " + right.toString());
        }
        return builder.toString();
    }
}
