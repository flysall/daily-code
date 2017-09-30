#include <stdio.h>
#include <stdlib.h>
#define N 4
typedef char datatype;
typedef struct node {
	datatype data;
	struct data *next;
}listnode;
typedef listnode *linklist;
linklist creater()
{
	linklist head = NULL;
	listnode *p, *r;
	char ch;
	r = NULL;			//rÎªÎ²Ö¸Õë
	ch = getchar();
	while (ch != '\n') {
		p = (listnode*)malloc(sizeof(listnode));
		p->data = ch;
		if (head == NULL) {
			head = p;
			r = head;
		}
		else {
			r->next = p;
			r = r->next;
		}
		ch = getchar();
	}
	if (ch != NULL)
		r->next = NULL;
	return head;
}
int main()
{
	linklist newlist;
	newlist = creater();
	do {
		printf("%c", newlist->data);
		newlist = newlist->next;
	} while (newlist != NULL);
	printf("\n");
	system("pause");
	return 0;
}
