#include <stdio.h>
#include <stdlib.h>
#define N 8
#define MAXSIZE 20 /* һ������ʾ����С˳������󳤶� */
typedef int InfoType; /* ������������������� */
typedef int KeyType; /* ����ؼ�������Ϊ���� */
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
int SelectMinKey(SqList L, int i)
{
	KeyType min;
	int j, k;
	k = i;
	min = L.r[i].key;
	for (j = i + 1; j <= L.length; j++) {
		if (min > L.r[j].key) 
		{
				k = j;
				min = L.r[j].key;
		}
	}
	return k;
}
void Swap(SqList * L, int i, int j)
{
	RedType t;
	t = (*L).r[i];
	(*L).r[i] = (*L).r[j];
	(*L).r[j] = t;
}
void SelectSort(SqList * L)
{
	int i, j;
	for (i = 1; i < (*L).length; i++) {
		j = SelectMinKey(*L, i);
		if (j != i)
		{
			Swap(L, i, j);
		}
	}
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
	SqList l;
	int i;
	for (i = 0; i<N; i++)
		l.r[i + 1] = d[i];
	l.length = N;
	printf("����ǰ:\n");
	print(l);
	SelectSort(&l);
	printf("�����:\n");
	print(l);
	system("pause");
}
