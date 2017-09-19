#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
typedef int Status;
#if CHAR
typedef char TElemType;
TElemType Nil = ' ';		//
#else
typedef int TElemType;
TElemType Nil = 0;		//
#endif
#define MAX_TREE_SIZE 100	 /* 二叉树的最大结点数 */
typedef TElemType SqBiTree[MAX_TREE_SIZE];		//0号单元存储根结点
typedef struct
{
	int level, order;	//结点的层,本层序号(按满二叉树计算)
}position;
//构造空二叉树T。因为T是固定数组，不会改变，故不需要&
Status InitBiTree(SqBiTree T)
{
	int i;
	for (i = 0; i < MAX_TREE_SIZE; i++)
		T[i] = Nil;		/* 初值为空 */
	return OK;
}
//
Status CreateBiTree(SqBiTree T)
{
	int i = 0;
#if CHAR
	int l;
	char s[MAX_TREE_SIZE];
	printf("请按层序输入结点的值(字符)，空格表示空结点，结点数≤%d:\n", MAX_TREE_SIZE);
	gets(s);
	l = strlen(s)
		for (; i < l; i++) {
			T[i] = s[i];
			if (i != 0 && T[(i + 1) / 2 - 1] == Nil && T[i] != Nil) {
				printf("出现无双亲的非根结点%c\n", T[i]);
				exit(ERROR);
			}
		}
	for (i = l; i < MAX_TREE_SIZE; i++)
		T[i] = Nil;
#else
	printf("请按层序输入结点的值(整型)，0表示空结点，输999结束。结点数≤%d:\n", MAX_TREE_SIZE);
	while (1) {
		scanf("%d", &T[i]);
		if (T[i] == 999)
			break;
		if (i != 0 && T[(i + 1) / 2 - 1] == Nil && T[i] != Nil)
		{
			printf("出现无双亲的非根结点%d\n", T[i]);
			exit(ERROR);
		}
		i++;
	}
	while (i < MAX_TREE_SIZE) {
		T[i] = Nil;
		i++;
	}
#endif
	return OK;
}
//
int BiTreeDepth(SqBiTree T)
{
	int i, j = -1;
	for (i = MAX_TREE_SIZE - 1; i >= 0; i--)
		if (T[i] != Nil)
			break;
	i++;
	do
		j++;
		while (i >= pow(2, j));
	return j;
}
//
TElemType Value(SqBiTree T, position e)
{
	return T[(int)pow(2, e.level - 1) + e.order - 2];
}
//
void Move(SqBiTree q, int j, SqBiTree T, int i)
{
	if (q[2 * j + 1] != Nil)
		Move(q, (2 * j + 1), T, (2 * i + 1));
	if (q[2 * j + 2] != Nil)
		Move(q, (2 * j + 2), T, (2 * i + 2));
	T[i] = q[j];
	q[j] = Nil;
}
//
Status InsertChild(SqBiTree T, TElemType p, Status LR, SqBiTree c)
{
	int j, k, i=0;
	for (j = 0; j < (int)pow(2, BiTreeDepth(T)) - 1; j++)
		if (T[j] == p)
			break;
	k = 2 * j + 1 + LR;
	if (T[k] != Nil)
		Move(T, k, T, 2 * k + 2);
	Move(c, i, T, k);
	return OK;
}
//
void Print(SqBiTree T)
{
	int j, k;
	position p;
	TElemType e;
	for (j = 1; j <= BiTreeDepth(T); j++) {
		printf("第%d层: ", j);
		for (k = 1; k <= pow(2, j - 1); k++) {
			p.level = j;
			p.order = k;
			e = Value(T, p);
			if (e != Nil)
				printf("%d:%d", k, e);
		}
		printf("\n");
	}
}
int main(void)
{
	int j;
	TElemType e;
	SqBiTree T, s;
	InitBiTree(T);
	CreateBiTree(T);
	printf("建立右子树为空的树s:\n"); 
	CreateBiTree(s);
	printf("树s插到树T中,请输入树T中树s的双亲结点 s为左(0)或右(1)子树: ");
	scanf("%d%d", &e, &j);
	InsertChild(T, e, j, s);
	Print(T);
	system("pause");
}