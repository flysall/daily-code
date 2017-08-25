#define CHAR 1
#if CHAR
typedef char TElemType;
TElemType Nil = ' ';		//字符型益空格为空
#else
typede int TelemType;
TElemType Nil = '0';
#endif
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FLASE 0
#define OK 1
#define ERROR 0	
typedef int Status;		//
typedef enum { Link, Thread } PointerTag;		//枚举 （Link：指针  Thread：线索）


typedef struct BiThrNode
{
	TElemType data;
	struct BiThrNode * lchild, *rchild;
	PointerTag LTag, RTag;		//左右标志
}BiThrNode, *BiThrTree;


/* 按先序输入二叉线索树中结点的值,构造二叉线索树T */
/* 0(整型)/空格(字符型)表示空结点 */
Status CreateBiThrTree(BiThrTree * T)
{
	TElemType h;
#ifdef CHAR
	scanf("%c", &h);
#else
	scanf("%d", &h);
#endif
	if (h == Nil)
		*T = NULL;
	else
	{
		*T = (BiThrTree)malloc(sizeof(BiThrNode));
		if (!*T)
			exit(OVERFLOW);
		(*T)->data = h;
		CreateBiThrTree(&(*T)->lchild);		//递归构造左子树
		if ((*T)->lchild)
			(*T)->LTag = Link;
		CreateBiThrTree(&(*T)->rchild);	//递归构造右子树	
		if ((*T)->rchild)
			(*T)->RTag = Link;
	}
	return OK;
}

BiThrTree pre;		//全局变量，始终指向刚刚访问过的节点

//中序遍历进行中序线索化。
void InThreading(BiThrTree p)
{
	if (p)
	{
		InThreading(p->lchild);		/* 递归左子树线索化 */
		if (!p->lchild)
		{
			p->LTag = Thread;
			p->lchild = pre;		
		}
		if (!pre->rchild)
		{
			pre->RTag = Thread;
			pre->rchild = p;
		}
		pre = p;		
		InThreading(p->rchild);	//递归右子树线索化
	}
}


//中序遍历二叉树T,并将其中序线索化,Thrt指向头结点。
Status InOrderThreading(BiThrTree *Thrt, BiThrTree T)
{
	*Thrt = (BiThrNode*)malloc(sizeof(BiThrNode));
	if (!*Thrt)
		exit(OVERFLOW);
	(*Thrt)->LTag = Link;		 /* 建头结点 */
	(*Thrt)->RTag = Thread;
	(*Thrt)->rchild = *Thrt;
	if (!T)
		(*Thrt)->lchild = *Thrt;
	else
	{
		(*Thrt)->lchild = T;
		pre = *Thrt;
		InThreading(T);
		pre->rchild = *Thrt;
		pre->RTag = Thread;
		(*Thrt)->rchild = pre;
	}
	return OK;
}


// 中序遍历二叉线索树T(头结点)的非递归算法。
Status InOrderTraverse_Thr(BiThrTree T, Status(*Visit)(TElemType))
{
	BiThrTree  p;
	p = T->lchild;
	while (p != T)
	{
		while (p->LTag == Link)
			p = p->lchild;
		if (!(Visit(p->data)))
			return ERROR;
		while (p->RTag == Thread && p->rchild != T)
		{
			p = p->rchild;
			Visit(p->data);
		}
		p = p->rchild;
	}
	return OK;
}

Status vi(TElemType c)
{
#if CHAR	
	printf("%2c", c);
#else 
	printf("%2d", c);
#endif
	return OK;
}

int main(void)
{
	BiThrTree H, T;
#if CHAR	
	printf("请按先序输入二叉树(如:ab三个空格表示a为根结点,b为左子树的二叉树)\n");
#else
	printf("请按先序输入二叉树(如:1 2 0 0 0表示1为根结点,2为左子树的二叉树)\n");
#endif
	CreateBiThrTree(&T);
	InOrderThreading(&H, T);
	printf("中序遍历(输出)二叉线索树:\n");
	InOrderTraverse_Thr(H, vi);
	printf("\n");
	system("pause");
}