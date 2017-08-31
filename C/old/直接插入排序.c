#include <stdio.h>
#include <stdlib.h>
#define N 8
#define MAXSIZE 20	//һ������ʾ����С˳������󳤶�
#define LT(a,b) ((a)<(b))
typedef int InfoType;	//�������������������
typedef int keyType;	//����ؼ�������Ϊ����
typedef struct
{
	keyType key;
	InfoType otherinfo;
}RedType;		// ��¼����
typedef struct
{
	RedType r[MAXSIZE + 1];	/* r[0]���û������ڱ���Ԫ */
	int length;	/* ˳����� */
}SqList;	 /* ˳������� */
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

//��˳���L��ֱ�Ӳ�������
void InSertSort(SqList * L)
{
	int i, j;
	for (i = 2; i <= (*L).length; i++)
	{
		if (LT((*L).r[i].key, (*L).r[i - 1].key)) {
			(*L).r[0] = (*L).r[i];		//����Ϊ�ڱ�
			for (j = i - 1; LT((*L).r[0].key, (*L).r[j].key); j--)
				(*L).r[j + 1] = (*L).r[j];	//��¼����
			(*L).r[j + 1] = (*L).r[0];
		}
	}
}
//��ӡ
void Print(SqList L)
{
	int i;
	for (i = 1; i < L.length; i++)
		printf("(%d, %d)", L.r[i].key, L.r[i].otherinfo);
	printf("\n");
}
