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
	head = NULL;/*��ʼ��Ϊ��*/
	printf("%p\n", head);
	ch = getchar();
	printf("%p\n", ch);
	while (ch != '\n') {
		p = (listnode*)malloc(sizeof(listnode));/*����ռ�*/
		printf("%p\n", p);
		p->data = ch;/*������ֵ*/
		p->next = head;/*ָ�����ָ��*/
		head = p;/*headָ��ָ�����²���Ľ����*/
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