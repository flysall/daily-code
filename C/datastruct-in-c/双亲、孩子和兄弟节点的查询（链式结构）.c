#define CHAR /* �ַ��� */
#include<stdio.h> /* EOF(=^Z��F6),NULL */
#include <stdlib.h>
#include<math.h> /* floor(),ceil(),abs() */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
typedef int Status; /* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */
#ifdef CHAR
typedef char TElemType;
TElemType Nil = ' '; /* �ַ����Կո��Ϊ�� */
#endif
#ifdef INT
typedef int TElemType;
TElemType Nil = 0; /* ������0Ϊ�� */
#endif
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild; /* ���Һ���ָ�� */
}BiTNode, *BiTree;
typedef BiTree QElemType; /* �����Ԫ��Ϊ��������ָ������ */
typedef struct QNode
{
	QElemType data;
	struct QNode *next;
}QNode, *QueuePtr;
typedef struct
{
	QueuePtr front, rear; /* ��ͷ����βָ�� */
}LinkQueue;
Status InitBiTree(BiTree *T)
{ /* �������: ����ն�����T */
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
	if (ch == Nil) /* �� */
		*T = NULL;
	else
	{
		*T = (BiTree)malloc(sizeof(BiTNode));
		if (!*T)
			exit(OVERFLOW);
		(*T)->data = ch; /* ���ɸ���� */
		CreateBiTree(&(*T)->lchild); /* ���������� */
		CreateBiTree(&(*T)->rchild); /* ���������� */
	}
}
Status InitQueue(LinkQueue *Q)
{ /* ����һ���ն���Q */
	(*Q).front = (*Q).rear = (QueuePtr)malloc(sizeof(QNode));
	if (!(*Q).front)
		exit(OVERFLOW);
	(*Q).front->next = NULL;
	return OK;
}
Status EnQueue(LinkQueue *Q, QElemType e)
{ /* ����Ԫ��eΪQ���µĶ�βԪ�� */
	QueuePtr p = (QueuePtr)malloc(sizeof(QNode));
	if (!p) /* �洢����ʧ�� */
		exit(OVERFLOW);
	p->data = e;
	p->next = NULL;
	(*Q).rear->next = p;
	(*Q).rear = p;
	return OK;
}
Status QueueEmpty(LinkQueue Q)
{ /* ��QΪ�ն���,�򷵻�TRUE,���򷵻�FALSE */
	if (Q.front == Q.rear)
		return TRUE;
	else
		return FALSE;
}
Status DeQueue(LinkQueue *Q, QElemType *e)
{ /* �����в���,ɾ��Q�Ķ�ͷԪ��,��e������ֵ,������OK,���򷵻�ERROR */
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
BiTree Point(BiTree T, TElemType s)
{ /* ���ض�����T��ָ��Ԫ��ֵΪs�Ľ���ָ�롣��� */
	LinkQueue q;
	QElemType a;
	if (T) /* �ǿ��� */
	{
		InitQueue(&q); /* ��ʼ������ */
		EnQueue(&q, T); /* �������� */
		while (!QueueEmpty(q)) /* �Ӳ��� */
		{
			DeQueue(&q, &a); /* ����,����Ԫ�ظ���a */
			if (a->data == s)
				return a;
			if (a->lchild) /* ������ */
				EnQueue(&q, a->lchild); /* ������� */
			if (a->rchild) /* ���Һ��� */
				EnQueue(&q, a->rchild); /* ����Һ��� */
		}
	}
	return NULL;
}
/* �������: ��e��T�ķǸ����,�򷵻�����˫��,���򷵻أ��գ� */
TElemType Parent(BiTree T, TElemType e)
{
	LinkQueue q;
	QElemType a;
	if (T) {
		InitQueue(&q);
		EnQueue(&q, T);
		while (!QueueEmpty(q)) {
			DeQueue(&q, &a);
			if (a->lchild && a->lchild->data == e || a->rchild && a->rchild->data == e)
				return a->data;
			else {
				if (a->lchild)
					EnQueue(&q, a->lchild);
				if (a->rchild)
					EnQueue(&q, a->rchild);
				}
			}
	}
	else
		return Nil;
}
//�������: ����e�����ӡ���e������,�򷵻أ��գ� 
TElemType LeftChild(BiTree T, TElemType e)
{
	BiTree a;
	if (T)
	{
		a = Point(T, e);
		if (a && a->lchild)
			return a->lchild->data;
	}
	return Nil;
}
//�������: ����e���Һ��ӡ���e���Һ���,�򷵻أ��գ�
TElemType RightChild(BiTree T, TElemType e)
{
	BiTree a;
	if (T)
	{
		a = Point(T, e);
		if (a && a->rchild)
			return a->rchild->data;
	}
	return Nil;
}
//�������: ����e�����ֵܡ���e��T�����ӻ������ֵ�, �򷵻أ��գ�
TElemType LeftSibling(BiTree T, TElemType e)
{
	BiTree p;
	TElemType a;
	if (T) {
		a = Parent(T, e);
		p = Point(T, a);
		if (p->lchild && p->rchild && p->rchild->data == e)
			return p->lchild->data;
	}
	return Nil;
}
//�������: ����e�����ֵܡ���e��T���Һ��ӻ������ֵ�,�򷵻أ��գ�
TElemType RightSibling(BiTree T, TElemType e)
{
	TElemType a;
	BiTree p;
	if (T) {
		a = Parent(T, e);
		p = Point(T, a);
		if (p->rchild && p->lchild && p->lchild->data == e)
			return p->rchild->data;
	}
	return Nil;
}
int main(void)
{
	BiTree T;
	TElemType e1, e2;
	InitBiTree(&T);
#ifdef CHAR
	printf("���������������(��:ab�����ո��ʾaΪ�����,bΪ�������Ķ�����)\n"); 
#endif
#ifdef INT
	printf("���������������(��:1 2 0 0 0��ʾ1Ϊ�����,2Ϊ�������Ķ�����)\n");
#endif
	CreateBiTree(&T);
	printf("������Ҫ��ѯ����ֵ��");
#ifdef CHAR
	scanf("%*c%c%*c", &e2);
#endif
#ifdef	INT
	scanf("%d", &e2);
#endif
	e1 = Parent(T, e2);
	if(e1 != Nil)
#ifdef CHAR
		printf("%c��˫����%c\n", e2, e1);
#endif
#ifdef INT
	printf("%d��˫����%d\n", e2, e1);
#endif
	else
#ifdef CHAR
	printf("%cû��˫��\n", e2);
#endif
#ifdef INT
	printf("%dû��˫��\n", e2);
#endif
	e1 = LeftChild(T, e2);
	if (e1 != Nil)
#ifdef CHAR
		printf("%c��������%c\n", e2, e1);
#endif
#ifdef INT
	printf("%d��������%d\n", e2, e1);
#endif
	else
#ifdef CHAR
		printf("%cû������\n", e2);
#endif
#ifdef INT
	printf("%dû������\n", e2);
#endif
	e1 = RightChild(T, e2);
	if (e1 != Nil)
#ifdef CHAR
		printf("%c���Һ�����%c\n", e2, e1);
#endif
#ifdef INT
	printf("%d���Һ�����%d\n", e2, e1);
#endif
	else
#ifdef CHAR
		printf("%cû���Һ���\n", e2);
#endif
#ifdef INT
	printf("%dû���Һ���\n", e2);
#endif
	e1 = LeftSibling(T, e2);
	if (e1 != Nil)
#ifdef CHAR
		printf("%c�����ֵ���%c\n", e2, e1);
#endif
#ifdef INT
	printf("%d�����ֵ���%d\n", e2, e1);
#endif
	else
#ifdef CHAR
		printf("%cû�����ֵ�\n", e2);
#endif
#ifdef INT
	printf("%dû�����ֵ�\n", e2);
#endif
	e1 = RightSibling(T, e2);
	if (e1 != Nil)
#ifdef CHAR
		printf("%c�����ֵ���%c\n", e2, e1);
#endif
#ifdef INT
	printf("%d�����ֵ���%d\n", e2, e1);
#endif
	else
#ifdef CHAR
		printf("%cû�����ֵ�\n", e2);
#endif
#ifdef INT
	printf("%dû�����ֵ�\n", e2);
#endif
	system("pause");
}