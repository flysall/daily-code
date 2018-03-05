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
//构造一个空的线性表L
Status InitList_CL(LinkList *L)
{
	*L = (LinkList)malloc(sizeof(struct LNode));
	if (!*L)
		exit(OVERFLOW);
	(*L)->next = *L;
	return OK;
}
//检查线性表是否为空
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
//将第i个元素的值赋给e
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
//在L第i个位置插入元素e
Status ListInsert_CL(LinkList *L, int i, ElemType e)
{
	LinkList p = (*L)->next, s;
	int j = 0;
	if (i <= 0 || i > ListLength_CL(*L) + 1)
		return ERROR;
	while (j < i - 1)	//寻找第i-1个节点
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
//返回前驱
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
//后继
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
	printf("初始化单循环链表L i=%d (1:初始化成功)\n", i);
	i = ListEmpty_CL(L);
	printf("L是否为空 i=%d (1:空 0:否)\n", i);
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	printf("依次插入元素3和5\n");
	PriorElem_CL(L, 5, &e);
	printf("5前面的元素值为%d。\n", e);
	NextElem_CL(L, 3, &e);
	printf("3后面的元素值为%d。\n", e);
	system("pause");
}
