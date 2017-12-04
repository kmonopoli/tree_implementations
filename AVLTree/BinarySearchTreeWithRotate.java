public class BinarySearchTreeWithRotate<E extends Comparable<E>>
    extends BinarySearchTree<E> {
    // Methods
    /** is this javadoc flipped with rotateLeft?*?*?
      Method to perform right rotation
      pre:  root is the root of a binary search tree
      post: root.right is the root of a binary search tree // should be root.left?*?*?
         root.right.right is raised one level, // no ?*?*?
         root.right.left does not change levels, // okay ?*?*?
         root.left is lowered one level, // no ?*?*?
         the new root is returned
       @param localRoot
          The root of the binary tree to be rotated
       @return
          The new root of the rotated tree
     */
     protected Node <E> rotateRight(Node <E> localRoot) {
		 Node<E> temp = localRoot.left;
		 localRoot.left = temp.right;
		 temp.right = localRoot;
		 return temp;
     }
     
     /** is this javadoc flipped with rotatRight?*?*?
     Method to perform left rotation
     pre:  root is the root of a binary search tree
     post: root.left is the root of a binary search tree ?*?*? not root.right
        root.left.left is raised one level, ?*?*? not root.right.right
        root.left.right does not change levels, 
        root.right is lowered one level,
        the new root is returned
      @param localRoot
         The root of the binary tree to be rotated
      @return
         The new root of the rotated tree
    */
     // TO BE COMPLETED BY THE STUDENT INCLUDING THE javadoc COMMENTS
     // REFER TO PAGE # 476 IN YOUR BOOK
     // add Javadoc!*!*! be sure above one is not flipped?*?*?
     protected Node <E> rotateLeft(Node <E> localRoot) {
    	 	Node<E> temp = localRoot.right;
    	 	localRoot.right = temp.left;
    	 	temp.left = localRoot;
    	 	return temp;
     }
}


