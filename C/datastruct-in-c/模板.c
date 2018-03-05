#include <stdlib.h>
#include <stdio.h>
int main()
{
	int i, j, n;
	long term, sum = 0;
	printf("Input n:");
	scanf("%d", &n);
	for (i = 1; i <= n; i++)
	{
		term = 1;
		for (j = 1; j < n; j++)
		{
			term = term * j;

		}
		sum = sum + term;
	}
	printf("1!+2!+3!+%d! = %1d\n", n, sum);
	system("pause");
	return 0;
}