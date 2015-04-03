#ifndef __STACK__
#define __STACK__


struct btreeNode { 
  int data; 
  struct btreeNode * left;
  struct btreeNode * right; 
  struct btreeNode * parent;
};

typedef struct btreeNode * btreeNode_t; 

typedef struct { 
  btreeNode_t root; 
}btree;

typedef btree * btree_t; 

btree_t newTree(void); 
int addNode(btree_t, int); 
void inOrder(btree_t); 


#endif



  
