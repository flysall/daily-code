#include <stdio.h>
#include <stdlib.h>
#define MaxSize 10
int stack[MaxSize];
int top = -1;
void Push(int value)
{
	int i;
	if (top >= MaxSize)
		printf("\nThe stack is full!\n");
	else
	{
		printf("\nThe stack content before(top->bottom):");
		for (i = top; i >= 0; i--)
			printf("[%d]", stack[i]);
		top++;
		stack[top] = value;
		printf("\nThe stack content before(top->bottom):");
		for (i = top; i >= 0; i--)
			printf("[%d]", stack[i]);
		printf("\n");
	}
}
int pop()
{
	int temp;
	int i;
	if (top < 0)
	{
		printf("\nThe stack is empty!\n");
		return -1;
	}
	printf("\nThe stack content before(top->bottom):");
	for (i = top; i >= 0; i--)
		printf("[%d]", stack[i]);
	temp = stack[top];
	top--;
	printf("\nThe pop value is [%d]", temp);
	printf("\nThe stack content after pop(top->bottom):");
	for (i = top; i >= 0; i--)
		printf("[%d]", temp);
	printf("\n");
	return temp;
}
void main()
{
	int select;
	int value;
	printf("\n[1]Input a stack data");
	printf("\n[2]Output a stack data");
	printf("\n[3]Exit");
	printf("\nPlease select one =>");
	scanf("%d", &select);
	do
	{
		switch (select)
		{
		case 1:
			printf("\nPlease input the data=>");
			scanf("%d", &value);
			Push(value);
			break;
		case 2:
			value = pop();
			break;
		}
		printf("\n[1]Input a stack data");
		printf("\n[2]Output a stack data");
		printf("\n[3]Exit");
		printf("\nPlease select one =>");
		scanf("%d", &select);
		printf("\n");
	} while (select != 3);
	system("pause");
}
