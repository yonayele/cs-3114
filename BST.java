package project1;

import project1.BinaryNode;

public class BST<T extends Comparable<T>> {
    
    // Instance/static variable . . . . . . . . . .
    private BinaryNode<T> root;
    private int nodecount;
    
    // Constructor . . . . . . . . . .
    BST() {
        root = null;
        nodecount = 0;
    }
    
    // ~ Methods - - - - - - - - - - 
    
    // - - - - - - - - - -
    public void clear() 
    {
        root = null;
        nodecount = 0;
    }
    
    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return root == null;
    }
    
    /**
     * Insert into the tree.
     * @param x    the item to insert.
     */
    public void insert(T x)
    {
        root = insert(x, root);
    }
    
    /**
     * Internal method to insert a value into a subtree.
     *
     * @param x
     *            the item to insert.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws DuplicateItemException
     *             if x is already present.
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> node)
    {
        if (node == null)
        {
            return new BinaryNode<T>(x);
        }
        else if (x.compareTo(node.getElement()) <= 0)
        {
            node.setLeft(insert(x, node.getLeft()));
        }
        else if (x.compareTo(node.getElement()) > 0)
        {
            node.setRight(insert(x, node.getRight()));
        }
        else
        {
            // could just use this else for the right side insertion
        }
        nodecount++;
        return node;
    }
    
    /**
     * Remove the specified value from the tree.
     * @param x    the item to remove.
     * @throws     ItemNotFoundException
     *             if x is not found.
     */
    public void remove(T x)
    {
        root = remove(x, root);
    }
    
    /**
     * Internal method to remove a specified item from a subtree.
     *
     * @param x
     *            the item to remove.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> node)
    {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        BinaryNode<T> result = node;

        // If there's no more subtree to examine
        if (node == null)
        {
            // not sure how to handle this
            throw new ItemNotFoundException(x.toString());
        }

        // if value should be to the left of the root
        if (x.compareTo(node.getElement()) < 0)
        {
            node.setLeft(remove(x, node.getLeft()));
        }
        // if value should be to the right of the root
        else if (x.compareTo(node.getElement()) > 0)
        {
            node.setRight(remove(x, node.getRight()));
        }
        // If value is on the current node
        else
        {
            // If there are two children
            if (node.getLeft() != null && node.getRight() != null)
            {
                T max = findMax(node.getLeft()).getElement();
                remove(max, node);
                node.setElement(max);
            }
            // If there is only one child on the left
            else if (node.getLeft() != null)
            {
                result = node.getLeft();
            }
            // If there is only one child on the right
            else
            {
                result = node.getRight();
            }
        }
        nodecount--;
        return result;
    }
    
    //may not need the following min and max methods
    //I use findMax within my remove though, so maybe only don't 
    // need the findMin
    
    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param node  the node that roots the tree.
     * @return node containing the smallest item.
     *
    private BinaryNode<T> findMin(BinaryNode<T> node)
    {
        if (node == null)
        {
            return node;
        }
        else if (node.getLeft() == null)
        {
            return node;
        }
        else
        {
            return findMin(node.getLeft());
        }
    }*/

    /**
     * Internal method to find the largest item in a subtree with no parameters
     * @return node containing the largest item
     */
    public BinaryNode<T> findMax() {
        return findMax(root);
    }
    
    // ----------------------------------------------------------
    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param node  the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> node)
    {
        if (node == null)
        {
            return node;
        }
        else if (node.getRight() == null)
        {
            return node;
        }
        else
        {
            return findMax(node.getRight());
        }
    }
    
    /**
     * Gets an in-order string representation of the tree
     * If the tree holds  5
     *                  /   \
     *                2      6
     *                 \
     *                  3
     * It would print (2, 3, 5, 6)
     * @return an in-order string representation of the tree
     */
    @Override
    public String toString()
    {
        if (root == null)
        {
            return "()";
        }
        else
        {
            return "(" + root.toString() + ")";
        }
    }
}
