#include <stdio.h>
#include <stdlib.h>
typedef   char  datatype;
typedef	  struct	node {
	datatype	  data;
	struct 	node  *next;
} listnode;
typedef  listnode  *linklist;
listnode  *p;
linklist  createlist(void)
{
	char ch;
	linklist  head;
	listnode  *p;
	head = NULL;/*初始化为空*/
	printf("%p\n", head);
	ch = getchar();
	printf("%p\n", ch);
	while (ch != '\n') {
		p = (listnode*)malloc(sizeof(listnode));/*分配空间*/
		printf("%p\n", p);
		p->data = ch;/*数据域赋值*/
		p->next = head;/*指定后继指针*/
		head = p;/*head指针指定到新插入的结点上*/
		//printf("%p\n", head);
		//printf("%p\n", p->next);
		ch = getchar();
	}
	return (head);
}
int main()
{
	linklist newlist = createlist();
	do
	{
		printf("%c\n", newlist->data);
		newlist = newlist->next;
	} while (newlist != NULL);
	printf("\n");
	system("pause");
	return 0;
}