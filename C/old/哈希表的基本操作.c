#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define OK 1
#define ERROR 0
typedef int Status;
#define NULLKEY 0	//0Ϊ�޼�¼��־
#define N 10	//the number of the data
typedef int keyType;	//
typedef struct
{
	keyType key;
	int ord;
}ElemType;		/* ����Ԫ������ */
#define EQ(a,b) (a == b)
int hashsize[] = { 11, 19, 29, 37 };
int m = 0; ;		//m is the length of the HashTable
typedef struct
{
	ElemType *elem;	//����Ԫ�ش洢��ַ����̬��������
	int count;		//��ǰ����Ԫ�ظ���
	int sizeindex;	/* hashsize[sizeindex]Ϊ��ǰ���� */
}HashTable;
#define SUCCESS 1
#define UNSUCCESS 0
#define DUPLICATE -1
/* �������: ����һ���յĹ�ϣ�� */
Status InitHashTable(HashTable *H)
{
	int i;
	(*H).count = 0;
	(*H).sizeindex = 0;
	m = hashsize[0];
	(*H).elem = (ElemType*)malloc(m * sizeof(ElemType));
	if (!(*H).elem)
		exit(OVERFLOW);
	for (i = 0; i < m; i++)
	{
		(*H).elem[i].key = NULLKEY;
	}
	return OK;
}
/* ��ʼ����: ��ϣ��H���ڡ��������: ���ٹ�ϣ��H */
void DestroyHashTable(HashTable *H)
{
	free((*H).elem);
	(*H).elem = NULL;
	(*H).count = 0;
	(*H).sizeindex = 0;
}
//
unsigned Hash(keyType k)
{
	return k % m;		//m is a global variable
}
void collision(int *p, int d)
{
	*p = (*p + d) % m;
}
Status SearchHash(HashTable H, keyType K, int *p, int *c)
{// c���ԼƳ�ͻ���������ֵ���㣬���������ʱ�ο���
	*p = Hash(K);
	while (H.elem[*p].key != NULLKEY && !EQ(K,H.elem[*p].key))
	{
		(*c)++;
		if (*c < m)
			collision(p, *c);
		else
			break;
	}
	if EQ(K, H.elem[*p].key)
		return SUCCESS;			/* ���ҳɹ���p���ش�������Ԫ��λ�� */
	else
		return UNSUCCESS;		// ���Ҳ��ɹ�(H.elem[p].key==NULLKEY)��p���ص��ǲ���λ�� 
}
//
Status InsertHash(HashTable *, ElemType);	//the declaration of function
/* �ؽ���ϣ�� */
void RecreateHashTable(HashTable *H)
{
	int i, count = (*H).count;
	ElemType *p, *elem = (ElemType*)malloc(count * sizeof(ElemType));
	p = elem;
	printf("�ؽ���ϣ��\n");
	for (i = 0; i < m; i++)
	{
		if (((*H).elem + i)->key != NULLKEY)
			*p++ = *((*H).elem + i);
	}
	(*H).count = 0;
	(*H).sizeindex++;		//enlarge the size of the memory
	m = hashsize[(*H).sizeindex];
	p = (ElemType*)realloc((*H).elem, m * sizeof(ElemType));
	if (!p)
		exit(OVERFLOW);
	(*H).elem = p;
	for (i = 0; i < m; i++)
		(*H).elem[i].key = NULLKEY;
	for (p = elem; p < elem + count; p++)
		InsertHash(H, *p);
}
/* ���Ҳ��ɹ�ʱ��������Ԫ��e�����Ŷ�ַ��ϣ��H�У�������OK�� */
/* ����ͻ�����������ؽ���ϣ��*/
Status InsertHash(HashTable *H, ElemType e)
{
	int c, p;
	c = 0;
	if (SearchHash(*H, e.key, &p, &c))
		return DUPLICATE;
	else if (c < hashsize[(*H).sizeindex] / 2)
	{
		(*H).elem[p] = e;
		(*H).count++;
		return OK;
	}
	else
		RecreateHashTable(H);
	return ERROR;
}
//������ϣ��
void TraverseHash(HashTable H, void(*Vi)(int, ElemType))
{
	int i;
	printf("��ϣ��ַ0��%d\n", m - 1);
	for (i = 0; i < m; i++)
		if (H.elem[i].key != NULLKEY)
			Vi(i, H.elem[i]);
}
/* �ڿ��Ŷ�ַ��ϣ��H�в��ҹؼ���ΪK��Ԫ��,�����ҳɹ�,��pָʾ�������� */
/* Ԫ���ڱ���λ��,������SUCCESS;����,����UNSUCCESS */
Status Find(HashTable H, keyType K, int *p)
{
	int c = 0;
	*p = Hash(K);
	while (H.elem[*p].key != NULLKEY && !EQ(K, H.elem[*p].key))
	{
		c++;
		if (c < m)
			collision(p, c);
		else
			return UNSUCCESS;
	}
	if EQ(K, H.elem[*p].key)
		return SUCCESS;
	else
		return UNSUCCESS;
}
void print(int p, ElemType r)
{
	printf("address = %d(%d,%d)\n", p, r.key, r.ord);
}
int main(void)
{

	ElemType r[N] = { { 17,1 },{ 60,2 },{ 29,3 },{ 38,4 },{ 1,5 },{ 2,6 },{ 3,7 },{ 4,8 },{ 60,9 },{ 13,10 } };
	HashTable h;
	int i, p;
	Status j;
	keyType k;
	InitHashTable(&h);
	for (i = 0; i < N; i++)
	{
		j = InsertHash(&h, r[i]);
		if (j == DUPLICATE)
			printf("�������йؼ���Ϊ%d�ļ�¼���޷��ٲ����¼(%d,%d)\n", r[i].key, r[i].key, r[i].ord);
	}
	printf("����ϣ��ַ��˳�������ϣ��:\n");
	TraverseHash(h, print);
	printf("����������Ҽ�¼�Ĺؼ���: ");
	scanf("%d", &k);
	j = Find(h, k, &p);
	if (j == SUCCESS)
		print(p, h.elem[p]);
	else
		printf("û�ҵ�\n");
	j = InsertHash(&h, r[i]);
	printf("����ϣ��ַ��˳������ؽ���Ĺ�ϣ��:\n");
	TraverseHash(h, print);
	printf("����������Ҽ�¼�Ĺؼ���: ");
	scanf("%d", &k);
	j = Find(h, k, &p);
	if (j == SUCCESS)
		print(p, h.elem[p]);
	else
		printf("û�ҵ�\n");
	DestroyHashTable(&h);
	system("pause");
}