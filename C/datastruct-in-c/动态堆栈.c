#include <stdio.h>
#include <stdlib.h>
typedef   char  datatype;
typedef	 struct	node {
	datatype	 data;
	struct 	node  *next;
} stack;
//������ջ
stack *creat(void)
{
	char ch;
	stack *  head;
	stack *p;
	head = NULL;/*��ʼ��Ϊ��*/
	ch = getchar();
	while (ch != '\n') {
		p = (stack*)malloc(sizeof(stack));/*����ռ�*/
		p->data = ch;/*������ֵ*/
		p->next = head;/*ָ�����ָ��*/
		head = p;/*headָ��ָ�����²���Ľ����*/
		ch = getchar();
	}
	return (head);
}
//��ջ�ÿ�
void MakeNull(stack *s)/*ʹջsΪ��*/
{
	stack *p = s;
	while (s != NULL) {
		s = s->next;
		free(p);/*�ͷſռ�*/
		p = s;
	}
}
//����ջ��Ԫ��
datatype Top(stack *s)
{
	if (Empty(s) == 1)/*sΪ��ջ��ֱ����������ʾ������Ϣ*/
		printf("The stack is empty.");
	else
		return s->data;
}
//ɾ��ջ��Ԫ��
stack *Pop(stack *s)
{
	stack *p;
	if (Empty(s) == 1) /*sΪ��ջ��ֱ����������ʾ������Ϣ*/
		printf("The stack is empty.");
	else {
		p = s;
		s = s->next;
		free(p);/*�ͷ�ջ���ռ�*/
	}
	return s;
}
//��Ԫ�ز���s��ջ��
stack *Push(stack *s, datatype x)
{
	stack *p;
	p = (stack*)malloc(sizeof(stack));
	p->data = x;
	p->next = s;
	s = p;
	return s;
}
//�ж�ջ�Ƿ�Ϊ��
int Empty(stack *s)
{
	int ret = 0;
	if (s == NULL)
	{
		ret = 1;
	}
	else
		ret = 0;
	return ret;
}
//��ӡ����
void Print(stack *s)
{
	do {
		printf("%4c", s->data);
		s = s->next;
	} while (s != NULL);

	printf("\n");
}
void main()
{
	printf("Input the value in a order:\n");
	stack*	m_stack;
	m_stack = creat();
	printf("before pop, the stack is:");
	Print(m_stack);
	char	m_top;
	if (Empty(m_stack) == 0)
	{
		m_top = Top(m_stack);
		printf("the top is %c\n", m_top);
		m_stack = Pop(m_stack);
		printf("after pop,the stack is:");
		Print(m_stack);
		m_stack = Push(m_stack, 't');
		printf("after push,the stack is:");
		Print(m_stack);
	}
	MakeNull(m_stack);
	system("pause");
	return 0;
}
