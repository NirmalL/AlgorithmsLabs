#include <stdio.h>
#include <bTree.h>


int main() 
{
  int a[] = {11, 23, 2, 3, 5 , 67}; 
  btree_t tree = newTree(); 
  int i; 
  for(i=0; i< sizeof(a)/sizeof(int); i++) 
    addNode(tree, a[i]); 

  inOrder_iter(tree);
}
 
