#include <stdio.h>
#include <stdlib.h>
#define N 7
char  T[N] = { '\0','a','b','c','a','b','d' };
#define length 6
void get_next(char T[], int * next)
{
	int i;
	i = 1;
	int j = 0;
	next[1] = 0;
	while (i < length)	
	{
		if (j == 0 || T[i] == T[j])
		{
			i++;
			j++;
			next[i] = j;
		}
		else
			j = next[j];
}
int main(void)
{
	int i;
	int * next = NULL;
	next = (int*)malloc(5 * sizeof(int));
	get_next(T, next);
	for (i = 1; i < N; i++)
	{
		printf("%4d", next[i]);
	}
	printf("\n");
	system("pause");
}
