#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define OK 1
typedef int Status;		/* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */
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
/* �ڸ�ָ��T��ָ�����������еݹ�ز���ĳ�ؼ��ֵ���key������Ԫ�أ� */
/* �����ҳɹ����򷵻�ָ�������Ԫ�ؽ���ָ��,���򷵻ؿ�ָ�롣*/
BiTree SearchBST(BiTree T, KeyType key)
{
	if ((!T) || EQ(key, T->data.key))
		return T;
	else if LT(key, T->data.key)
		return SearchBST(T->lchild, key);
	else
		return SearchBST(T->rchild, key);
}
/* �ڸ�ָ��T��ָ�����������еݹ�ز�����ؼ��ֵ���key������Ԫ�أ������� */
/* �ɹ�����ָ��pָ�������Ԫ�ؽ�㣬������TRUE������ָ��pָ�����·���� */
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
/* ������������T�в����ڹؼ��ֵ���e.key������Ԫ��ʱ������e������TRUE�� */
/* ���򷵻�FALSE��*/
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
/* �Ӷ�����������ɾ�����p�����ؽ����������������*/
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
/* ������������T�д��ڹؼ��ֵ���key������Ԫ��ʱ����ɾ��������Ԫ�ؽ�㣬 */
/* ������TRUE�����򷵻�FALSE��*/
Status DeleteBST(BiTree * T, KeyType key)
{
	if (!*T)	/* �����ڹؼ��ֵ���key������Ԫ�� */
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
/* ��ʼ����: ��̬���ұ�DT���ڣ�Visit�ǶԽ�������Ӧ�ú��� */
/* �������: ���ؼ��ֵ�˳���DT��ÿ�������ú���Visit()һ��������һ�� */
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
	printf("\n����������ҵ�ֵ: ");
	scanf("%d", &j);
	p = SearchBST(dt, j);
	if (p)
	{
		printf("���д��ڴ�ֵ��");
		DeleteBST(&dt, j);
		printf("ɾ����ֵ��:\n");
		TraverseDSTable(dt, print);
		printf("\n");
	}
	else
		printf("���в����ڴ�ֵ\n");
	DestroyDSTable(&dt);
	system("pause");
}