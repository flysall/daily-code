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
	long number; /* 准考证号 */
	char name[9]; /* 姓名(4个汉字加1个串结束标志) */
	int politics; /* 政治 */
	int Chinese; /* 语文 */
	int English; /* 英语 */
	int math; /* 数学 */
	int physics; /* 物理 */
	int chemistry; /* 化学 */
	int biology; /* 生物 */
	KeyType key; /* 关键字类型应为KeyType,域名应为key,与bo9-1.c中一致 */
}ElemType;
ElemType r[N] = { { 179324,"何芳芳",85,89,98,100,93,80,47 },
{ 179325,"陈红",85,86,88,100,92,90,45 },
{ 179326,"陆华",78,75,90,80,95,88,37 },
{ 179327,"张平",82,80,78,98,84,96,40 },
{ 179328,"赵小怡",76,85,94,57,77,69,44 } }; /* 全局变量 */
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
/* 重建静态查找表为按关键字非降序排序 */
void Ascend(SSTable * ST)
{
	int i, j, k;
	for (i = 1; i <= ST->length; i++)
	{
		k = i;		//k用于记录当前最小值所在的下标
		ST->elem[0] = ST->elem[i];		//ST->elem[0]用于存放当前最小值
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
//操作结果: 构造一个含n个数据元素的静态按关键字非降序查找表ST
Status Creat_Ord(SSTable * ST, int n)
{
	Status f;
	f = Creat_Seq(ST, n);
	if (f)
		Ascend(ST);
	return f;
}
//初始条件: 静态查找表ST存在。操作结果: 销毁表S
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
	for (i = ST.length; !EQ(ST.elem[i].key, key); --i); /* 从后往前找 */
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
//操作结果: 按顺序对ST的每个元素调用函数Visit()一次且仅一次
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
	printf("准考证号  姓名  政治 语文 外语 数学 物理 化学 生物 总分\n");
	Traverse(st, print);
	printf("请输入待查找人的总分: ");
	scanf("%d", &s);
	Creat_Ord(&st, N);
	i = Search_Bin(st, s);
	if (i)
		print(*(st.elem + i));
	else
		printf("没找到\n");
	Destroy(&st);
	system("pause");
}