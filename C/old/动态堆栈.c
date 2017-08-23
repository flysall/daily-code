#include <stdio.h>
#include <stdlib.h>
typedef   char  datatype;
typedef	 struct	node {
	datatype	 data;
	struct 	node  *next;
} stack;
//创建堆栈
stack *creat(void)
{
	char ch;
	stack *  head;
	stack *p;
	head = NULL;/*初始化为空*/
	ch = getchar();
	while (ch != '\n') {
		p = (stack*)malloc(sizeof(stack));/*分配空间*/
		p->data = ch;/*数据域赋值*/
		p->next = head;/*指定后继指针*/
		head = p;/*head指针指定到新插入的结点上*/
		ch = getchar();
	}
	return (head);
}
//将栈置空
void MakeNull(stack *s)/*使栈s为空*/
{
	stack *p = s;
	while (s != NULL) {
		s = s->next;
		free(p);/*释放空间*/
		p = s;
	}
}
//返回栈顶元素
datatype Top(stack *s)
{
	if (Empty(s) == 1)/*s为空栈，直接跳出，提示出错信息*/
		printf("The stack is empty.");
	else
		return s->data;
}
//删除栈顶元素
stack *Pop(stack *s)
{
	stack *p;
	if (Empty(s) == 1) /*s为空栈，直接跳出，提示出错信息*/
		printf("The stack is empty.");
	else {
		p = s;
		s = s->next;
		free(p);/*释放栈顶空间*/
	}
	return s;
}
//把元素插入s的栈顶
stack *Push(stack *s, datatype x)
{
	stack *p;
	p = (stack*)malloc(sizeof(stack));
	p->data = x;
	p->next = s;
	s = p;
	return s;
}
//判断栈是否为空
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
//打印函数
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
