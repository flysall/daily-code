#include <stdio.h>
#include <stdlib.h>
#define MAX_DANCERS 100		//�����������
#define QueueSize 100		//�ٶ�Ԥ����Ķ��пռ����Ϊ100��Ԫ��
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

//�ö��п�
void Initial(CirQueue * Q)
{
	Q->front = Q->rear = 0;
	Q->count = 0;
}
//�ж��п�
int IsEmpty(CirQueue * Q)
{
	return Q->front == Q->rear;
}
//�ж����� 
int IsFull(CirQueue * Q)
{
	return Q->rear == QueueSize - 1 + Q->front;
}
//������
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
//������
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
//ȡ�Ӷ�Ԫ��
DataType Front(CirQueue * Q)
{
	if (IsEmpty(Q))
	{
		printf("The queue is empty!\n");
		exit(1);
	}
	return Q->data[Q->front];
}
//������
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
	printf("�����:	 ��	   Ů\n");
	while (!IsEmpty(&Mdancers) && !IsEmpty(&Fdancers)) {
		p = DeQueue(&Fdancers);
		printf("%10s", p.name);
		p = DeQueue(&Mdancers);
		printf("%10s\n", p.name);
	}
	if (!IsEmpty(&Fdancers)) {
		printf("����%d��Ůʿ����һ��.\n", Fdancers.count);
		p = Front(&Fdancers);
		printf("%s will be the first women to get a partner.\n", p.name);
	}
	else if (!IsEmpty(&Mdancers)) {
		printf("����%d����ʿ����һ��.\n", Mdancers.count);
		p = Front(&Mdancers);
		printf("%s will be the first man to get a partner.\n", p.name);
	}
}
