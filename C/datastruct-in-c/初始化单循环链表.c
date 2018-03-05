#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
typedef int Status;		//Status是函数类型，其值是函数结果的状态代码，如OK
typedef int ElemType;
//线性表的单链表存储结构
struct LNode
{
	ElemType data;
	struct LNode *next;
};
typedef struct LNode *LinkList;
//构造一个空的线性表L
Status InitList_CL(LinkList *L)
{
	*L = (LinkList)malloc(sizeof(struct LNode));		//产生头结点，使L指向此头结点		
	if (!*L)		//存储分配失败
		exit(OVERFLOW);
	(*L)->next = *L;	//指针域指向头结点
	return OK;
}
//判断线性表L是否为空
Status ListEmpty_CL(LinkList L)
{
	if (L->next == L)
		return TRUE;
	else
		return FALSE;
}
//计算线性表L中数据元素个数
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
//获得第i个元素的值
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
//在L的第i个位置之前插入元素e
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
//遍历操作
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
	printf("初始化单循环链表Ｌ，i = %d(1:初始化成功）\n", i);
	i = ListEmpty_CL(L);
	printf("L是否空 i = %d(1:空 0:否)\n", i);
	ListInsert_CL(&L, 1, 3);
	ListInsert_CL(&L, 2, 5);
	i = GetElem_CL(L, 1, &e);
	j = ListLength_CL(L);
	printf("L中数据元素个数 = %d, 第一个元素的值为%d。\n", j,e);
	printf("L中的数据元素依次为:");
	ListTraverse_CL(L, visit);
	system("pause");
}