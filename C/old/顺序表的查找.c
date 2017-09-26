#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define OK 1
#define ERROR 0
#define N 5
typedef int Status;		//
typedef int Boolean;
typedef int KeyType;
typedef struct
{
	long number; /* ׼��֤�� */
	char name[9]; /* ����(4�����ּ�1����������־) */
	int politics; /* ���� */
	int Chinese; /* ���� */
	int English; /* Ӣ�� */
	int math; /* ��ѧ */
	int physics; /* ���� */
	int chemistry; /* ��ѧ */
	int biology; /* ���� */
	KeyType key; /* �ؼ�������ӦΪKeyType,����ӦΪkey,��bo9-1.c��һ�� */
}ElemType;
ElemType r[N] = { { 179324,"�η���",85,89,98,100,93,80,47 },
{ 179325,"�º�",85,86,88,100,92,90,45 },
{ 179326,"½��",78,75,90,80,95,88,37 },
{ 179327,"��ƽ",82,80,78,98,84,96,40 },
{ 179328,"��С��",76,85,94,57,77,69,44 } }; /* ȫ�ֱ��� */
#define total key
#define EQ(a,b) (a==b)
#define LT(a,b) (a<b)
#define LQ(a,b) (a<=b)
typedef struct
{
	ElemType * elem;
	int length;
}SSTable;
//
Status Creat_Seq(SSTable * ST, int n)
{
	int i;
	(*ST).elem = (ElemType*)calloc(n + 1, sizeof(ElemType));
	if (!(*ST).elem)
		return ERROR;
	for (i = 1; i <= n; i++)
		*((*ST).elem + i) = r[i - 1];
	(*ST).length = n;
	return OK;
}
/* �ؽ���̬���ұ�Ϊ���ؼ��ַǽ������� */
void Ascend(SSTable * ST)
{
	int i, j, k;
	for (i = 1; i <= ST->length; i++)
	{
		k = i;		//k���ڼ�¼��ǰ��Сֵ���ڵ��±�
		ST->elem[0] = ST->elem[i];		//ST->elem[0]���ڴ�ŵ�ǰ��Сֵ
		for (j = i + 1; j <= ST->length; j++)
		{
			if LT(ST->elem[j].key, ST->elem[0].key)
			{
				k = j;
				ST->elem[0] = ST->elem[j];
			}
			if (k != i)
			{
				ST->elem[k] = ST->elem[i];
				ST->elem[i] = ST->elem[0];
			}
		}
	}
}
//�������: ����һ����n������Ԫ�صľ�̬���ؼ��ַǽ�����ұ�ST
Status Creat_Ord(SSTable * ST, int n)
{
	Status f;
	f = Creat_Seq(ST, n);
	if (f)
		Ascend(ST);
	return f;
}
//��ʼ����: ��̬���ұ�ST���ڡ��������: ���ٱ�S
Status Destroy(SSTable * ST)
{
	free((ST)->elem);
	(ST)->elem = NULL;
	ST->length = 0;
	return OK;
}
//
int Search_Seq(SSTable ST, KeyType key)
{
	int i;
	ST.elem[0].key = key;
	for (i = ST.length; !EQ(ST.elem[i].key, key); --i); /* �Ӻ���ǰ�� */
	return i;
}
int Search_Bin(SSTable ST, KeyType key)
{
	int low, high, mid;
	low = 1;
	high = ST.length;
	while (low <= high) {
		mid = (low + high) / 2;
		if EQ(key, ST.elem[mid].key)
			return mid;
		else if LT(key, ST.elem[mid].key)
			high = mid - 1;
		else
			low = mid + 1;
	}
	return 0;
}
//�������: ��˳���ST��ÿ��Ԫ�ص��ú���Visit()һ���ҽ�һ��
Status Traverse(SSTable ST, void(*Visit)(ElemType))
{
	ElemType *p;
	int i;
	p = ++ST.elem;
	for (i = 1; i <= ST.length; i++)
		Visit(*p++);
	return OK;
}
void print(ElemType c)
{
	printf("%-8ld%-8s%4d%5d%5d%5d%5d%5d%5d%5d\n", c.number, c.name, c.politics, c.Chinese, c.English, c.math, c.physics, c.chemistry, c.biology, c.total);
}
int main()
{
	SSTable st;
	int i, s;
	for (i = 0; i< N; i++)
		r[i].total = r[i].politics + r[i].Chinese + r[i].English + r[i].math + r[i].physics + r[i].chemistry + r[i].biology;
	Creat_Seq(&st, N);
	printf("׼��֤��  ����  ���� ���� ���� ��ѧ ���� ��ѧ ���� �ܷ�\n");
	Traverse(st, print);
	printf("������������˵��ܷ�: ");
	scanf("%d", &s);
	Creat_Ord(&st, N);
	i = Search_Bin(st, s);
	if (i)
		print(*(st.elem + i));
	else
		printf("û�ҵ�\n");
	Destroy(&st);
	system("pause");
}