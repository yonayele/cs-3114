package project1;
//-------------------------------------------------------------------------
/**
* An interface for binary nodes in an unbalanced binary search tree.
*
* @param <T> The type of data element contained in the node.
* @author Yonatan Ayele (yonayele)
* @version 2020.02.14
*/
public interface BinNode<T> {

    /**
     * Returns the element in the node
     * @return the element in the node
     */
    public T getElement();
    
    /**
     * Changes the element of the node to the element provided
     * @param newvalue
     */
    public void setElement(T newvalue);
    
    /**
     * Returns the left child of the node
     * @return the left child
     */
    public BinNode<T> getLeft();
    
    /**
     * Returns the right child of the node
     * @return the right child
     */
    public BinNode<T> getRight();
    
    /**
     * Returns whether or not the node has any non-null children
     * @return whether the node is a leaf
     */
    public boolean isLeaf();
    
}
