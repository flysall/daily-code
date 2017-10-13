#define CHAR /* �ַ��� */
#include <stdio.h> /* EOF(=^Z��F6),NULL */
#include <stdlib.h>
#include <math.h> /* floor(),ceil(),abs() */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define STACK_INIT_SIZE 10 /* �洢�ռ��ʼ������ */
#define STACKINCREMENT 2 /* �洢�ռ�������� */
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
typedef BiTree SElemType; /* ��ջԪ��Ϊ��������ָ������ */
typedef struct SqStack
{
	SElemType data;
	struct SqStack * next;
}SqStack;		//
typedef struct SqStack * link;
link Stack = NULL;
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
//
Status StackEmpty(SqStack S)
{
	if (Stack == NULL)
		return TRUE;
	else
		return FALSE;
}
//��ջ
Status Push(SqStack *S, SElemType e)
{
	link newnode;
	newnode = (SqStack*)malloc(sizeof(SqStack));
	newnode->data = e;
	newnode->next = Stack;
	Stack = newnode;
	return OK;
}
//����ջ��Ԫ��
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
//�������
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
	printf("���������������(��:ab�����ո��ʾaΪ�����,bΪ�������Ķ�����)\n");
#endif
#ifdef INT
	printf("���������������(��:1 2 0 0 0��ʾ1Ϊ�����,2Ϊ�������Ķ�����)\n");
#endif
	CreateBiTree(&T);
	printf("����ǵݹ����������:\n");
	InorderTraversel(T, visitT);
	system("pause");
}
