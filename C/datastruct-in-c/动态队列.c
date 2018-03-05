#include <stdio.h>
#include <stdlib.h>
typedef char datatype;
typedef struct node {
	datatype data;
	struct node *next;
}position;
typedef struct queue {
	position *front;
	position *rear;
}queuetype;
//使队列为空
void MakeNull(queuetype *q)
{
	q->rear = q->front;
	while (q->front != NULL) {
		q->front = q->front->next;
		free(q->rear);	//释放空间
		q->rear = q->front;
	}
	q->front = (position*)malloc(sizeof(position));
	q->front->next = NULL;
	q->rear = q->front;
}
//取队列的队头元素
datatype Front(queuetype *q)
{
	if (Empty(q) == 1)
		printf("The queue is empty!\n");
	else
		return (q->front->next->data);
}
//删除队列头元素
void dequeue(queuetype *q)
{
	position *p;
	if (Empty(q) == 1)
		printf("The queue is empty!\n");
	else {
		p = q->front;
		q->front = q->front->next;
		free(p);
	}
}
//在队列中加入新元素
void Enqueue(datatype x,queuetype *q)
{
	position *p;
	p = (position*)malloc(sizeof(position));
	p->data = x;
	p->next = NULL;
	q->rear->next = p;
	q->rear = p;
}
//判断队列是否为空
int Empty(queuetype *q)
{
	int ret = 0;
	if (q->front == q->rear)
		ret = 1;
	else
		ret = 0;
	return ret;
}
//打印函数
void Print(queuetype *q)		
{
	position *p = NULL;
	if (Empty(q) == 1)
		printf("The queue is empty!\n");
	else
	{
		p = q->front->next;
		do {
			printf("%4c", p->data);
			p = p->next;
		} while (p != NULL);
	}
	printf("\n");
}
void main()
{
	char m_top, ch;
	queuetype *m_q = NULL;
	m_q = (queuetype*)malloc(sizeof(queuetype));
	m_q->front = m_q->rear = (position*)malloc(sizeof(position));
	m_q->rear->next = NULL;
	printf("Input the value:");
	ch = getchar();
	while (ch != '\n') {
		Enqueue(ch, m_q);
		ch = getchar();
	}
	printf("After Enqueue, the queue is:");
	Print(m_q);
	m_top = Front(m_q);
	printf("The top of queue is:");
	printf("%c\n", m_top);
	dequeue(m_q);
	printf("After dequeue, the queue is:");
	Print(m_q);
	MakeNull(m_q);
	system("pause");
}