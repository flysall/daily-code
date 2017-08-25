#define		INT	//
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FALSE 0
#define OK
typedef int Status;
#ifdef CHAR
typedef char TElemType;
TElemType Nil = ' ';
#endif
#ifdef INT
typedef int TElemType;
TElemType Nil = 0;		//
#endif
typedef struct BiTNode
{
	TElemType data;
	struct BitNode * lchild, *rchild;
}BiTNode, * BiTree;
//
Status InitBiTree(BiTree * T)
{
	*T = NULL;
	return OK;
}
//
void CreateBiTree(BiTree * T)
{
	TElemType ch;
#ifdef CHAR
	scanf("%c", &ch);
#endif
#ifdef INT
	scanf("%d", &ch);
#endif
	if (ch == Nil)
		*T = NULL;
	else
	{
		*T = (BiTree)malloc(sizeof(BiTNode));
		if (!*T)
			exit(OVERFLOW);
		(*T)->data = ch;
		CreateBiTree(&(*T)->lchild);		//
		CreateBiTree(&(*T)->rchild);		//
	}
}
//
Status BiTreeEmpty(BiTree T)
{
	if (T)
		return FALSE;
	else
		return TRUE;
}
//
int BiTreeDepth(BiTree T)
{
	int i, j;
	if (!T)
		return 0;
	if (T->lchild)
		i = BiTreeDepth(T->lchild);
	else
		i = 0;
	if (T->rchild)
		j = BiTreeDepth(T->rchild);
	else
		j = 0;
	return i > j ? i + 1 : j + 1;
}
//
TElemType Root(BiTree T)
{
	if (BiTreeEmpty(T))
		return Nil;
	else
		return T->data;
}

void main()
{
	Status i;
	BiTree T;
	TElemType e1;
	InitBiTree(&T);
	printf("After build a empty binary tree, is the tree empty? %d(1:yes 0:no)  the depth of tree = %d\n", BiTreeEmpty(T), BiTreeDepth(T));
	e1 = Root(T);
	if (e1 != Nil)
#ifdef CHAR
		printf("The root of the binary tree is: %c\n", e1);
#endif
#ifdef INT
	printf("The root of the binary tree is: %d\n", e1);
#endif
	else
		printf("The tree is empty, without a root!\n");
#ifdef CHAR
	printf("请先序输入二叉树(如:ab三个空格表示a为根结点, b为左子树的二叉树)\n");
#endif
#ifdef INT
	printf("请先序输入二叉树(如:1 2 0 0 0表示1为根结点,2为左子树的二叉树)\n");
#endif
	CreateBiTree(&T);
	printf("After build a binary tree,Is the tree empty? %d(1:yes 0:no)  the depth of tree = %d\n", BiTreeEmpty(T), BiTreeDepth(T));
	e1 = Root(T);
	if (e1 != Nil)
#ifdef CHAR
		printf("The root of binary tree is: %c\n", e1);
#endif
#ifdef INT
	printf("The root of binary tree is: %d\n", e1);
#endif
	else
		printf("The tree is empty, without a root!\n");
	system("pause");
}