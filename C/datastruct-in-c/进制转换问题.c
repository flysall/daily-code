#include <stdio.h>
#include <stdlib.h>
#define StackSize 100
typedef int DataType;
typedef struct Stack {
	DataType data[StackSize];
	int top;
}SeqStack;
//��ջ��
void Initial(SeqStack *S)
{
	S->top = -1;
}
//��ջ��
int IsEmpty(SeqStack *S)
{
	return S->top == -1;
}
//��ջ��
int IsFull(SeqStack *S)
{
	return S->top == StackSize;
}
//��ջ
void Push(SeqStack * S, DataType x)
{
	if (IsFull(S))
	{
		printf("ջ����");
		exit(1);
	}
	S->data[++S->top] = x;
}
//��ջ
DataType Pop(SeqStack * S)
{
	if (IsEmpty(S))
	{
		printf("ջΪ��");
		exit(1);
	}
	return S->data[S->top--];
}
//ȡջ��Ԫ��
DataType Top(SeqStack *S)
{
	if (IsEmpty(S))
	{
		printf("ջΪ��");
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
	printf("������ƣ�");
	scanf("%d", &B);
	MultiBaseOutput(N, 2);
	system("pause");
}