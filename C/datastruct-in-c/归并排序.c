#include <stdio.h>
#include <stdlib.h>
#define N 7
#define LQ(a,b) ((a)<(b))
#define MAXSIZE 20		//
typedef int KeyType;
typedef int InfoType;
typedef struct
{
	KeyType key;
	InfoType otherinfo;
}RedType;
typedef struct
{
	RedType r[MAXSIZE + 1];
	int length;
}SqList;
//
void Merge(RedType SR[], RedType TR[], int i, int m, int n)
{
	int j, k, l;
	for (j = m + 1, k = i; i <= m&&j <= n; k++)
		if LQ(SR[i].key, SR[j].key)
			TR[k] = SR[i++];
		else
			TR[k] = SR[j++];
	if (i <= m)
		for (l = 0; l <= m - i; l++)
			TR[k + l] = SR[i + l];
	if (j <= n)
		for (l = 0; l <= n - j; l++)
			TR[k + l] = SR[j + l];
}
//
void MSort(RedType SR[], RedType TR1[], int s, int t)
{
	int m;
	RedType TR2[MAXSIZE+1];
	if (s == t)
		TR1[s] = SR[s];
	else
	{
		m = (s + t) / 2;
		MSort(SR, TR2, s, m);
		MSort(SR, TR2, m + 1, t);
		Merge(TR2, TR1, s, m, t);
	}
}
void MergeSort(SqList *L)
{ /* 对顺序表L作归并排序。*/
	MSort((*L).r, (*L).r, 1, (*L).length);
}
void print(SqList L)
{
	int i;
	for (i = 1; i <= L.length; i++)
		printf("(%d,%d)", L.r[i].key, L.r[i].otherinfo);
	printf("\n");
}
int main(void)
{
	RedType d[N] = { { 49,1 },{ 38,2 },{ 65,3 },{ 97,4 },{ 76,5 },{ 13,6 },{ 27,7 } };
	SqList l;
	int i;
	for (i = 0; i<N; i++)
		l.r[i + 1] = d[i];
	l.length = N;
	printf("排序前:\n");
	print(l);
	MergeSort(&l);
	printf("排序后:\n");
	print(l);
	system("pause");
}
