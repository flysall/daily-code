#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
typedef int Status;		//Status�Ǻ������ͣ���ֵ�Ǻ��������״̬���룬��OK
typedef int ElemType;
//���Ա�ĵ�����洢�ṹ
struct LNode
{
	ElemType data;
	struct LNode *next;
};
typedef struct LNode *LinkList;
//����һ���յ����Ա�L
Status InitList_CL(LinkList *L)
{
	*L = (LinkList)malloc(sizeof(struct LNode));		//����ͷ��㣬ʹLָ���ͷ���		
	if (!*L)		//�洢����ʧ��
		exit(OVERFLOW);
	(*L)->next = *L;	//ָ����ָ��ͷ���
	return OK;
}
//�ж����Ա�L�Ƿ�Ϊ��
Status ListEmpty_CL(LinkList L)
{
	if (L->next == L)
		return TRUE;
	else
		return FALSE;
}
//�������Ա�L������Ԫ�ظ���
int ListLength_CL(LinkList L)
{
	int i = 0;
	LinkList p = L->next;
	while (p->next != L)
	{
		i++;
		p = p->next;
	}
	return i;
}
//��õ�i��Ԫ�ص�ֵ
Status GetElem_CL(LinkList L, int i, ElemType *e)
{
	int j = 1;
	LinkList p = L->next->next;
	if (i <= 0 || ListLength_CL(L))
		return ERROR;
	while (j < i)
	{
		p = p->next;
		j++;
	}
	*e = p->data;
	return OK;
}
//��L�ĵ�i��λ��֮ǰ����Ԫ��e
Status ListInsert_CL(LinkList *L, int i, ElemType e)
{
	LinkList p = (*L)->next, s;
	int j = 0;
	if (i <= 0 || i > ListLength_CL(*L) + 1)
		return ERROR;
	while (j < i - 1)
	{
		p = p->next;
		j++;
	}
	s = (LinkList)malloc(sizeof(struct LNode));
	s->data = e;
	s->next = p->next;
	p->next = s;
	if (p == *L)
		*L = s;
	return OK;
}
//��������
Status ListTraverse_CL(LinkList L, void(*vi)(ElemType))
{
	LinkList p = L->next->next;
	while (p != L->next)
	{
		vi(p->data);
		p = p->next;
	}
	printf("\n");
	return OK;
}
void visit(ElemType c)
{
	printf("%d", c);
}
void main()
{
	LinkList L;
	ElemType e;
	int j;
	Status i;
	i = InitList_CL(&L);
	printf("��ʼ����ѭ������̣�i = %d(1:��ʼ���ɹ���\n", i);
	i = ListEmpty_CL(L);
	printf("L�Ƿ�� i = %d(1:�� 0:��)\n", i);
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	i = GetElem_CL(L, 1, &e);
	j = ListLength_CL(L);
	printf("L������Ԫ�ظ��� = %d, ��һ��Ԫ�ص�ֵΪ%d��\n", j,e);
	printf("L�е�����Ԫ������Ϊ:");
	ListTraverse_CL(L, visit);
	system("pause");
}