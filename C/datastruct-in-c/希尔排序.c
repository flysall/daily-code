#include <stdio.h>
#include <stdlib.h>
#define N 10
#define T 3
#define LT(a,b) ((a)<(b))
#define MAXSIZE 20		/* 一个用作示例的小顺序表的最大长度 */
typedef int InfoType;	/* 定义其它数据项的类型 */
typedef int KeyType;	/* 定义关键字类型为整型 */
typedef struct
{
	KeyType key;
	InfoType otherinfo;
}RedType;
typedef struct
{
	RedType r[MAXSIZE];
	int length;
}SqList;
void ShellInsert(SqList * L, int dk)
{
	int i, j;
	for (i = dk + 1; i < L->length; i++)
		if (LT(L->r[i].key, L->r[i - dk].key))
		{
			L->r[0] = L->r[i];
			for (j = i - dk; j > 0 && LT(L->r[0].key, L->r[j].key); j -= dk)
				L->r[j + dk] = L->r[j];	
			L->r[j + dk] = L->r[0];
		}
}
void print(SqList L)
{
	int i;
	for (i = 1; i <= L.length; i++)
		printf("%4d", L.r[i].key);
	printf("\n");
}
void printl(SqList L)
{
	int i;
	for (i = 0; i <= L.length; i++)
		printf("(%d, %d)", L.r[i].key, L.r[i].otherinfo);
	printf("\n");
}
void ShellSort(SqList * L, int dlta[], int t)
{
	int k;
	for (k = 0; k < t; k++)
	{
		ShellInsert(L, dlta[k]);
		printf("第%d趟排序结果: ", k + 1);
		print(*L);
	}
}
int main(void)
{
	RedType d[N] = { { 49,1 },{ 38,2 },{ 65,3 },{ 97,4 },{ 76,5 },{ 13,6 },{ 27,7 },{ 49,8 },{ 55,9 },{ 4,10 } };
	SqList l;
	int i, dt[T] = { 5,3,1 };
	for (i = 0; i < N; i++)
		l.r[i + 1] = d[i];
	l.length = N;
	printf("排序前: ");
	print(l);
	ShellSort(&l, dt, T);
	printf("排序后: ");
	printl(l);
	system("pause");
}