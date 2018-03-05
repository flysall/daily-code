#include <stdio.h>
#include <stdlib.h>
#define N 20
void Insert(int a[], int n, int x);
int main()
{
	int a[N + 1];
	int n, i, x;
	printf("Input array size:");
	scanf("%d", &n);
	printf("Input array:");
	for (i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	printf("Input x:");
	scanf("%d", &x);
	Insert(a, n, x);
	printf("After insert %d:\n", x);
	for (i = 0; i < n + 1; i++)
	{
		printf("%4d", a[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}
//函数功能：将x插入到一个已按升序排序的数组中
void Insert(int a[], int n, int x)
{
	int i = 0, pos;
	while (x > a[i] && i < n)
	{
		i++;
	}
	pos = i;
	for (i = n - 1; i >= pos; i--) {
		a[i + 1] = a[i];
	}
	a[pos] = x;
}