#include <stdio.h>
#include <stdlib.h>
#define SIZE 51
int main()
{
	int data[SIZE] = { 0 };
	int index = 1;			//����Ԫ�ظ�����ʾ�׳˵�λ��
	int n;
	int i, j, k;
	data[1] = 1;			//��ʼ���� ��1�� = 1
	printf("Input n:");
	scanf("%d", &n);
	for (i = 1; i <= n; i++) {				
		for (j = 1; j <= index; j++) {		//����׳�i��
			data[j] = data[j] * i;
		}
		for (k = 1; k < index; k ++ ) {
			if (data[k] >= 10)			//���׳˵���ζ���ִ��ڵ���10�����λ
			{
				data[k + 1] = data[k + 1] + data[k] / 10;	//��ǰλ��ǰ��λ
				data[k] = data[k] % 10;
			}
		}
		//�����������λ�������������λ���ڻ����10����λ��index��1
		while (data[index] >= 10 && index < SIZE - 1)
		{
			data[index + 1] = data[index] / 10;
			data[index] = data[index] % 10;
			index++;
		}
		if (index <= SIZE - 1)			//��������Ƿ��������δ��������ӡ�׳�ֵ
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