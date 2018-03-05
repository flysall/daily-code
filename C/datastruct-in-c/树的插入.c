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
#define MAX_TREE_SIZE 100	 /* ��������������� */
typedef TElemType SqBiTree[MAX_TREE_SIZE];		//0�ŵ�Ԫ�洢�����
typedef struct
{
	int level, order;	//���Ĳ�,�������(��������������)
}position;
//����ն�����T����ΪT�ǹ̶����飬����ı䣬�ʲ���Ҫ&
Status InitBiTree(SqBiTree T)
{
	int i;
	for (i = 0; i < MAX_TREE_SIZE; i++)
		T[i] = Nil;		/* ��ֵΪ�� */
	return OK;
}
//
Status CreateBiTree(SqBiTree T)
{
	int i = 0;
#if CHAR
	int l;
	char s[MAX_TREE_SIZE];
	printf("�밴�����������ֵ(�ַ�)���ո��ʾ�ս�㣬�������%d:\n", MAX_TREE_SIZE);
	gets(s);
	l = strlen(s)
		for (; i < l; i++) {
			T[i] = s[i];
			if (i != 0 && T[(i + 1) / 2 - 1] == Nil && T[i] != Nil) {
				printf("������˫�׵ķǸ����%c\n", T[i]);
				exit(ERROR);
			}
		}
	for (i = l; i < MAX_TREE_SIZE; i++)
		T[i] = Nil;
#else
	printf("�밴�����������ֵ(����)��0��ʾ�ս�㣬��999�������������%d:\n", MAX_TREE_SIZE);
	while (1) {
		scanf("%d", &T[i]);
		if (T[i] == 999)
			break;
		if (i != 0 && T[(i + 1) / 2 - 1] == Nil && T[i] != Nil)
		{
			printf("������˫�׵ķǸ����%d\n", T[i]);
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
		printf("��%d��: ", j);
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
	printf("����������Ϊ�յ���s:\n"); 
	CreateBiTree(s);
	printf("��s�嵽��T��,��������T����s��˫�׽�� sΪ��(0)����(1)����: ");
	scanf("%d%d", &e, &j);
	InsertChild(T, e, j, s);
	Print(T);
	system("pause");
}