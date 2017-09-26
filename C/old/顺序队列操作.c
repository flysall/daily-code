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
//�ö��п�
void Initial(SeqQueue *Q)
{
	Q->front = Q->rear = 0;
}
//�ж��п�
int IsEmpty(SeqQueue *Q)
{
	return Q->front == Q->rear;
}
//�ж�����
int IsFull(SeqQueue *Q)
{
	return Q->rear == QueueSize - 1 + Q->front;
}
//������
void Push(SeqQueue *Q, DataType x)
{
	if (IsFull(Q)) {
		printf("��������");
		exit(1);
	}
	Q->data[Q->rear++] = x;
}
//������
DataType Pop(SeqQueue *Q)
{
	if (IsEmpty(Q)) {
		printf("����Ϊ��");
		exit(1);
	}
	return Q->data[Q->front++];
}
//���ض��ж�Ԫ��
DataType Top(SeqQueue *Q)
{
	if (IsEmpty(Q)) {
		printf("����Ϊ��");
		exit(1);
	}
	return Q->data[Q->front];
}

