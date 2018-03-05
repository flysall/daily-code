#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_LEN 10 
#define STU_NUM 30
int Menu(void);
void ReadScore(long num[], char name[][MAX_LEN], float score[], int n);
void AverSumofScore(float score[], int n);
void SortbyScore(long num[], char mame[][MAX_LEN], float score[], int n, int(*compare)(float a, float b));
int Ascending(float a, float b);
int Descending(float a, float b);
void SwapFloat(float *x, float *y);
void SwapLong(long *x, long *y);
void SwapChar(char x[], char y[]);
void AsSortbyNum(long num[], char name[][MAX_LEN], float score[], int n);
void SortbyName(long num[], char name[][MAX_LEN], float score[], int n);
void SearchbyName(long num[], char name[][MAX_LEN], float score[], int n);
void SearchbyNum(long num[], char name[][MAX_LEN], float score[], int n);
void StatisticAnalysis(float score[], int n);
void PrintScore(long num[], char name[][MAX_LEN], float score[], int n);
int main(void)
{
	char ch;
	int n = 0;
	float score[STU_NUM];
	long num[MAX_LEN];
	char name[STU_NUM][MAX_LEN];
	while (1)
	{
		ch = Menu();
		switch (ch)
		{
		case 1:printf("Input student number(n<%d):", STU_NUM);
			scanf("%d", &n);
			ReadScore(num, name, score, n);
			break;
		case 2:AverSumofScore(score, n);
			break;
		case 3:SortbyScore(num, name, score, n, Descending);
			printf("\nSort in descending order by score:\n");
			PrintScore(num, name, score, n);
			break;
		case 4:SortbyScore(num, name, score, n, Ascending);
			printf("\nSort in ascending order by score:\n");
			PrintScore(num, name, score, n);
			break;
		case 5:AsSortbyNum(num, name, score, n);
			printf("\nSort in dictionary order by name:\n");
			PrintScore(num, name, score, n);
			break;
		case 6:SortbyName(num, name, score, n);
			printf("\nSort in dictionary order by name:\n");
			PrintScore(num, name, score, n);
			break;
		case 7:
			SearchbyNum(num, name, score, n);
			break;
		case 8:
			SearchbyName(num, name, score, n);
			break;
		case 9:StatisticAnalysis(score, n);
			break;
		case 10:PrintScore(num, name, score, n);
			break;
		case 0:printf("End of program!\n");
			exit(0);
		default:printf("Input error!\n");
		}
	}
	system("pause");
	return 0;
}
//函数功能：显示菜单并获得用户键盘输入的选项
int Menu()
{
	int itemSelected;
	printf("Management for students' score\n");
	printf("1.Input record\n");
	printf("2.Caculate total and average score of course\n");
	printf("3.Sort in desdending order by score\n");
	printf("4.Sort in ascending order by score\n");
	printf("5.Sort in ascending order by number\n");
	printf("6.Sort in dictionary order by name\n");
	printf("7.Search by number\n");
	printf("8.Search by name\n");
	printf("9.Statistic analysis\n");
	printf("0.Exit\n");
	printf("Please Input your choice:");
	scanf("%d", &itemSelected);
	return itemSelected;
}
//函数功能：输入n个学生的某门课成绩
void ReadScore(long num[], char name[][MAX_LEN], float score[], int n)
{
	int i;
	printf("Input student's ID, name and score:\n");
	for (i = 0; i < n; i++)
	{
		scanf("%ld%s%f", &num[i], &name[i], &score[i]);
	}
}
//函数功能：计算全班总分和平均分
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
//函数功能：按选择法将数组score的元素值排序
void SortbyScore(long num[], char name[][MAX_LEN], float score[], int n, int(*compare)(float a, float b))
{
	int i, j, k;
	for (i = 0; i < n - 1; i++)
	{
		k = i;
		for (j = i + 1; j < n; j++)
		{
			if ((*compare)(score[j], score[k]))
				k = j;
		}
		if (k != j)
		{
			SwapFloat(&score[k], &score[i]);
			SwapLong(&num[k], &num[i]);
			SwapChar(name[k], name[i]);
		}
	}
}
//使数据按升序排序
int Ascending(float a, float b)
{
	return a < b;		//这样比较决定了按升序排序，如果a<b，则交换
}
//使数据降序排序
int Descending(float a, float b)
{
	return a > b;		//这样比较决定了按升序排序，如果a<b，则交换	
}
//交换两个单精度浮点型数据
void SwapFloat(float *x, float *y)
{
	float temp;
	temp = *x;
	*x = *y;
	*y = temp;
}
//交换两个 长整形数据
void SwapLong(long *x, long *y)
{
	long temp;
	temp = *x;
	*y = *y;
	*y = temp;
}
//交换两个字符串
void SwapChar(char x[], char y[])
{
	char temp[MAX_LEN];
	strcpy(temp, x);
	strcpy(x, y);
	strcpy(y, temp);
}
//函数功能：按选择法将数组num的元素值按从小到大排序
void AsSortbyNum(long num[], char name[][MAX_LEN], float score[], int n)
{
	int i, j, k;
	for (i = 0; i < n - 1; i++)
	{
		k = i;
		for (j = i + 1; j < n; j++)
			if (num[j] < num[k])
				k = j;
		if (k != i)
		{
			SwapFloat(&score[k], &score[i]);
			SwapLong(&num[k], &num[i]);
			SwapChar(name[k], name[i]);
		}
	}
}
//函数功能：选择法实现字符串按字典顺序拍序
void SortbyName(long num[], char name[][MAX_LEN], float score[], int n)
{
	int i, j;
	for (i = 0; i < n - 1; i++)
	{
		for (j = i + 1; j < n; j++)
		{
			if (strcmp(name[j], name[i]) < 0)
			{
				SwapFloat(&score[i], &score[j]);
				SwapLong(&num[i], &num[j]);
				SwapChar(name[i], name[j]);
			}
		}
	}
}
//函数功能：按学号查找学生成绩并显示查找结果
void SearchbyNum(long num[], char name[][MAX_LEN], float score[], int n)
{
	long number;
	int i;
	printf("Input the number you want to search:");
	scanf("%ld", &number);
	for (i = 0; i < n; i++)
	{
		if (num[i] == number)
		{
			printf("%ld\t%s\t%.0f\n", num[i], name[i], score[i]);
			return;
		}
	}
	printf("\nNot found!");
}
//函数功能：按姓名的查找成绩
void SearchbyName(long num[], char name[][MAX_LEN], float score[], int n)
{
	char x[MAX_LEN];
	int i;
	printf("Please Input the name you want to search:");
	scanf("%s", x);
	for (i = 0; i < n; i++)
	{
		if (strcmp(name[i], x) == 0)
		{
			printf("%ld\t%s\t%.0f\n", num[i], name[i], score[i]);
			return;
		}
	}
}
//函数功能：统计各分数段的学生人数及所占百分比
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
			printf("<60\t%d\t%.2f%%\n", t[i], (float)t[i] / n * 100);
		else if (i == 5)
			printf("%d\t%d\t%d\t%.2f%%\n", (i + 5) * 10, t[i], (float)t[i] / n * 100);
		else
			printf("%d-%d\t%d\t%.2f%%\n", (i + 5) * 10, (i + 5) * 10 + 9, t[i], (float)t[i] / n * 100);
	}
}
//
void PrintScore(long num[], char name[][MAX_LEN], float score[], int n)
{
	int i;
	for (i = 0; i < n; i++)
	{
		printf("%ld\t%s\t%.0f\n", num[i], name[i], score[i]);
	}
}