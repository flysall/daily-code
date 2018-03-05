#include <stdio.h>
#include <stdlib.h>
#include <time.h>
void MakeDigit(int a[]);
int InputGuess(int b[]);
int IsRightPosition(int magic[], int guess[]);
int IsRightDigit(int magic[], int guess[]);
int main()
{
	int a[10] = { 1,3,4,2 };		//��¼������������
	int b[4];		//��¼�˲µ���
	int count;		//��¼�ѲµĴ���
	int rightDigit;	//�¶Ե����ָ���
	int rightPosition;	//���ֺ�λ�ö��¶Եĸ���
	int level;			//�������µĴ���
	srand(time(NULL));
	MakeDigit(a);		//�������һ����λ�������
	printf("How many times you want to guess?");
	scanf("%d", &level);
	count = 0;
	do {
		printf("NO.%d of %d times:\n", count + 1, level);
		printf("Please Input a number:");
		if (InputGuess(b) != 0)		//�����û��Ĳ²�
		{
			count++;
			rightPosition = IsRightPosition(a, b);	//���ֺ�λ�ö��ŶԵĸ���
			rightDigit = IsRightDigit(a, b);		//�û��¶Ե����ָ���
			rightDigit = rightDigit - rightPosition;
			printf("%dA%dB\n", rightPosition, rightDigit);
		}
	} while (count < level && rightPosition != 4);
	if (rightPosition == 4)
		printf("Congratutations, you got it at NO.%d\n", count);
	else
		printf("Sorry, you haven't got it,See you next time!\n");
	printf("Correct answer is %d%d%d%d", a[0], a[1], a[2], a[3]);
	system("pause");
	return 0;
}
//�������ܣ��������һ����λ�������λ��
void MakeDigit(int a[])
{
	int j, k, temp;
	for (j = 0; j < 10; j++)
	{
		a[j] = j;
	}
	for (j = 0; j < 10; j++)
	{
		k = rand() % 10;
		temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}
}
//�������ܣ������û��µ���������ʧ�ܷ���0�����򷵻�1
int InputGuess(int b[])
{
	int i, ret = 1;
	for (i = 0; i < 4; i++)
	{
		ret = scanf("%1d", &b[i]);
		printf("%d\n", ret);
		if (ret != 1)
		{
			printf("Input Data type Errot!\n");
			while (getchar() != '\n');
		}
	}
	if (b[0] == b[1] || b[0] == b[2] || b[0] == b[3] ||
		b[1] == b[2] || b[1] == b[3] || b[2] == b[3])
	{
		printf("The digits must be different from each other!\n");
		return 0;
	}
	else
		return 1;
}
//�������ܣ�ͳ��guess��magic���ֺ�λ�ö�һ�µĸ���
int IsRightPosition(int magic[], int guess[])
{
	int rightPosition = 0;
	int j;
	for (j = 0; j < 4; j++)
	{
		if (guess[j] == magic[j])
			rightPosition = rightPosition + 1;
	}
	return rightPosition;
}
int IsRightDigit(int magic[], int guess[])
{
	int rightDigit = 0;
	int j, k;
	for (j = 0; j < 4; j++)
	{
		for (k = 0; k < 4; k++)
		{
			if (guess[j] = magic[k])
				rightDigit = rightDigit + 1;
		}
	}
	return rightDigit;
}