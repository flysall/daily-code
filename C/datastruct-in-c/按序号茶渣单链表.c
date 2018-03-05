#include <stdio.h>
#include <stdlib.h>
typedef char datatype;
typedef struct node {
	datatype data;
	struct node *next;
}listnode;
typedef listnode *linklist;
listnode *p;
linklist createlist()         //头插法建立链表
{
	linklist head = NULL;
	char ch = '\n';
	listnode *p;
	ch = getchar();
	while (ch != '\n') {
		p = (listnode*)malloc(sizeof(listnode));
		p->data = ch;
		p->next = head;
		head = p;
		ch = getchar();
	}
	return head;
}
linklist getnode(linklist head, int i)     //遍历链表
{
	int j=0;
	p = head;
	while (j < i && p->next != NULL) {
		p = p->next;
		j++;
	}
	if (j == i) {
		printf("%c\n", p->data);
		return p;
	}
	else
		return NULL;
}
int main()
{
	linklist list;
	int i;
	list = createlist();
	printf("Input the number of the node:");
	scanf("%d", &i);
	getnode(list, i);
	system("pause");
	return 0;
}