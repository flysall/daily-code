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
//构造一个空的线性表
Status InitList_CL(LinkList * L)
{
	*L = (LinkList)malloc(sizeof(struct LNode));
	if (!*L)
		exit(OVERFLOW);
	(*L)->next = *L;
	return OK;
}
//销毁线性表L
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
//将L置为空表
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
//判断线性表是否为空
Status ListEmpty_CL(LinkList L)
{
	if (L->next == L)
		return TRUE;
	else
		return FALSE;
}
//返回L中元素个数
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
//在L的第i个位置之前插入元素e
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
	printf("依次在单循环链表中插入3和5\n");
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	printf("清空L： %d(1：成功)\n", ClearList_CL(&L));
	printf("清空后L是否空：%d (1：空 0：否)\n", ListEmpty_CL(L));
	printf("销毁L： %d(1:成功)\n", DestroyList_CL(&L));
	system("pause");
}