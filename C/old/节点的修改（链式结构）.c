#define INT
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
typedef int Status;		//Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK��
#ifdef CHAR
typedef char TElemType;
TElemType Nil = ' ';	//�ַ����Կո��Ϊ��
#endif
#ifdef INT
typedef int TElemType;
TElemType Nil = 0;		// ������0Ϊ��
#endif
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild;	/* ���Һ���ָ�� */
}BiTNode, *BiTree;
typedef BiTree  QElemType;		 /* �����Ԫ��Ϊ��������ָ������ */
typedef struct QNode
{
	QElemType data;
	struct QNode * next;
}QNode, *QueuePtr;
//
typedef struct
{
	QueuePtr front, rear;		/* ��ͷ����βָ�� */
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
	printf("���������������(��:ab�����ո��ʾaΪ�����,bΪ�������Ķ�����)\n");
#endif
#ifdef INT
	printf("���������������(��:1 2 0 0 0��ʾ1Ϊ�����,2Ϊ�������Ķ�����)\n");
#endif
	CreateBiTree(&T);;
	printf("������һ������ֵ: ");
#ifdef CHAR
	scanf("%*c%c", &e1);
#endif
#ifdef INT
	scanf("%d", &e1);
#endif
	p = Point(T, e1);;
#ifdef CHAR
	printf("����ֵΪ%c\n", Value(p));
#endif
#ifdef INT
	printf("����ֵΪ%d\n", Value(p));
#endif
	printf("���ı�˽���ֵ����������ֵ: ");
#ifdef CHAR
	scanf("%*c%c%*c", &e2);
#endif
#ifdef INT
	scanf("%d", &e2);
#endif
	Assign(p, e2);
	printf("��α���������:\n");
	LevelOrderTraverse(T, visitT);
	system("pause");
}
//�������: ����ն�����T
Status InitBiTree(BiTree *T)
{
	*T = NULL;
	return OK;
}
//�������: ���������T
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
//�������: ����p��ָ����ֵ
TElemType Value(BiTree p)
{
	return p->data;
}
//��p��ָ��㸳ֵΪvalue
void Assign(BiTree p, TElemType value)
{
	p->data = value;
}
//���ض�����T��ָ��Ԫ��ֵΪs�Ľ���ָ�롣
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
//����һ���ն���Q
Status InitQueue(LinkQueue * Q)
{
	(*Q).front = (*Q).rear = (QueuePtr)malloc(sizeof(QNode));
	if (!(*Q).front)
		exit(OVERFLOW);
	(*Q).front->next = NULL;
	return OK;
}
//��QΪ�ն���,�򷵻�TRUE,���򷵻�FALSE
Status QueueEmpty(LinkQueue Q)
{
	if (Q.front == Q.rear)
		return TRUE;
	else
		return FALSE;
}
/* ����Ԫ��eΪQ���µĶ�βԪ�� */
Status EnQueue(LinkQueue *Q, QElemType e)
{ 
	QueuePtr p = (QueuePtr)malloc(sizeof(QNode));
	if (!p)		/* �洢����ʧ�� */
		exit(OVERFLOW);
	p->data = e;
	p->next = NULL;
	(*Q).rear->next = p;
	(*Q).rear = p;
	return OK;
}
/* �����в���,ɾ��Q�Ķ�ͷԪ��,��e������ֵ,������OK,���򷵻�ERROR */
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
//�������������ݹ����T(���ö���),��ÿ�������ú���Visitһ���ҽ�һ��
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