#include <stdio.h>
#include <stdlib.h>
typedef char datatype;
typedef struct node {
	datatype data;
	struct node *next;
}listnode;
typedef listnode *linklist;
listnode *p;
linklist createlist(void)
{
	listnode *p;
	linklist head = NULL;
	char ch;
	printf("Input the value of node:");
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
linklist insertnode(linklist head, char x, int i)
{
	int j = 0;
	listnode *p = NULL, *s = NULL;
	p = head;
	while (j<i-1 && p) {
		p = p->next;
		j++;
	}
	if (j > i + 1 || !p)
		exit(0);
	s = (listnode*)malloc(sizeof(listnode));
	s->data = x;
	s->next = p->next;
	p->next = s;
	return 0;
}
int main()
{
	linklist list;
	char x = 'c';
	int i = 1;
	list = createlist();
	insertnode(list, x, i);
	p = list;
	do {
		printf("%c", p->data);
		p = p->next;
	} while (p != NULL);
	printf("\n");
	system("pause");
	return 0;
}
