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

void process(int data)
{
    printf("%d :", data);
}

btreeNode_t _process(btreeNode_t item)
{
    if (item)
    {
        process( item->data );
    }
    return item;
}

// STACK >>

struct __StackItem
{
    btreeNode_t data;
    struct __StackItem * next;
};

typedef struct __StackItem _StackItem;
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
    if (item)
    {
        stack->top=item->next;
        return item->data;
    }
    return NULL;
}

// << STACK

void inOrder_iter(btree_t t)
{
    btreeNode_t this=t->root;

    Stack stack=newStack();

    while (this)
    {
        while (this)
        {
            push(stack, this);
            this=this->left;
        }

        while ( (this=pop(stack)) && !(this=(_process(this)->right)) )
        {}
    }

}
