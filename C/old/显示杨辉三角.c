#include <stdio.h>
#include <stdlib.h>
int main(void)
{
	int i, j, n;
	do {
		printf("N = ");
		scanf("%d", &n);
		if (n > 12)
			printf("The number should <= 12\n");
	} while (n >12);			//控制输出图形正确
	for (i = 0; i <= n; i++)	//控制输出n行
	{
		for (j = 0; j < 24 - 2 * i; j++)
			printf(" ");		//控制输出第i行前的空格
		for (j = 1; j < i + 2; j++)
			printf("%4d", c(i, j));		//输出第i行j列的值
		printf("\n");
	}
	system("pause");
}
//求杨辉三角第x行y列的值
int c(int x, int y)
{
	int z; 
	if ((y == 1) || (y == x + 1))
		return 1;	
	z = c(x - 1, y - 1) + c(x - 1, y);
	return z;
}


