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
	} while (n >12);			//�������ͼ����ȷ
	for (i = 0; i <= n; i++)	//�������n��
	{
		for (j = 0; j < 24 - 2 * i; j++)
			printf(" ");		//���������i��ǰ�Ŀո�
		for (j = 1; j < i + 2; j++)
			printf("%4d", c(i, j));		//�����i��j�е�ֵ
		printf("\n");
	}
	system("pause");
}
//��������ǵ�x��y�е�ֵ
int c(int x, int y)
{
	int z; 
	if ((y == 1) || (y == x + 1))
		return 1;	
	z = c(x - 1, y - 1) + c(x - 1, y);
	return z;
}


