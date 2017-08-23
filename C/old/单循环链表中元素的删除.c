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
//构造空的线性表
Status InitList_CL(LinkList * L)
{
	*L = (struct LNode*)malloc(sizeof(struct LNode));
	if (!*L)
		exit(OVERFLOW);
	(*L)->next = *L;
	return OK;
}
// 返回L中数据元素个数
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
//返回L中第1个与e满足compare()的数据元素的位序
int LocateElem_CL(LinkList  L, ElemType e, Status(*compare)(ElemType,ElemType))
{
	int i = 0;
	LinkList p = L->next->next;		//p指向第一个节点
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
	LinkList p = (*L)->next, s;		//p指向头结点 
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
//删除L的第i个元素，并有e返回其值
Status ListDelete_CL(LinkList * L, int i, ElemType * e)
{
	LinkList p = (*L)->next, q;		//p指向头结点
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
//遍历
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
//比较
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
	printf("依次在单循环链表中插入3,5\n");
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	ListInsert_CL(&L, 3, 6);
	j = LocateElem_CL(L, 5, compare);
	if (j)
		printf("L的第%d个元素为5。\n", j);
	else
		printf("不存在值为5的元素\n");
	i = ListDelete_CL(&L, 2, &e);
	printf("删除的第2个元素为：\n");
	if (i)
	{
		printf("删除的元素值为%d, 现在L中的数据元素依次为：", e);
		ListTraverse_CL(L, visit);
	}
	else
		printf("删除不成功！\n");
	system("pause");
}