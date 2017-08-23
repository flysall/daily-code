#define CHAR /* 字符型 */
#include<stdio.h> /* EOF(=^Z或F6),NULL */
#include <stdlib.h>
#include<math.h> /* floor(),ceil(),abs() */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
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
typedef BiTree QElemType; /* 设队列元素为二叉树的指针类型 */
typedef struct QNode
{
	QElemType data;
	struct QNode *next;
}QNode, *QueuePtr;

typedef struct
{
	QueuePtr front, rear; /* 队头、队尾指针 */
}LinkQueue;
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
//将队列置空
Status InitQueue(LinkQueue *Q)
{
	(*Q).front = (*Q).rear = (QueuePtr)malloc(sizeof(QNode));
	if (!(*Q).front)
		exit(OVERFLOW);
	(*Q).front->next = NULL;
	return OK;
}
//
Status QueueEmpty(LinkQueue Q)
{
	if (Q.front == Q.rear)
		return TRUE;
	else
		return FALSE;
}
//进队
Status EnQueue(LinkQueue *Q, QElemType e)
{
	QueuePtr p;
	p = (QueuePtr)malloc(sizeof(QNode));
	p->data = e;
	p->next = NULL;
	(*Q).rear->next = p;
	(*Q).rear = p;
	return OK;
}
//出队列
Status DeQueue(LinkQueue *Q, QElemType *e)
{
	QueuePtr p;
	if ((*Q).front == (*Q).rear)
		return ERROR;
	p = (*Q).front->next;
	*e = p->data;
	(*Q).front->next = p->next;
	if ((*Q).rear == p)
		(*Q).rear = (*Q).front;
	free(p);
	return OK;
}
//
void LevelOrderTraverse(BiTree T, static(*Visit)(TElemType))
{
	LinkQueue q;
	QElemType a;
	if (T)
	{
		InitQueue(&q);
		EnQueue(&q, T);
		while (!QueueEmpty(q)) {
			DeQueue(&q, &a);
			Visit(a->data);
			if (a->lchild)
				EnQueue(&q, a->lchild);
			if (a->rchild)
				EnQueue(&q, a->rchild);
		}
		printf("\n");
	}
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
int main(void)
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
	printf("层次遍历二叉树:\n");
	LevelOrderTraverse(T, visitT);
	system("pause");
}