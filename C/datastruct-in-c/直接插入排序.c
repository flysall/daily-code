#include <stdio.h>
#include <stdlib.h>
#define N 8
#define MAXSIZE 20	//一个用作示例的小顺序表的最大长度
#define LT(a,b) ((a)<(b))
typedef int InfoType;	//定义其它数据项的类型
typedef int keyType;	//定义关键字类型为整型
typedef struct
{
	keyType key;
	InfoType otherinfo;
}RedType;		// 记录类型
typedef struct
{
	RedType r[MAXSIZE + 1];	/* r[0]闲置或用作哨兵单元 */
	int length;	/* 顺序表长度 */
}SqList;	 /* 顺序表类型 */
void InSertSort(SqList * L);
void Print(SqList L);
int main()
{
	RedType d[N] = { { 49,1 },{ 38,2 },{ 65,3 },{ 97,4 },{ 76,5 },{ 13,6 },{ 27,7 },{ 49,8 } };
	SqList L;
	int i;
	for (i = 0; i < N; i++)
		L.r[i + 1] = d[i];
	L.length = N;
	printf("Before Sorting:\n");
	Print(L);
	InSertSort(&L);
	printf("After Sorting:\n");
	Print(L);
	system("pause");
}

//对顺序表L作直接插入排序
void InSertSort(SqList * L)
{
	int i, j;
	for (i = 2; i <= (*L).length; i++)
	{
		if (LT((*L).r[i].key, (*L).r[i - 1].key)) {
			(*L).r[0] = (*L).r[i];		//复制为哨兵
			for (j = i - 1; LT((*L).r[0].key, (*L).r[j].key); j--)
				(*L).r[j + 1] = (*L).r[j];	//记录后移
			(*L).r[j + 1] = (*L).r[0];
		}
	}
}
//打印
void Print(SqList L)
{
	int i;
	for (i = 1; i < L.length; i++)
		printf("(%d, %d)", L.r[i].key, L.r[i].otherinfo);
	printf("\n");
}
