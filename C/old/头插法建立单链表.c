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
		p->next = head;  //ָ����ָ��
		head = p;  //*headָ��ָ�����²���Ľڵ���
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