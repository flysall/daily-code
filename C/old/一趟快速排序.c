#include<stdio.h>
#include <stdlib.h>
#define N 8
#define MAXSIZE 20 /* һ������ʾ����С˳������󳤶� */
typedef int KeyType; /* ����ؼ�������Ϊ���� */
typedef int InfoType;
typedef struct
{
	KeyType key; /* �ؼ����� */
	InfoType otherinfo; /* ������������������������ж��� */
}RedType; /* ��¼���� */
typedef struct
{
	RedType r[MAXSIZE + 1]; /* r[0]���û������ڱ���Ԫ */
	int length; /* ˳����� */
}SqList; /* ˳������� */
int Partition(SqList *L, int low, int high)
{
	RedType t;
	KeyType pivotkey;
	pivotkey = L->r[low].key;
	while (low < high)
	{
		while (low < high && L->r[high].key >= pivotkey)
			high--;
		t = L->r[low];
		L->r[low] = L->r[high];
		L->r[high] = t;
		while (low < high && L->r[low].key <= pivotkey)
			low++;
		t = L->r[low];
		L->r[low] = L->r[high];
		L->r[high] = t;
	}
	return low;
}
void QSort(SqList * L, int low, int high)
{
	int pivotloc;
	if (low < high)
	{
		pivotloc = Partition(L, low, high);
		QSort(L, low, pivotloc - 1);
		QSort(L, pivotloc + 1, high);
	}
}
void QuickSort(SqList * L)
{
	QSort(L, 1, L->length);
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
	RedType d[N] = { { 49,1 },{ 38,2 },{ 65,3 },{ 97,4 },{ 76,5 },{ 13,6 },{ 27,7 },{ 49,8 } };
	SqList L;
	int i;
	for (i = 0; i<N; i++)
		L.r[i + 1] = d[i];
	L.length = N;
	printf("����ǰ:\n");
	print(L);
	QuickSort(&L);
	printf("�����:\n");
	print(L);
	system("pause");
}