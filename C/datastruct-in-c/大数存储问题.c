#include <stdio.h>
#include <stdlib.h>
#define SIZE 51
int main()
{
	int data[SIZE] = { 0 };
	int index = 1;			//数组元素个数表示阶乘的位数
	int n;
	int i, j, k;
	data[1] = 1;			//初始化， 令1！ = 1
	printf("Input n:");
	scanf("%d", &n);
	for (i = 1; i <= n; i++) {				
		for (j = 1; j <= index; j++) {		//计算阶乘i！
			data[j] = data[j] * i;
		}
		for (k = 1; k < index; k ++ ) {
			if (data[k] >= 10)			//若阶乘的美味数字大于等于10，则进位
			{
				data[k + 1] = data[k + 1] + data[k] / 10;	//当前位向前进位
				data[k] = data[k] % 10;
			}
		}
		//单独处理最高位，若计算后的最高位大于或等于10，则位数index加1
		while (data[index] >= 10 && index < SIZE - 1)
		{
			data[index + 1] = data[index] / 10;
			data[index] = data[index] % 10;
			index++;
		}
		if (index <= SIZE - 1)			//检查数组是否溢出，若未溢出，则打印阶乘值
		{
			printf("%d! = ", i);
			for (j = index; j > 0; j--)
			{
				printf("%d", data[j]);
			}
			printf("\n");
		}
		else
		{
			printf("Over flow!\n");
			exit(1);

		}
	}
	system("pause");
	return 0;
}