#define CHAR /* 字符型 */
#include <stdio.h> /* EOF(=^Z或F6),NULL */
#include <stdlib.h>
#include <math.h> /* floor(),ceil(),abs() */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define STACK_INIT_SIZE 10 /* 存储空间初始分配量 */
#define STACKINCREMENT 2 /* 存储空间分配增量 */
typedef int Status; /* Status是函数的类型,其值是函数结果状态代码，如OK等 */
#ifdef CHAR
typedef char TElemType;
TElemType Nil = ' '; /* 字符型以空格符为空 */
#endif
#ifdef INT
typedef int TElemType;
TElemType Nil = 0; /* 整型以0为空 */
#endif
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild; /* 左右孩子指针 */
}BiTNode, *BiTree;
typedef BiTree SElemType; /* 设栈元素为二叉树的指针类型 */
typedef struct SqStack
{
	SElemType data;
	struct SqStack * next;
}SqStack;		//
typedef struct SqStack * link;
link Stack = NULL;
Status InitBiTree(BiTree *T)
{ /* 操作结果: 构造空二叉树T */
	*T = NULL;
	return OK;
}
void CreateBiTree(BiTree *T)
{
	TElemType ch;
#ifdef CHAR
	scanf("%c", &ch);
#endif
#ifdef INT
	scanf("%d", &ch);
#endif
	if (ch == Nil) /* 空 */
		*T = NULL;
	else
	{
		*T = (BiTree)malloc(sizeof(BiTNode));
		if (!*T)
			exit(OVERFLOW);
		(*T)->data = ch; /* 生成根结点 */
		CreateBiTree(&(*T)->lchild); /* 构造左子树 */
		CreateBiTree(&(*T)->rchild); /* 构造右子树 */
	}
}
//
Status StackEmpty(SqStack S)
{
	if (Stack == NULL)
		return TRUE;
	else
		return FALSE;
}
//进栈
Status Push(SqStack *S, SElemType e)
{
	link newnode;
	newnode = (SqStack*)malloc(sizeof(SqStack));
	newnode->data = e;
	newnode->next = Stack;
	Stack = newnode;
	return OK;
}
//返回栈顶元素
Status Pop(SqStack *S, SElemType *e)
{
	link p;
	if (Stack == NULL)
		return ERROR;
	
	else
	{
		p = Stack;
		*e = p->data;
		Stack = p->next;
		free(p);
	}
	return OK;
}
//中序遍历
Status InorderTraversel(BiTree T, Status(*Visit)(TElemType))
{
	SqStack S;
	while (T || !StackEmpty(S)) {
		if (T) {
			Push(&S, T);
			T = T->lchild;
		}
		else
		{
			Pop(&S, &T);
			if (!Visit(T->data))
				return ERROR;
			T = T->rchild;
		}
	}
	printf("\n");
	return OK;
}
Status visitT(TElemType e)
{
#ifdef CHAR
	printf("%c ", e);
#endif
#ifdef INT
	printf("%d ", e);
#endif
	return OK;
}
void main()
{
	BiTree T;
	InitBiTree(&T);
#ifdef CHAR
	printf("请先序输入二叉树(如:ab三个空格表示a为根结点,b为左子树的二叉树)\n");
#endif
#ifdef INT
	printf("请先序输入二叉树(如:1 2 0 0 0表示1为根结点,2为左子树的二叉树)\n");
#endif
	CreateBiTree(&T);
	printf("中序非递归遍历二叉树:\n");
	InorderTraversel(T, visitT);
	system("pause");
}
