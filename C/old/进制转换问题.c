#include <stdio.h>
#include <stdlib.h>
#define StackSize 100
typedef int DataType;
typedef struct Stack {
	DataType data[StackSize];
	int top;
}SeqStack;
//÷√’ªø’
void Initial(SeqStack *S)
{
	S->top = -1;
}
//≈–’ªø’
int IsEmpty(SeqStack *S)
{
	return S->top == -1;
}
//≈–’ª¬˙
int IsFull(SeqStack *S)
{
	return S->top == StackSize;
}
//Ω¯’ª
void Push(SeqStack * S, DataType x)
{
	if (IsFull(S))
	{
		printf("’ª…œ“Á");
		exit(1);
	}
	S->data[++S->top] = x;
}
//≥ˆ’ª
DataType Pop(SeqStack * S)
{
	if (IsEmpty(S))
	{
		printf("’ªŒ™ø’");
		exit(1);
	}
	return S->data[S->top--];
}
//»°’ª∂•‘™Àÿ
DataType Top(SeqStack *S)
{
	if (IsEmpty(S))
	{
		printf("’ªŒ™ø’");
		exit(1);
	}
	return S->data[S->top];
}
void MultiBaseOutput(int N, int B)
{
	int i;
	SeqStack S;
	Initial(&S);
	while (N) {
		Push(&S, N%B);
		N = N / B;
	}
	while (!IsEmpty(&S)) {
		i = Pop(&S);
		printf("%d", i);
	}
}
void main()
{
	int N, B;
	printf("Input the number:");
	scanf("%d", &N);
	printf(" ‰»ÎΩ¯÷∆£∫");
	scanf("%d", &B);
	MultiBaseOutput(N, 2);
	system("pause");
}