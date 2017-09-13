#include <stdio.h>
#include <stdlib.h>
typedef char DataType;		
typedef struct node {
	DataType data;
	struct node * next;
}QueueNode;
typedef struct {
	QueueNode *front;		//ͷָ��
	QueueNode *rear;		//βָ��
}LinkQueue;
void Initial(LinkQueue * Q);
int IsEmpty(LinkQueue * Q);
void Push(LinkQueue * Q, DataType x);
DataType Pop(LinkQueue * Q);
DataType Front(LinkQueue * Q);

int main(void)
{
	LinkQueue s;
	DataType first, sec;
	Initial(&s);
	Push(&s, 'a');
	Push(&s, 'b');
	first = Front(&s);
	Pop(&s);
	sec = Front(&s);
	printf("The first is %c\n", first);
	printf("The sec is %c\n", sec);
	Pop(&s);
	system("pause");
}
//�ö��п�
void Initial(LinkQueue * Q)
{
	Q->front = Q->rear = NULL;
}
//�ж��п�
int IsEmpty(LinkQueue * Q)
{
	return Q->front == NULL && Q->rear == NULL;
}
//������
void Push(LinkQueue * Q, DataType x)
{
	QueueNode * p;
	p = (QueueNode*)malloc(sizeof(QueueNode));
	p->data = x;
	p->next = NULL;
	if (IsEmpty(Q))
		Q->front = Q->rear = p;		//��x����ն���
	else {
		Q->rear->next = p;		//p���ӵ�ԭ����β�ڵ��
		Q->rear = p;			//����βָ��ָ���µĽڵ�
	}
}
//������
DataType Pop(LinkQueue * Q)
{
	DataType x;
	QueueNode * p;
	if (IsEmpty(Q))
	{
		printf("the queue is empty\n");
		exit(1);
	}
	p = Q->front;
	x = p->data;
	Q->front = p->next;
	if (Q->rear == p)
		Q->rear = NULL;
	free(p);
	return x;
}
//ȡ���ж�Ԫ��
DataType Front(LinkQueue * Q)
{
	if (IsEmpty(Q))
	{
		printf("The queue is empty!\n");
		exit(1);
	}
	return Q->front->data;
}