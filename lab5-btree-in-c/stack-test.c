# include <stdio.h>

typedef struct
{
    int data;
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

StackItem push(Stack stack, int addr)
{
    StackItem t = (StackItem) malloc(sizeof(_StackItem));
    t->data=addr;
    t->next=stack->top;
    stack->top=t;
    return t;
}

int pop(Stack stack)
{
    StackItem item=stack->top;
    if (item)
    {
        stack->top=item->next;
        return item->data;
    }
    return NULL;
}

int main(int argc, char const *argv[])
{
    Stack stack=newStack();
    int i;
    for (i = 0; i < 9; ++i)
    {
        printf("%d\n", (push(stack, i))->data);
    }
    printf("\n");
    for (i = 0; i < 9; ++i)
    {
        printf("%d\n", pop(stack));
    }

    return 0;
}