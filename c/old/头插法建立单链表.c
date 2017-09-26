#include <stdio.h>
#include <stdlib.h>
typedef char datatype;
typedef struct node {
	datatype data;
	struct data *next;
}listnode;
typedef listnode *linklist;
listnode *p;
linklist createlist(void)
{
	char ch;
	linklist head = NULL;
	listnode *p = NULL;
	ch = getchar();
	while (ch != '\n') {
		p = (listnode*)malloc(sizeof(listnode));
		p->data = ch;
		p->next = head;  //指定后指针
		head = p;  //*head指针指定到新插入的节点上
		ch = getchar();
	}
	return head;
}
int main()
{
	linklist head = NULL;
	head = createlist();
	do {
		printf("%c\n", head->data);
		head = head->next;
	} while (head != NULL);
	printf("\n");
	system("pause");
	return 0;
}