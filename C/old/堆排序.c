#include<stdio.h>
#include <stdlib.h>
#define N 8
#define MAXSIZE 20 /* 一个用作示例的小顺序表的最大长度 */
typedef int InfoType; /* 定义其它数据项的类型 */
typedef int KeyType; /* 定义关键字类型为整型 */
typedef struct
{
	KeyType key; /* 关键字项 */
	InfoType otherinfo; /* 其它数据项，具体类型在主程中定义 */
}RedType; /* 记录类型 */
typedef struct
{
	RedType r[MAXSIZE + 1]; /* r[0]闲置或用作哨兵单元 */
	int length; /* 顺序表长度 */
}SqList; /* 顺序表类型 */
#define LT(a,b) ((a)<(b))
typedef SqList HeapType; /* 堆采用顺序表存储表示 */
void HeapAdjust(HeapType * H, int s, int m)
{
	RedType rc;
	int j;
	rc = H->r[s];
	for (j = 2 * s; j <= m; j *= 2)
	{
		if (j < m && LT(H->r[j].key, H->r[j + 1].key))
			j++;
		if (!LT(rc.key, H->r[j].key))
			break;
		H->r[s] = H->r[j];
		s = j;
	}
	H->r[s] = rc;
}
void Swap(SqList * L, int i, int j)
{
	RedType t;
	t = L->r[i];
	L->r[i] = L->r[j];
	L->r[j] = t;
}
void HeapSort(SqList * H)
{
	RedType t;
	int i;
	for (i = H->length / 2; i > 0; i--)
		HeapAdjust(H, i, H->length);
	for (i = H->length; i > 1; i--)
	{
		Swap(H, 1, i);
		HeapAdjust(H, 1, i - 1);
	}
}
void print(HeapType H)
{
	int i;
	for (i = 1; i <= H.length; i++)
		printf("(%d,%d)", H.r[i].key, H.r[i].otherinfo);
	printf("\n");
}
void main()
{
	RedType d[N] = { { 49,1 },{ 38,2 },{ 65,3 },{ 97,4 },{ 76,5 },{ 13,6 },{ 27,7 },{ 49,8 } };
	HeapType h;
	int i;
	for (i = 0; i<N; i++)
		h.r[i + 1] = d[i];
	h.length = N;
	printf("排序前:\n");
	print(h);
	HeapSort(&h);
	printf("排序后:\n");
	print(h);
	system("pause");
}
