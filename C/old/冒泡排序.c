#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
typedef int Status;
#define N 8
void Swap(int a[], int i, int j)
{
	int t;
	t = a[i];
	a[i] = a[j];
	a[j] = t;
}
void bubble_sort(int a[], int n)
{
	int i, j, t;
	Status change;
	for (i = 1, change = TRUE; i < n && change; i++)
	{
		change = FALSE;
		for (j = n - 2; j >= i-1; j--)	//因为数组从0开始
			if (a[j] > a[j + 1]) {
				Swap(a, j, j + 1);
				change = TRUE;
			}
	}
}
void print(int r[], int n)
{
	int i;
	for (i = 0; i<n; i++)
		printf("%4d ", r[i]);
	printf("\n");
}
int main()
{
	int d[N] = { 49,38,65,97,76,13,27,49 };
	printf("排序前:\n");
	print(d, N);
	bubble_sort(d, N);
	printf("排序后:\n");
	print(d, N);
	system("pause");
}

