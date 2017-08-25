#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>
typedef struct
{
	unsigned int weight;
	unsigned int parent, lchild, rchild;	//三叉链使得树可以按照任何顺序将节点放在数组中 
}HTNode, * HuffmanTree;
typedef char ** HuffmanCode;	 /* 动态分配数组存储赫夫曼编码表 */
int min1(HuffmanTree t, int i)
{
	int j, flag;
	unsigned int k = UINT_MAX;		 /* 取k为不小于可能的值 */
	for (j = 1; j <= i; j++)
	{
		if (t[j].weight < k && t[j].parent == 0)		//parent == 0 条件使得某个值不会被选中第二次
		{
			k = t[j].weight;
			flag = j;
		}
	}
	t[flag].parent = 1;
	return flag;
}
void Select(HuffmanTree t, int i, int *s1, int *s2)
{
	int j;
	*s1 = min1(t, i);
	*s2 = min1(t, i);
	if (*s1 > *s2)
	{
		j = *s1;
		*s1 = *s2;
		*s2 = j;
	}
}
void HuffmanCoding(HuffmanTree * HT, HuffmanCode * HC, int *w, int n)
{
	int m, i, s1, s2, start;
	unsigned c, f;
	HuffmanTree p;
	char *cd;
	if (n <= 1)
		return;
	m = 2 * n - 1;
	*HT = (HuffmanTree)malloc((m + 1) * sizeof(HTNode));
	for (p = *HT + 1, i = 1; i <= n; i++, p++, w++)
	{
		(*p).weight = *w;
		(*p).parent = 0;
		(*p).lchild = 0; 
		(*p).rchild = 0;
	}
	for (; i <= m; i++, p++)
	{
		(*p).parent = 0;
	}
	for (i = n + 1; i <= m; i++)
	{
		Select(*HT, i - 1, &s1, &s2);
		(*HT)[s1].parent = (*HT)[s2].parent = i;
		(*HT)[i].lchild = s1;
		(*HT)[i].rchild = s2;
		(*HT)[i].weight = (*HT)[s1].weight + (*HT)[s2].weight;
	}
	*HC = (HuffmanCode)malloc((n+1) * sizeof(char*));
	cd = (char*)malloc(n * sizeof(char));
	cd[n - 1] = '\0';
	for (i = 1; i <= n; i++)
	{
		start = n - 1;
		for (c = i, f = (*HT)[c].parent; f != 0; c = f, f = (*HT)[f].parent)
		{
			if ((*HT)[f].lchild == c)
				cd[--start] = '0';
			else
				cd[--start] = '1';
		}
		(*HC)[i] = (char*)malloc((n - start) * sizeof(char));
		strcpy((*HC)[i], &cd[start]);
	}
	free(cd);
}
int main(void)
{
	HuffmanTree HT;
	HuffmanCode HC;
	int *w, n, i;
	printf("请输入权值的个数(>1)：");
	scanf("%d", &n);
	w = (int*)malloc(n * sizeof(int));
	printf("请依次输入%d个权值(整型)：\n", n);
	for (i = 0; i <= n - 1; i++)
		scanf("%d", w + i);
	HuffmanCoding(&HT, &HC, w, n);
	for (i = 1; i <= n; i++)
		puts(HC[i]);
	system("pause");
}