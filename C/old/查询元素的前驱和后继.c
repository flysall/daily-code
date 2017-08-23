#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
typedef int Status;
typedef int ElemType;
struct LNode
{
	ElemType data;
	struct LNode *next;
};
typedef struct LNode *LinkList;
//����һ���յ����Ա�L
Status InitList_CL(LinkList *L)
{
	*L = (LinkList)malloc(sizeof(struct LNode));
	if (!*L)
		exit(OVERFLOW);
	(*L)->next = *L;
	return OK;
}
//������Ա��Ƿ�Ϊ��
Status ListEmpty_CL(LinkList L)
{
	if (L->next == L)
		return TRUE;
	else
		return FALSE;
}
//����L��Ԫ�ظ���
int ListLength_CL(LinkList L)
{
	int i = 0;
	LinkList p = L->next;
	while (p != L)
	{
		i++;
		p = p->next;
	}
	return i;
}
//����i��Ԫ�ص�ֵ����e
Status GetElem_CL(LinkList L, int i, ElemType *e)
{
	int j = 1;
	LinkList p = L->next->next;
	if (i = 0 || i > ListLength_CL(L))
		return ERROR;
	while (j < i)
	{
		p = p->next;
		j++;
	}
	*e = p->data;
	return OK;
}
//��L��i��λ�ò���Ԫ��e
Status ListInsert_CL(LinkList *L, int i, ElemType e)
{
	LinkList p = (*L)->next, s;
	int j = 0;
	if (i <= 0 || i > ListLength_CL(*L) + 1)
		return ERROR;
	while (j < i - 1)	//Ѱ�ҵ�i-1���ڵ�
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
//����ǰ��
Status PriorElem_CL(LinkList L, ElemType cur_e, ElemType *pre_e)
{
	LinkList q, p = L->next->next;
	q = p->next;
	while (q != L->next)
	{
		if (q->data == cur_e)
		{
			*pre_e = p->data;
			return TRUE;
		}
		p = q;
		q = q->next;
	}
	return FALSE;
}
//���
Status NextElem_CL(LinkList L, ElemType cur_e, ElemType *next_e)
{
	LinkList p = L->next->next;
	while (p != L)

	{
		if (p->data = cur_e)
		{
			*next_e = p->next->data;
			return TRUE;
		}
		p = p->next;
	}
	return FALSE;
}
void visit(ElemType c)
{
	printf("%d", c);
}
void main()
{
	LinkList L;
	ElemType e;
	Status i;
	i = InitList_CL(&L);
	printf("��ʼ����ѭ������L i=%d (1:��ʼ���ɹ�)\n", i);
	i = ListEmpty_CL(L);
	printf("L�Ƿ�Ϊ�� i=%d (1:�� 0:��)\n", i);
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	printf("���β���Ԫ��3��5\n");
	PriorElem_CL(L, 5, &e);
	printf("5ǰ���Ԫ��ֵΪ%d��\n", e);
	NextElem_CL(L, 3, &e);
	printf("3�����Ԫ��ֵΪ%d��\n", e);
	system("pause");
}
