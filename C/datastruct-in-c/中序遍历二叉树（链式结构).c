#define CHAR /* 字符型 */
#include<stdio.h> /* EOF(=^Z或F6),NULL */
#include <stdlib.h>
#include<math.h> /* floor(),ceil(),abs() */
#define TRUE 1
#define FALSE 0
#define OK 1
typedef int Status; /* Status是函数的类型,其值是函数结果状态代码，如OK等 */
#ifdef CHAR
typedef char TElemType;
TElemType Nil = ' '; /* 字符型以空格符为空 */
#endif
#ifdef INT
typedef int TElemType;
TElemType Nil = 0; /* 整型以0为空 */
#endif
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild, *rchild; /* 左右孩子指针 */
}BiTNode, *BiTree;
Status InitBiTree(BiTree *T);
void CreateBiTree(BiTree *T);
void InOrderTraverse(BiTree T, Status(*Visit)(TElemType));
Status visitT(TElemType);
int main(void)
{
	BiTree T;
	InitBiTree(&T);
#ifdef CHAR
	printf("请先序输入二叉树(如:ab三个空格表示a为根结点,b为左子树的二叉树)\n");
#endif
#ifdef INT
	printf("请先序输入二叉树(如:1 2 0 0 0表示1为根结点,2为左子树的二叉树)\n");
#endif
	CreateBiTree(&T);
	printf("中序递归遍历二叉树:\n");
	InOrderTraverse(T, visitT);
	system("pause");
}
/* 操作结果: 构造空二叉树T */
Status InitBiTree(BiTree *T)
{ 
	*T = NULL;
	return OK;
}
//构造二叉树
void CreateBiTree(BiTree *T)
{
	TElemType ch;
#ifdef CHAR
	scanf("%c", &ch);
#endif
#ifdef INT
	scanf("%d", &ch);
#endif
	if (ch == Nil) /* 空 */
		*T = NULL;
	else
	{
		*T = (BiTree)malloc(sizeof(BiTNode));
		if (!*T)
			exit(OVERFLOW);
		(*T)->data = ch; /* 生成根结点 */
		CreateBiTree(&(*T)->lchild); /* 构造左子树 */
		CreateBiTree(&(*T)->rchild); /* 构造右子树 */
	}
}
//操作结果: 中序递归遍历T,对每个结点调用函数Visit一次且仅一次
void InOrderTraverse(BiTree T, Status(*Visit)(TElemType))
{
	if (T) {
		InOrderTraverse(T->lchild, Visit);
		Visit(T->data);
		InOrderTraverse(T->rchild, Visit);
	}
}
Status visitT(TElemType e)
{
#ifdef CHAR
	printf("%c", e);
#endif
#ifdef INT
	printf("%d", e);
#endif
	return OK;
}