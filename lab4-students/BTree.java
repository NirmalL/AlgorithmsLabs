public class BTree<T extends Comparable<T>>{ 

    private BTreeNode<T> rootNode; 
    
    public class BTreeNode<T extends Comparable<T>>{ 
	private T data; 
	public BTreeNode<T> left, right; 

	BTreeNode(T data) {
	    this.data = data; 
	    left  = null; 
	    right = null; 
	}
    } /* end TreeNodes */

    public BTree () {
	rootNode = null; 
    }

    public boolean search(T data) { 
	return search(rootNode, data);
    }

    public boolean search(BTreeNode<T> node, T data) {
	if(node != null) { 
	    if(node.data.compareTo(data) == 0) return true; 
	    if(node.data.compareTo(data) > 0) return search(node.left, data);
	    return search(node.right, data);
	}
	return false;
    }


    public void insert(T data) { 	
	BTreeNode<T> newNode = new BTreeNode(data); 
	
	if(rootNode == null) rootNode = newNode; 

	else {
	    BTreeNode<T> node = rootNode;
	    
	    while(node != null) {
		if(node.data.compareTo(data) > 0)  {/* smaller */
		    if(node.left != null)
			node = node.left; 
		    else {
			node.left = newNode; 
			return;
		    }
		}
		else {		    
		    if(node.right != null)
			node = node.right; 
		    else {
			node.right = newNode; 
			return;
		    }
		} /* larger than root */
	    } /* while(true) */
	    assert(false);
	} /* not root node */

    }

    public void pre_order() { 
	pre_order(rootNode); 
    }

    public void pre_order(BTreeNode<T> node) { 
	if(node != null) { 
	    System.out.print(node.data + " ");
	    pre_order(node.left); 
	    pre_order(node.right);
	}
    }


    public void in_order() { 
	in_order(rootNode); 
    }

    public void in_order(BTreeNode<T> node) { 
	if(node != null) { 
	    in_order(node.left); 
	    System.out.print(node.data + " ");
	    in_order(node.right);
	}
    }

    public void post_order() { 
	post_order(rootNode); 
    }

    public void post_order(BTreeNode<T> node) { 
	if(node != null) { 
	    post_order(node.left); 
	    post_order(node.right);
	    System.out.print(node.data + " ");
	}
    }
    
    


	

    public static void main(String [] args) { 

	int max = 10; 

	BTree<Integer> t = new BTree<Integer>(); 

	int random=0;
	for(int i=0; i < max; i++) {
	    random = (int)(Math.random() * 100);
	    t.insert(random);
        System.out.print(random+" ");
	} System.out.println();
	t.in_order(); System.out.println();
	
    }

    

}
	