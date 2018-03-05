#include <stdio.h>
#include <stdlib.h>

#define N 8
#define MAXSIZE 20		// һ������ʾ����С˳������󳤶�
#define LT(a,b) ((a)<(b))

typedef int InfoType;
typedef int KeyType;

typedef struct
{
	KeyType key;
	InfoType oherinfo;
}RedType;
typedef struct
{
	RedType r[MAXSIZE + 1];		//r[0]��Ϊ�ڱ���Ԫ
	int length;
}SqList;

//�۰�����
void BInsertSort(SqList * L)
{
	int i, j, m, low, high;
	for (i = 2; i <= L->length; i++) {
		L->r[0] = L->r[i];		//��L.r[i]�ݴ浽L.r[0]
		low = 1;
		high = i - 1;
		while (low <= high) {	/* ��r[low..high]���۰������������λ�� */
			m = (low + high) / 2;
			if LT(L->r[0].key,L->r[m].key)
				high = m - 1;
			else
				low = m + 1;
		}
		for (j = i - 1; j >= high + 1; j--) {
			L->r[j + 1] = L->r[j];		//��¼����
		}
		L->r[high + 1] = L->r[0];		//����
	}
}

void print(SqList L)
{
	int i; 
	for (i = 1; i <= L.length; i++)
		printf("(%d,%d)", L.r[i].key, L.r[i].oherinfo);
	printf("\n");
}

int main(void)
{
	RedType d[N] = { { 49,1 },{ 38,2 },{ 65,3 },{ 97,4 },{ 76,5 },{ 13,6 },{ 27,7 },{ 49,8 } };
	SqList L;
	int i;
	for (i = 1; i <= N; i++)	/* ��L.r��ֵ */
		L.r[i] = d[i - 1];
	L.length = N;
	printf("����ǰ:\n");
	print(L);
	BInsertSort(&L);
	printf("�۰���������:\n");
	print(L);
	system("pause");		//�������ÿ�����
}