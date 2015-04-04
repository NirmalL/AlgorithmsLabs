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
        t -> data    = val; 
        t -> left    = NULL; 
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

btreeNode_t process(btreeNode_t item)
{
    printf( "%d \n", item->data );
    return item;
}

// STACK >>

typedef struct
{
    btreeNode_t data;
    struct StackItem * next;
} _StackItem;

typedef _StackItem * StackItem;

typedef struct
{
    StackItem top;
} _Stack;

typedef _Stack * Stack;

Stack newStack()
{
    Stack tmp = (Stack) malloc(sizeof(_Stack)); 
    if(tmp) tmp -> top = NULL; 
    return tmp;
}

StackItem push(Stack stack, btreeNode_t addr)
{
    StackItem t = (StackItem) malloc(sizeof(_StackItem));
    t->data=addr;
    t->next=stack->top;
    stack->top=t;
    return t;
}

btreeNode_t pop(Stack stack)
{
    StackItem item=stack->top;
    stack->top=stack->top->next;
    return item->data;
}

// << STACK

void inOrder_iter(btree_t t)
{
    btreeNode_t 
        this=t->root,
        last=NULL;

    while (this)
    {
        // LEFT
        // end of left
        if ( last->parent && (last->parent->right != this) )
        {
            while (this)
            {
                last=this;
                this=this->left;
            }
            this=last;
        }
        // PROCESS
        process(this);
        // RIGHT
        if (this->right)
        {
            this=this->right;
        }
        // go up
        else
        {
            last=this;
            process(this->parent);
            this=this->parent->right;
        }
    }
}
