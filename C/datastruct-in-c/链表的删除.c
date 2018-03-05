#include <stdio.h>
#include <stdlib.h>
typedef char datatype;
typedef struct node {
	datatype data;
	struct data *next;
}listnode;
typedef listnode *linklist;
listnode *p;
linklist createlist(void);
void deletelist(linklist head, int i);
int main()
{
	int i = 0;
	linklist list;
	list = createlist();
	printf("Input the number of node:");
	i = scanf("%d", &i);
	deletelist(list, i);
	do {
		printf("%c", list->data);
		list = list->next;
	} while (list != NULL);
	printf("\n");
	system("pause");
	return 0;
}
//头插法建立链表
linklist createlist(void)
{
	linklist head = NULL;
	char ch;
	listnode *p = NULL;
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
//删除第i个节点
void deletelist(linklist head, int i)
{
	int j = 0;
	listnode *p = head, *r = NULL;
	while (j < i - 1 && p) {
		p = p->next;
		j++;
	}
	if (!p->next || j > i - 1)
		exit(1);
	r = p->next;
	p->next = r->next;
	free(r);
}