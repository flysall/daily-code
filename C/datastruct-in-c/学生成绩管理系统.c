#include <stdio.h>
#include <stdlib.h>
#define STU_NUM 30
int Menu(void);
void ReadScore(long num[], float score[], int n);
void AverSumofScore(float scorea[], int n);
void DeSortbyScore(long num[], float score[], int n);
void AsSortbyNum(long num[], float score[], int n);
void SearchbyNum(long num[], float score[], int n);
void StatisticAnalysis(float score[], int n);
void PrintScore(long num[], float score[], int n);
int main()
{
	char itemSelected;
	int n = 0;
	float score[STU_NUM];
	long num[STU_NUM];
	while (1)
	{
		itemSelected = Menu();
		switch (itemSelected)
		{
		case 1:printf("Input student number (n<%d):", STU_NUM);
			scanf("%d", &n);
			ReadScore(num, score, n);
			break;
		case 2:AverSumofScore(score, n);
			break;
		case 3:DeSortbyScore(num, score, n);
			printf("\nSort in descending order by score:\n");
			PrintScore(num, score, n);
			break;
		case 4:AsSortbyNum(num, score, n);
			printf("\nSort in ascending order by num:\n");
			PrintScore(num, score, n);
			break;
		case 5:SearchbyNum(num, score, n);
			break;
		case 6:
			StatisticAnalysis(score, n);
		case 7:PrintScore(num, score, n);
			break;
		case 0:printf("End of program!\n");
			exit(0);
		default:printf("Input error!\n");
		}
	}
	system("pause");
	return 0;
}
// �������ܣ���ʾ�˵�������û����������ѡ��
int Menu(void)
{
	int itemSelected;
	printf("\nManagement for Students'scores\n");
	printf("1.Input record\n");
	printf("2.Caculate total and average score of course\n");
	printf("3.Sort in descending order by score\n");
	printf("4.Sort in asscendong order by number\n");
	printf("5.Search by number\n");
	printf("6.Statistic analysis \n");
	printf("0.Exit\n");
	printf("Please Input your choice:");
	scanf("%d", &itemSelected);
	return itemSelected;
}
//�������ܣ�����n��ѧ����ĳ�ſγɼ�
void ReadScore(long num[], float score[], int n)
{
	int i;
	printf("Input students' ID, name and score:\n");
	for (i = 0; i < n; i++) {
		scanf("%ld%f", &num[i], &score[i]);
	}
}
//����ȫ���ֺܷ�ƽ����
void AverSumofScore(float score[], int n)
{
	int i;
	float sum = 0;
	for (i = 0; i < n; i++)
	{
		sum = sum + score[i];
	}
	printf("sum = %.0f, aver = %.2f\n", sum, n > 0 ? sum / n : 0);
}
//�������ܣ���ѡ�񷨽�����score��Ԫ�شӸߵ�������
void DeSortbyScore(long num[], float score[], int n)
{
	int i, j, k;
	float temp1;
	long temp2;
	for (i = 0; i < n-1; i++)
	{
		k = i;
		for (j = i + 1; j < n; j++)
		{
			if (score[j] > score[k])
				k = j;
		}
		if (k != i)
		{
			temp1 = score[k]; 
			score[k] = score[i];
			score[i] = temp1;
			temp2 = num[k];
			num[k] = num[i];
			num[i] = temp2;
		}
	}
}
//�������ܣ���ѡ�񷨽�����num��Ԫ�ذ���С��������
void AsSortbyNum(long num[], float score[], int n)
{
	int i, j, k;
	float temp1;
	long temp2;
	for (i = 1; i < n - 1; i++)
	{
		k = i;
		for (j = i + 1; j < n; j++)
		{
			if (num[j] < num[k])
				k = j;
		}
		if (k != i)
		{
			temp1 = score[k];
			score[k] = score[i];
			score[i] = temp1;
			temp2 = num[k];
			num[k] = num[i];
			num[i] = temp2;
		}
	}
}
//�������ܣ���ѧ�Ų�ѯѧ���ɼ�����ʾ���ҽ��
void SearchbyNum(long num[], float score[], int n)
{
	long number;
	int i;
	printf("Input the number you want to search:");
	scanf("%ld", &number);
	for (i = 0; i < n; i++)
	{
		if (num[i] == number)
		{
			printf("%ld\t%.0f\n", num[i], score[i]);
			return;
		}
	}
	printf("\nNot found!\n");
}
//�������ܣ�ͳ�Ƹ������ε�ѧ����������ռ�ٷֱ�
void StatisticAnalysis(float score[], int n)
{
	int i, total, t[6] = { 0,0,0,0,0,0 };
	for (i = 0; i < n; i++)
	{
		if (score[i] >= 0 && score[i] < 60)
			t[0]++;
		else if (score[i] < 70)
			t[1]++;
		else if (score[i] < 80)
			t[2]++;
		else if (score[i] < 90)
			t[3]++;
		else if (score[i] < 100)
			t[4]++;
		else if (score[i] == 100)
			t[5]++;
	}
	for (total = 0, i = 0; i <= 5; i++)
	{
		total = total + t[i];
	}
	for (i = 0; i <= 5; i++)
	{
		if (i == 0)
		{
			printf("<60\t%d\t%.2f%%\n", t[i], (float)t[i] / n * 100);
		}
		else if (i == 5)
		{
			printf("%d\t%d\t%.2f%%\n",(i+5)*10, t[i], (float)t[i] / n * 100);
		}
		else
		{
			printf("%d-%d\t%d\t%.2f%%\n", (i + 5) * 10, (i + 5) * 10 + 9, t[i], (float)t[i] / n * 100);
		}
	}
}
//�������ܣ���ӡѧ���ɼ�
void PrintScore(long num[], float score[], int n)
{
	int i;
	for (i = 0; i < n; i++)
	{
		printf("%ld\t%.0f\n", num[i], score[i]);
	}
}