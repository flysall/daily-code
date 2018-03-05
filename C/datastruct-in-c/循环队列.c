#include <stdio.h>
#include <stdlib.h>
#define QueueSize 100
typedef char DataType;
typedef struct queue {
	DataType data[QueueSize];
	int front;
	int rear;
	int count;			//计数器，记录队列中元素总数
}CirQueue;
void Initial(CirQueue * Q);
int IsFull(CirQueue * Q);
int IsEmpty(CirQueue * Q);
void EnQueue(CirQueue * Q, DataType x);
DataType DeQueue(CirQueue * Q);
DataType Front(CirQueue *Q);
int main(void)
{
	CirQueue s;
	DataType first, sec;
	Initial(&s);
	EnQueue(&s, 'a');
	EnQueue(&s, 'b');
	first = Front(&s);
	printf("first = %c\n", first);
	DeQueue(&s);
	sec = Front(&s);
	printf("sec = %c\n", sec);
	DeQueue(&s);
	system("pause");
}
//置队列为空
void  Initial(CirQueue * Q)
{
	Q->front = Q->rear = 0;
	Q->count = 0;
}
//判队列为空
int IsEmpty(CirQueue * Q)
{
	return Q->front == Q->rear;
}
//判队列满
int IsFull(CirQueue * Q)
{
	return Q->rear == QueueSize - 1 + Q->front;
}
//进队列
void EnQueue(CirQueue *Q, DataType x)
{
	if (IsFull(Q))
	{
		printf("队列上溢");
		exit(1);
	}
	Q->count++;
	Q->data[Q->rear] = x;
	Q ->rear = (Q->rear + 1) % QueueSize;
}
//出队列
DataType DeQueue(CirQueue * Q)
{
	DataType temp;
	if (IsEmpty(Q))
	{
		printf("队列为空");
		exit(1);
	}
	temp = Q->data[Q->front];
	Q->count--;
	Q->front = (Q->front + 1) % QueueSize;
	return temp;
}
//取队顶元素
DataType Front(CirQueue * Q)
{
	if (IsEmpty(Q))
	{
		printf("队列为空");
		exit(1);
	}
	return Q->data[Q->front];
}