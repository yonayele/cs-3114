package project1;
import student.TestCase;

/**
 * Tests the methods in the Lab14BinarySearchTree method
 * @author Yonatan Ayele (yonayele)
 * @version 2020.02.14
 *
 */
public class BSTTest extends TestCase {
    // ~ Fields....
    private BST<String> tree;
    private BST<String> emptyTree;
    
    // ~ Methods....
    
    //----
    /**
     * Sets up the tests before they run
     */
    public void setUp() {
        tree = new BST<String>();
        emptyTree = new BST<String>();
        tree.insert("O");
        tree.insert("H");
        tree.insert("V");
        tree.insert("E");
        tree.insert("L");
        tree.insert("A");
        tree.insert("Q");
        tree.insert("S");
        tree.insert("Y");
    }
    
    /**
     * Tests the insert method
     */
    public void testInsert() {
        assertTrue(tree.toString()
            .equals("(A, E, H, L, O, Q, S, V, Y)"));
            tree.insert("E");
        assertTrue(tree.toString().equals("(A, E, E, H, L, O, Q, S, V, Y)"));
    }
    
    /**
     * Tests the remove method when the data to remove is on the right
     * or left of the original root and has two children
     */
    public void testRemoveLeftRightRoot() {
        try {
            emptyTree.remove("S");
        }
        catch (ItemNotFoundException inf) {
            assertNotNull(inf);
        }
        tree.remove("H");
        tree.remove("V");
        assertTrue(tree.toString()
            .equals("(A, E, L, O, Q, S, Y)"));
    }
    
    /**
     * Tests the remove method when the data to remove has only one
     * child, on the left or right
     */
    public void testRemoveLeftRightKids() {
        tree.remove("E");
        tree.remove("Q");
        assertTrue(tree.toString()
            .equals("(A, H, L, O, S, V, Y)"));
    }
    
    /**
     * Tests the findMin method
     *
    public void testFindMin() {
        assertNull(emptyTree.findMin());
        assertTrue(tree.findMin().equals("A"));
        tree.remove("A");
        tree.remove("E");
        assertTrue(tree.findMin().equals("H"));
    }/
    
    /**
     * Tests the findMax method
     */
    public void testFindMax() {
        assertNull(emptyTree.findMax());
        System.out.println(tree.toString());
        assertTrue(tree.findMax().getElement().equals("Y"));
        tree.remove("Y");
        tree.remove("V");
        assertTrue(tree.findMax().getElement().equals("S"));
    }
    
    /**
     * Tests the find method
     * 
     *
    public void testFind() {
        assertNotNull(tree.find("S"));
        assertNull(tree.find("M"));
    }*/
    
    /**
     * Tests the makeEmpty method
     */
    public void testClear() {
        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());
    }
    
    /**
     * Tests the toString method when the tree is empty
     */
    public void testToString() {
        assertTrue(emptyTree.toString().equals("()"));
    }
    
}
