#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define OK 1
#define ERROR 0
typedef int Status;
#define NULLKEY 0	//0为无记录标志
#define N 10	//the number of the data
typedef int keyType;	//
typedef struct
{
	keyType key;
	int ord;
}ElemType;		/* 数据元素类型 */
#define EQ(a,b) (a == b)
int hashsize[] = { 11, 19, 29, 37 };
int m = 0; ;		//m is the length of the HashTable
typedef struct
{
	ElemType *elem;	//数据元素存储基址，动态分配数组
	int count;		//当前数据元素个数
	int sizeindex;	/* hashsize[sizeindex]为当前容量 */
}HashTable;
#define SUCCESS 1
#define UNSUCCESS 0
#define DUPLICATE -1
/* 操作结果: 构造一个空的哈希表 */
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
/* 初始条件: 哈希表H存在。操作结果: 销毁哈希表H */
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
{// c用以计冲突次数，其初值置零，供建表插入时参考。
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
		return SUCCESS;			/* 查找成功，p返回待查数据元素位置 */
	else
		return UNSUCCESS;		// 查找不成功(H.elem[p].key==NULLKEY)，p返回的是插入位置 
}
//
Status InsertHash(HashTable *, ElemType);	//the declaration of function
/* 重建哈希表 */
void RecreateHashTable(HashTable *H)
{
	int i, count = (*H).count;
	ElemType *p, *elem = (ElemType*)malloc(count * sizeof(ElemType));
	p = elem;
	printf("重建哈希表\n");
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
/* 查找不成功时插入数据元素e到开放定址哈希表H中，并返回OK； */
/* 若冲突次数过大，则重建哈希表。*/
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
//遍历哈希表
void TraverseHash(HashTable H, void(*Vi)(int, ElemType))
{
	int i;
	printf("哈希地址0～%d\n", m - 1);
	for (i = 0; i < m; i++)
		if (H.elem[i].key != NULLKEY)
			Vi(i, H.elem[i]);
}
/* 在开放定址哈希表H中查找关键码为K的元素,若查找成功,以p指示待查数据 */
/* 元素在表中位置,并返回SUCCESS;否则,返回UNSUCCESS */
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
			printf("表中已有关键字为%d的记录，无法再插入记录(%d,%d)\n", r[i].key, r[i].key, r[i].ord);
	}
	printf("按哈希地址的顺序遍历哈希表:\n");
	TraverseHash(h, print);
	printf("请输入待查找记录的关键字: ");
	scanf("%d", &k);
	j = Find(h, k, &p);
	if (j == SUCCESS)
		print(p, h.elem[p]);
	else
		printf("没找到\n");
	j = InsertHash(&h, r[i]);
	printf("按哈希地址的顺序遍历重建后的哈希表:\n");
	TraverseHash(h, print);
	printf("请输入待查找记录的关键字: ");
	scanf("%d", &k);
	j = Find(h, k, &p);
	if (j == SUCCESS)
		print(p, h.elem[p]);
	else
		printf("没找到\n");
	DestroyHashTable(&h);
	system("pause");
}