#define INT
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
typedef int Status;		//Status是函数的类型,其值是函数结果状态代码，如OK等
#ifdef CHAR
typedef char TElemType;
TElemType Nil = ' ';	//字符型以空格符为空
#endif
#ifdef INT
typedef int TElemType;
TElemType Nil = 0;		// 整型以0为空
#endif
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild;	/* 左右孩子指针 */
}BiTNode, *BiTree;
typedef BiTree  QElemType;		 /* 设队列元素为二叉树的指针类型 */
typedef struct QNode
{
	QElemType data;
	struct QNode * next;
}QNode, *QueuePtr;
//
typedef struct
{
	QueuePtr front, rear;		/* 队头、队尾指针 */
}LinkQueue;
Status InitBiTree(BiTree *T);
void CreateBiTree(BiTree *T);
TElemType Value(BiTree p);
void Assign(BiTree p, TElemType value);
BiTree Point(BiTree T, TElemType s);
Status InitQueue(LinkQueue * Q);
Status QueueEmpty(LinkQueue Q);
Status DeQueue(LinkQueue *Q, QElemType *e);
Status EnQueue(LinkQueue *Q, QElemType e);
void LevelOrderTraverse(BiTree T, Status(*Visit)(TElemtype));
Status visitT(TElemType e);
int main(void)
{
	BiTree T, p;
	TElemType e1, e2;
	InitBiTree(&T);
#ifdef CHAR
	printf("请先序输入二叉树(如:ab三个空格表示a为根结点,b为左子树的二叉树)\n");
#endif
#ifdef INT
	printf("请先序输入二叉树(如:1 2 0 0 0表示1为根结点,2为左子树的二叉树)\n");
#endif
	CreateBiTree(&T);;
	printf("请输入一个结点的值: ");
#ifdef CHAR
	scanf("%*c%c", &e1);
#endif
#ifdef INT
	scanf("%d", &e1);
#endif
	p = Point(T, e1);;
#ifdef CHAR
	printf("结点的值为%c\n", Value(p));
#endif
#ifdef INT
	printf("结点的值为%d\n", Value(p));
#endif
	printf("欲改变此结点的值，请输入新值: ");
#ifdef CHAR
	scanf("%*c%c%*c", &e2);
#endif
#ifdef INT
	scanf("%d", &e2);
#endif
	Assign(p, e2);
	printf("层次遍历二叉树:\n");
	LevelOrderTraverse(T, visitT);
	system("pause");
}
//操作结果: 构造空二叉树T
Status InitBiTree(BiTree *T)
{
	*T = NULL;
	return OK;
}
//操作结果: 构造二叉树T
void CreateBiTree(BiTree *T)
{
	TElemType ch;
#ifdef CHAR
	scanf("%c", &ch);
#endif
#ifdef INT
	scanf("%d", &ch);
#endif
	if (ch == Nil)
		*T = NULL;
	else
	{
		*T = (BiTree)malloc(sizeof(BiTNode));
		if (!*T)
			exit(ERROR);
		(*T)->data = ch;
		CreateBiTree(&(*T)->lchild);
		CreateBiTree(&(*T)->rchild);
	}
}
//操作结果: 返回p所指结点的值
TElemType Value(BiTree p)
{
	return p->data;
}
//给p所指结点赋值为value
void Assign(BiTree p, TElemType value)
{
	p->data = value;
}
//返回二叉树T中指向元素值为s的结点的指针。
BiTree Point(BiTree T, TElemType s)
{
	LinkQueue q;
	QElemType a;
	if (T)
	{
		InitQueue(&q);
		EnQueue(&q, T);
		while (!QueueEmpty(q))
		{
			DeQueue(&q, &a);
			if (a->data == s)
				return a;
			if (a->lchild)
				EnQueue(&q, a->lchild);
			if (a->rchild)
				EnQueue(&q, a->rchild);
		}
	}
	return NULL;
}
//构造一个空队列Q
Status InitQueue(LinkQueue * Q)
{
	(*Q).front = (*Q).rear = (QueuePtr)malloc(sizeof(QNode));
	if (!(*Q).front)
		exit(OVERFLOW);
	(*Q).front->next = NULL;
	return OK;
}
//若Q为空队列,则返回TRUE,否则返回FALSE
Status QueueEmpty(LinkQueue Q)
{
	if (Q.front == Q.rear)
		return TRUE;
	else
		return FALSE;
}
/* 插入元素e为Q的新的队尾元素 */
Status EnQueue(LinkQueue *Q, QElemType e)
{ 
	QueuePtr p = (QueuePtr)malloc(sizeof(QNode));
	if (!p)		/* 存储分配失败 */
		exit(OVERFLOW);
	p->data = e;
	p->next = NULL;
	(*Q).rear->next = p;
	(*Q).rear = p;
	return OK;
}
/* 若队列不空,删除Q的队头元素,用e返回其值,并返回OK,否则返回ERROR */
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
//操作结果：层序递归遍历T(利用队列),对每个结点调用函数Visit一次且仅一次
void LevelOrderTraverse(BiTree T, Status(*Visit)(TElemtype))
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
			if (a->lchild != NULL)
				EnQueue(&q, a->lchild);
			if (a->rchild != NULL)
				EnQueue(&q, a->rchild);
		}
		printf("\n");
	}
}

Status visitT(TElemType e)
{
#ifdef	CHAR
	printf("%4c", e);
#endif
#ifdef INT
	printf("%4d", e);
#endif
	return OK;
}