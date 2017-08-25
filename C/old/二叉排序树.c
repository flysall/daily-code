#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define OK 1
typedef int Status;		/* Status是函数的类型,其值是函数结果状态代码，如OK等 */
typedef int Boolean;	
#define N 10
typedef int KeyType;
typedef struct
{
	KeyType key;
	int others;
}ElemType;
typedef ElemType TElemType;
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;
#define EQ(a,b) ((a) == (b))
#define LT(a,b) ((a)<(b))
//
Status InitDSTable(BiTree *DT)
{
	*DT = NULL;
	return OK;
}
//
void DestroyDSTable(BiTree *DT)
{
	if (*DT)
	{
		if ((*DT)->lchild)
			DestroyDSTable(&(*DT)->lchild);
		if ((*DT)->rchild)
			DestroyDSTable(&(*DT)->rchild);
	}
	free(*DT);
	*DT = NULL;
}
/* 在根指针T所指二叉排序树中递归地查找某关键字等于key的数据元素， */
/* 若查找成功，则返回指向该数据元素结点的指针,否则返回空指针。*/
BiTree SearchBST(BiTree T, KeyType key)
{
	if ((!T) || EQ(key, T->data.key))
		return T;
	else if LT(key, T->data.key)
		return SearchBST(T->lchild, key);
	else
		return SearchBST(T->rchild, key);
}
/* 在根指针T所指二叉排序树中递归地查找其关键字等于key的数据元素，若查找 */
/* 成功，则指针p指向该数据元素结点，并返回TRUE，否则指针p指向查找路径上 */
void SearchBST1(BiTree * T, KeyType key, BiTree f, BiTree * p, Status *flag)
{
	if (!*T)
	{
		*p = f;
		*flag = FALSE;
	}
	else if EQ(key, (*T)->data.key)
	{
		*p = *T;
		*flag = TRUE;
	}
	else if LT(key, (*T)->data.key)
		SearchBST1(&(*T)->lchild, key, *T, p, flag);
	else
		SearchBST1(&(*T)->rchild, key, *T, p, flag);
}
/* 当二叉排序树T中不存在关键字等于e.key的数据元素时，插入e并返回TRUE， */
/* 否则返回FALSE。*/
Status InsertBST(BiTree * T, ElemType e)
{
	BiTree p, s;
	Status flag;
	SearchBST1(T, e.key, NULL, &p, &flag);
	if (!flag)
	{
		s = (BiTree)malloc(sizeof(BiTNode));
		s->data = e;
		s->lchild = s->rchild = NULL;
		if (!p)
			*T = s;
		else if LT(e.key, p->data.key)
			p->lchild = s;
		else
			p->rchild = s;
		return TRUE;
	}
	else
		return FALSE;
}
/* 从二叉排序树中删除结点p，并重接它的左或右子树。*/
void Delete(BiTree * p)
{
	BiTree q, s;
	if (!(*p)->rchild)
	{
		q = *p;
		*p = (*p)->lchild;
		free(q);
	}
	else if (!(*p)->lchild)
	{
		q = *p;
		*p = (*p)->rchild;
		free(q);
	}
	else
	{
		q = *p;
		s = (*p)->lchild;
		while (s->rchild)
		{
			q = s;
			s = s->rchild;
		}
		(*p)->data = s->data;	//
		if (q != *p)
			q->rchild = s->rchild;
		else
			q->lchild = s->lchild;
		free(s);
	}
}
/* 若二叉排序树T中存在关键字等于key的数据元素时，则删除该数据元素结点， */
/* 并返回TRUE；否则返回FALSE。*/
Status DeleteBST(BiTree * T, KeyType key)
{
	if (!*T)	/* 不存在关键字等于key的数据元素 */
		return FALSE;
	else
	{
		if EQ(key, (*T)->data.key)
			Delete(T);
		else if LT(key, (*T)->data.key)
			DeleteBST(&(*T)->lchild, key);
		else
			DeleteBST(&(*T)->rchild, key);
		return TRUE;
	}
}
/* 初始条件: 动态查找表DT存在，Visit是对结点操作的应用函数 */
/* 操作结果: 按关键字的顺序对DT的每个结点调用函数Visit()一次且至多一次 */
void TraverseDSTable(BiTree DT, void(*Visit)(ElemType))
{
	if (DT)
	{
		TraverseDSTable(DT->lchild, Visit);
		Visit(DT->data);
		TraverseDSTable(DT->rchild, Visit);
	}
}
void print(ElemType c)
{
	printf("(%d,%d)", c.key, c.others);
}
int main(void)
{
	BiTree dt, p;
	int i;
	KeyType j;
	ElemType r[N]= { { 45,1 },{ 12,2 },{ 53,3 },{ 3,4 },{ 37,5 },{ 24,6 },{ 100,7 },{ 61,8 },{ 90,9 },{ 78,10 } };
	InitDSTable(&dt);
	for (i = 0; i < N; i++)
		InsertBST(&dt, r[i]);
	TraverseDSTable(dt, print);
	printf("\n请输入待查找的值: ");
	scanf("%d", &j);
	p = SearchBST(dt, j);
	if (p)
	{
		printf("表中存在此值。");
		DeleteBST(&dt, j);
		printf("删除此值后:\n");
		TraverseDSTable(dt, print);
		printf("\n");
	}
	else
		printf("表中不存在此值\n");
	DestroyDSTable(&dt);
	system("pause");
}