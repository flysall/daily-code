#include <stdio.h>
#include <stdlib.h>
#define QueueSize 100
typedef char DataType;
typedef struct queue {
	DataType data[QueueSize];
	int front;
	int rear;
}SeqQueue;
void Initial(SeqQueue *Q);
int IsEmpty(SeqQueue *Q);
int IsFull(SeqQueue *Q);
void Push(SeqQueue *Q, DataType x);
DataType Top(SeqQueue *Q);
DataType Pop(SeqQueue *Q);
void main()
{
	SeqQueue s;
	DataType first, sec;
	Initial(&s);
	Push(&s, 'a');
	Push(&s, 'b');
	first = Top(&s);
	printf("frist = %c\n", first);
	Pop(&s);
	sec = Top(&s);
	printf("sec = %c\n", sec);
	Pop(&s);
	system("pause");
}
//置队列空
void Initial(SeqQueue *Q)
{
	Q->front = Q->rear = 0;
}
//判队列空
int IsEmpty(SeqQueue *Q)
{
	return Q->front == Q->rear;
}
//判队列满
int IsFull(SeqQueue *Q)
{
	return Q->rear == QueueSize - 1 + Q->front;
}
//进队列
void Push(SeqQueue *Q, DataType x)
{
	if (IsFull(Q)) {
		printf("队列上溢");
		exit(1);
	}
	Q->data[Q->rear++] = x;
}
//出队列
DataType Pop(SeqQueue *Q)
{
	if (IsEmpty(Q)) {
		printf("队列为空");
		exit(1);
	}
	return Q->data[Q->front++];
}
//返回队列顶元素
DataType Top(SeqQueue *Q)
{
	if (IsEmpty(Q)) {
		printf("队列为空");
		exit(1);
	}
	return Q->data[Q->front];
}

