public class BinarySearchTree <E extends Comparable <E>>
        extends BinaryTree <E> implements SearchTree <E> {
   // denotes whether the addition is successful
   protected boolean addReturn;

   /**
     Constructor - initializes the tree to an empty tree
     */
   public BinarySearchTree () {
      super() ;
   }

   public BinarySearchTree(E data, BinarySearchTree <E> left,
          BinarySearchTree <E> right)  {
	   super(data, left, right);
   }

   /**
     Searches for a given element in the binary search tree
     @param
           target element to be searched
     @param
           count - to keep track of the comparisons made for this
                   find operations
     @return
           the object if it is found in the tree; null
                     otherwise
    */
   public E find (E target, IntObject count) { 
	   return find( root, target, count);
   }
   /** Recursive find method 
    * @param localRoot The local subtree's root
    * @param target The element to be searched
    * @param count to keep track of the comparisons made for this find operation
      @return the object if it is found in the tree; null otherwise
    */
   private E find( Node<E> localRoot, E target, IntObject count) {
	   if ( localRoot == null) return null;
	   // Compare target with the data field at the root.
	   int compResult = target.compareTo(localRoot.data);
	   count.setData(count.getData()+1); 
	   if (compResult == 0) return localRoot.data;
	   else if (compResult < 0) return find(localRoot.left, target, count);
	   else return find(localRoot.right, target, count); 
   }
   
   /**
     inserts an element into a BST
     @param
           item element that needs to be inserted
     @return true if the insertion is successful, false otherwise
    */
    // Complexity: O(h) - where h is the height of the tree.
    // In the worst case it could be O(n).  But on aveage
    // we can expect a complexity of O(log n)
    public boolean add(E item) {
	   root = add(root, item);
	   return addReturn;
   }

   private Node <E> add (Node <E> localRoot, E item) {
	   if (localRoot == null) {
		   addReturn = true;
		   return new Node<E> (item);
       }

       int compareResult = item.compareTo(localRoot.data);
       if (compareResult == 0) {
		   // item is already in the tree.
		   addReturn = false;
		   return localRoot;
       }

       if (compareResult < 0) {
		   // item has to go in the left subtree of localRoot
		   localRoot.left = add(localRoot.left, item);
		   return localRoot;
       }

       else {
		    // item has to go in the left subtree of localRoot
		    localRoot.right = add(localRoot.right, item);
		    return localRoot;
       }
   }

   /** @return the minimum element in the Set
    * 		null if empty
    */
   public E first() {
	   if (root == null) return null;
	   return first(root);
   }
   /** Recursive first method
    * @param localRoot The local subtree's root
    * @return the minimum element in the Set
    */
   private E first(Node<E> localRoot) {
	   if(localRoot.left == null) {
		   return localRoot.data;
	   } else {
		   return first(localRoot.left);
	   }
   }

   /** @return the maximum element in the Set
    *	   null if empty
    */
   public E last() {
      	if (root == null ) return null;
      	return last(root);
   }
   /** Recursive last method
    * @param localRoot The local subtree's root
    * @return the maximum element in the Set
    */
   private E last(Node<E> localRoot) {
	   if(localRoot.right == null) {
		   return localRoot.data;
	   } else {
		   return last(localRoot.right);
	   }
   }
}
