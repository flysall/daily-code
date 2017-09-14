#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define OK 1
typedef int Status;		//
#define N 5
typedef char KeyType;
typedef struct
{
	KeyType key;
	int other;
}ElemType;
#define EQ(a,b) ((a)==(b))
#define LT(a,b) ((a)<(b))
typedef struct BSTNode
{
	ElemType data;
	int bf;		//
	struct BSTNode *lchild, *rchild;
}BSTNode, *BSTree;
//
Status InitDSTable(BSTree *DT)
{
	*DT = NULL;
	return OK;
}
//
void DestroyDSTable(BSTree * DT)
{
	if (!(*DT))
	{
		if ((*DT)->lchild)
			DestroyDSTable((*DT)->lchild);
		if ((*DT)->rchild)
			DestroyDSTable((*DT)->rchild);
		free(*DT);
		*DT = NULL;
	}
}
//
BSTree SearchBST(BSTree T, KeyType key)
{
	if EQ(key, T->data.key)
		return T;
	else if LT(key, T->data.key)
		return SearchBST(T->lchild, key);
	else
		return SearchBST(T->rchild, key);
}
//
void R_Rotate(BSTree *p)
{
	BSTree lc;
	lc = (*p)->lchild;
	(*p)->lchild = lc->rchild;
	lc->rchild = *p;
	*p = lc;
}
//
void L_Rotate(BSTree *p)
{
	BSTree lc;
	lc = (*p)->rchild;
	(*p)->rchild = lc->lchild;
	lc->lchild = (*p);
	(*p) = lc;
}
#define LH +1
#define EH 0
#define RH -1
//
void LeftBalance(BSTree *T)
{
	BSTree lc, rd;
	lc = (*T)->lchild;
	switch (lc->bf)			//修改各个节点的bf值，使其等于旋转后的值
	{
	case LH:
		lc->bf = (*T)->bf = 0;
		R_Rotate(*T);
		break;	
	case RH:
		rd = lc->rchild;
		switch(rd->bf)
		{
		case LH:
			(*T)->bf = RH;
			lc->bf = EH;
			break;
		case EH:
			(*T)->bf = lc->bf = EH;
			break;
		case RH:
			(*T)->bf = EH;
			lc->bf = LH;
		}
		rd->bf = EH;
		L_Rotate(&(*T)->lchild);
		R_Rotate(T);
	}
}
void RightBalance(BSTree * T)
{
	BSTree rc, rd;
	rc = (*T)->rchild;
	switch (rc->bf)
	{
	case RH:
		(*T)->bf = rc->bf = EH;
		L_Rotate(T);
		break;
	case LH:
		rd = rc->lchild;
		switch (rd->bf)
		{
		case RH:
			(*T)->bf = LH;
			rc->bf = EH;
			break;
		case EH:
			(*T)->bf = rd->bf = EH;
			break;
		case LH:
			(*T)->bf = EH;
			rc->bf = RH;
		}
		rd->bf = EH;
		R_Rotate(&(*T)->rchild);
		L_Rotate(T);
	}
}



