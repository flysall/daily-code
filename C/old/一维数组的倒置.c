#include <stdio.h>
#include <stdlib.h>
#define M 20
void fun(int *x, int n)
{
	int *i, *j, m = n / 2, *p;
	int temp;
	i = x;
	j = x + n - 1;
	p = x + m;
	for (; i < p; i++, j--) {
		temp = *i;
		*i = *j;
		*j = temp;
	}
}
int main(void)
{
	int i, a[M], n;
	printf("\nEnter n:\n");
	scanf("%d", &n);
	printf("The Original array:\n");
	for (i = 0; i < n; i++)
		scanf("%d", &a[i]);
	fun(a, n);
	printf("\nThe array invertedd:\n");
	for (i = 0; i < n; i++)
		printf("%2d", a[i]);
	printf("\n");
	system("pause");
}