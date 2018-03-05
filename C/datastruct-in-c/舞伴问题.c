#include <stdio.h>
#include <stdlib.h>
#define MAX_DANCERS 100		//最多跳舞人数
#define QueueSize 100		//假定预分配的队列空间最多为100个元素
typedef struct {
	char name[20];
	char sex;
}Person;
typedef Person DataType;
typedef struct {
	DataType data[QueueSize];
	int front;
	int rear;
	int count;
}CirQueue;
void Initial(CirQueue * Q);
int IsEmpty(CirQueue * Q);
void EnQueue(CirQueue * Q, DataType x);
DataType DeQueue(CirQueue * Q);
DataType Front(CirQueue * Q);
void DanceParther(Person dancer[], int num);

void main()
{
	Person dancer[MAX_DANCERS] = { { "a",'F' },{ "b",'M' },{ "c",'M' },{ "d",'F' }, {"e",'F'} };
	int n = 5;
	DanceParther(dancer, 5);
	system("pause");
}

//置队列空
void Initial(CirQueue * Q)
{
	Q->front = Q->rear = 0;
	Q->count = 0;
}
//判队列空
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
void EnQueue(CirQueue * Q, DataType x)
{
	if (IsFull(Q))
	{
		printf("the queue is full\n");
		exit(1);
	}
	Q->count++;
	Q->data[Q->rear] = x;
	Q->rear = (Q->rear + 1) % QueueSize;
}
//出队列
DataType DeQueue(CirQueue * Q)
{
	DataType temp;
	if (IsEmpty(Q))
	{
		printf("The queue is empty!\n");
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
		printf("The queue is empty!\n");
		exit(1);
	}
	return Q->data[Q->front];
}
//舞伴配对
void DanceParther(Person dancer[], int num)
{
	int i;
	Person p;
	CirQueue Mdancers, Fdancers;
	Initial(&Mdancers);
	Initial(&Fdancers);
	for (i = 0; i < num; i++) {
		p = dancer[i];
		if (p.sex == 'F')
			EnQueue(&Fdancers, p);
		else
			EnQueue(&Mdancers, p);
	}
	printf("舞队是:	 男	   女\n");
	while (!IsEmpty(&Mdancers) && !IsEmpty(&Fdancers)) {
		p = DeQueue(&Fdancers);
		printf("%10s", p.name);
		p = DeQueue(&Mdancers);
		printf("%10s\n", p.name);
	}
	if (!IsEmpty(&Fdancers)) {
		printf("还有%d个女士等下一轮.\n", Fdancers.count);
		p = Front(&Fdancers);
		printf("%s will be the first women to get a partner.\n", p.name);
	}
	else if (!IsEmpty(&Mdancers)) {
		printf("还有%d个男士等下一轮.\n", Mdancers.count);
		p = Front(&Mdancers);
		printf("%s will be the first man to get a partner.\n", p.name);
	}
}
