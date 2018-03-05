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
typedef struct LNode * LinkList;
//����һ���յ����Ա�
Status InitList_CL(LinkList * L)
{
	*L = (LinkList)malloc(sizeof(struct LNode));
	if (!*L)
		exit(OVERFLOW);
	(*L)->next = *L;
	return OK;
}
//�������Ա�L
Status DestroyList_CL(LinkList * L)
{
	LinkList q, p = (*L)->next;
	while (p != *L)
	{
		q = p->next;
		free(p);
		p = q;
	}
	free(*L);
	(*L) = NULL;
	return OK;
}
//��L��Ϊ�ձ�
Status ClearList_CL(LinkList *L)
{
	LinkList p, q;
	(*L) = (*L)->next;
	p = (*L)->next;
	while (p != *L)
	{
		q = p->next;
		free(p);
		p = q;
	}
	(*L)->next = *L;
	return OK;
}
//�ж����Ա��Ƿ�Ϊ��
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
//��L�ĵ�i��λ��֮ǰ����Ԫ��e
Status ListInsert_CL(LinkList * L, int i, ElemType e)
{
	LinkList p = (*L)->next, s;
	int j = 0;
	if (i <= 0 || i > ListLength_CL(*L) + 1)
		return ERROR;
	while (j < i - 1)
	{
		j++;
		p = p->next;
	}
	s = (LinkList)malloc(sizeof(struct LNode));
	s->data = e;
	s->next = p->next;
	p->next = s;
	if (p == *L)
		*L = s;
	return OK;
}
Status compare(ElemType c1, ElemType c2)
{
	if (c1 == c2)
		return OK;
	else
		return FALSE;
}
void visit(ElemType c)
{
	printf("%d\n", c);
}
void main()
{
	LinkList L;
	Status i;
	i = InitList_CL(&L);
	printf("�����ڵ�ѭ�������в���3��5\n");
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	printf("���L�� %d(1���ɹ�)\n", ClearList_CL(&L));
	printf("��պ�L�Ƿ�գ�%d (1���� 0����)\n", ListEmpty_CL(L));
	printf("����L�� %d(1:�ɹ�)\n", DestroyList_CL(&L));
	system("pause");
}