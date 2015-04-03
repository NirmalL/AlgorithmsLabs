#include <bTree.h>
#include <stdio.h>
#include <stdlib.h>

btree_t newTree(void) 
{ 
  btree_t tmp = (btree_t) malloc(sizeof(btree)); 
  if(tmp) tmp -> root = NULL; 
  return tmp; 
} 


int addNode(btree_t tree, int val) 
{ 
  btreeNode_t t = (btreeNode_t)malloc(sizeof(struct btreeNode)); 
  if(t) { 
    t -> data  = val; 
    t -> left  = NULL; 
    t -> right = NULL; 

    if(tree -> root) { 
      btreeNode_t tmp = tree -> root; 
      while(tmp) { 
	if(tmp -> data > val) { 
	  if(tmp -> left != NULL) tmp = tmp -> left; 
	  else { 
	    tmp -> left = t; 
	    return 0; 
	  }
	}
	else { 
	  if(tmp -> right != NULL) tmp = tmp -> right; 
	  else { 
	    tmp -> right = t; 
	    return 0;
	  }
	}	
      }
    }
    else { 
      tree -> root = t; 
    }
  }

  return -1; 
}

void inOderSubTree(btreeNode_t t) 
{ 
  if(t) { 
    inOderSubTree(t -> left); 
    printf("%d : ", t -> data); 
    inOderSubTree(t -> right);
  }
}

void inOrder(btree_t t) 
{ 
  inOderSubTree(t -> root); 
}

void inOrder_iter(btree_t t)
{
  
}
