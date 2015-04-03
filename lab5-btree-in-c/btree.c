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
    t -> parent = NULL;

    if(tree -> root) { 
      btreeNode_t tmp = tree -> root; 
      while(tmp) { 
	if(tmp -> data > val) { 
	  if(tmp -> left != NULL) tmp = tmp -> left; 
	  else { 
	    tmp -> left = t;
      t->parent=tmp;
	    return 0; 
	  }
	}
	else { 
	  if(tmp -> right != NULL) tmp = tmp -> right; 
	  else { 
	    tmp -> right = t; 
      t->parent=tmp;
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

btreeNode_t process(btreeNode_t node)
{
  printf( "%d \n", node->data );
  return node;
}

void inOrder_iter(btree_t t)
{
  btreeNode_t this=t->root,
              parent=NULL;

  while (this)
  {
    // LEFT
    // end of left
    while (this)
    {
      parent=this;
      this=this->left;
    }
    this=parent;
    // PROCESS
    process(this);
    // RIGHT + (process)
    this=
      (this->right)?
        (this->right)
        :(
          (this->parent->right==this)?
            (process(this->parent->parent)->right)
            :(process(this->parent)->right)
        );
  }
}
