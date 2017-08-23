#include <stdio.h>
#include <stdlib.h>
typedef char datatype;
typedef struct node {
	datatype data;
	struct node *next;
}listnode;
typedef listnode *linklist;
listnode *p;
linklist createlist(voide)
{
	listnode *p;
	linklist head;
	head = NULL;
	char ch;
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

linklist locatenode(linklist head, char key)
{
	listnode *p = head;
	while (p->next && p->data != key) {
		p = p->next;
	}
	if (p != NULL) {
		printf("%c\n", p->data);
	}
	else
		printf("can't finf this node!\n");
	return p;
}

int main()
{
	linklist list;
	listnode *node;
	char key = 'c';
	list = createlist();
	printf("Input the key:");
	key = getchar();
	node = locatenode(list, key);
	system("pause");
	return 0;
}