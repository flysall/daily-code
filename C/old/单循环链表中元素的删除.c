#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR
typedef int Status;
typedef int Boolean;
typedef int ElemType;
struct LNode
{
	ElemType data;
	struct LNode *next;
};
typedef struct LNode * LinkList;
//����յ����Ա�
Status InitList_CL(LinkList * L)
{
	*L = (struct LNode*)malloc(sizeof(struct LNode));
	if (!*L)
		exit(OVERFLOW);
	(*L)->next = *L;
	return OK;
}
// ����L������Ԫ�ظ���
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
//����L�е�1����e����compare()������Ԫ�ص�λ��
int LocateElem_CL(LinkList  L, ElemType e, Status(*compare)(ElemType,ElemType))
{
	int i = 0;
	LinkList p = L->next->next;		//pָ���һ���ڵ�
	while (p != L->next)
	{
		i++;
		if (compare(p->data, e))
			return i;
		p = p->next;
	}
	return 0;
}
Status ListInsert_CL(LinkList * L, int i, ElemType e)
{
	LinkList p = (*L)->next, s;		//pָ��ͷ��� 
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
//ɾ��L�ĵ�i��Ԫ�أ�����e������ֵ
Status ListDelete_CL(LinkList * L, int i, ElemType * e)
{
	LinkList p = (*L)->next, q;		//pָ��ͷ���
	int j = 0;
	if (i <= 0 || i > ListLength_CL(*L))
		return ERROR;
	while (j < i - 1)
	{
		p = p->next;
		j++;
	}
	q = p->next;
	p->next = q->next;
	*e = q->data;
	if (*L == q)
		*L = p;
	free(q);
	return OK;
}
//����
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
//�Ƚ�
Status compare(ElemType c1, ElemType c2)
{
	if (c1 == c2)
		return TRUE;
	else
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
	int j;
	Status i;
	i = InitList_CL(&L);
	printf("�����ڵ�ѭ�������в���3,5\n");
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	ListInsert_CL(&L, 3, 6);
	j = LocateElem_CL(L, 5, compare);
	if (j)
		printf("L�ĵ�%d��Ԫ��Ϊ5��\n", j);
	else
		printf("������ֵΪ5��Ԫ��\n");
	i = ListDelete_CL(&L, 2, &e);
	printf("ɾ���ĵ�2��Ԫ��Ϊ��\n");
	if (i)
	{
		printf("ɾ����Ԫ��ֵΪ%d, ����L�е�����Ԫ������Ϊ��", e);
		ListTraverse_CL(L, visit);
	}
	else
		printf("ɾ�����ɹ���\n");
	system("pause");
}