#define CHAR 1
#if CHAR
typedef char TElemType;
TElemType Nil = ' ';		//�ַ�����ո�Ϊ��
#else
typede int TelemType;
TElemType Nil = '0';
#endif
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define TRUE 1
#define FLASE 0
#define OK 1
#define ERROR 0	
typedef int Status;		//
typedef enum { Link, Thread } PointerTag;		//ö�� ��Link��ָ��  Thread��������


typedef struct BiThrNode
{
	TElemType data;
	struct BiThrNode * lchild, *rchild;
	PointerTag LTag, RTag;		//���ұ�־
}BiThrNode, *BiThrTree;


/* ��������������������н���ֵ,�������������T */
/* 0(����)/�ո�(�ַ���)��ʾ�ս�� */
Status CreateBiThrTree(BiThrTree * T)
{
	TElemType h;
#ifdef CHAR
	scanf("%c", &h);
#else
	scanf("%d", &h);
#endif
	if (h == Nil)
		*T = NULL;
	else
	{
		*T = (BiThrTree)malloc(sizeof(BiThrNode));
		if (!*T)
			exit(OVERFLOW);
		(*T)->data = h;
		CreateBiThrTree(&(*T)->lchild);		//�ݹ鹹��������
		if ((*T)->lchild)
			(*T)->LTag = Link;
		CreateBiThrTree(&(*T)->rchild);	//�ݹ鹹��������	
		if ((*T)->rchild)
			(*T)->RTag = Link;
	}
	return OK;
}

BiThrTree pre;		//ȫ�ֱ�����ʼ��ָ��ոշ��ʹ��Ľڵ�

//�����������������������
void InThreading(BiThrTree p)
{
	if (p)
	{
		InThreading(p->lchild);		/* �ݹ������������� */
		if (!p->lchild)
		{
			p->LTag = Thread;
			p->lchild = pre;		
		}
		if (!pre->rchild)
		{
			pre->RTag = Thread;
			pre->rchild = p;
		}
		pre = p;		
		InThreading(p->rchild);	//�ݹ�������������
	}
}


//�������������T,����������������,Thrtָ��ͷ��㡣
Status InOrderThreading(BiThrTree *Thrt, BiThrTree T)
{
	*Thrt = (BiThrNode*)malloc(sizeof(BiThrNode));
	if (!*Thrt)
		exit(OVERFLOW);
	(*Thrt)->LTag = Link;		 /* ��ͷ��� */
	(*Thrt)->RTag = Thread;
	(*Thrt)->rchild = *Thrt;
	if (!T)
		(*Thrt)->lchild = *Thrt;
	else
	{
		(*Thrt)->lchild = T;
		pre = *Thrt;
		InThreading(T);
		pre->rchild = *Thrt;
		pre->RTag = Thread;
		(*Thrt)->rchild = pre;
	}
	return OK;
}


// �����������������T(ͷ���)�ķǵݹ��㷨��
Status InOrderTraverse_Thr(BiThrTree T, Status(*Visit)(TElemType))
{
	BiThrTree  p;
	p = T->lchild;
	while (p != T)
	{
		while (p->LTag == Link)
			p = p->lchild;
		if (!(Visit(p->data)))
			return ERROR;
		while (p->RTag == Thread && p->rchild != T)
		{
			p = p->rchild;
			Visit(p->data);
		}
		p = p->rchild;
	}
	return OK;
}

Status vi(TElemType c)
{
#if CHAR	
	printf("%2c", c);
#else 
	printf("%2d", c);
#endif
	return OK;
}

int main(void)
{
	BiThrTree H, T;
#if CHAR	
	printf("�밴�������������(��:ab�����ո��ʾaΪ�����,bΪ�������Ķ�����)\n");
#else
	printf("�밴�������������(��:1 2 0 0 0��ʾ1Ϊ�����,2Ϊ�������Ķ�����)\n");
#endif
	CreateBiThrTree(&T);
	InOrderThreading(&H, T);
	printf("�������(���)����������:\n");
	InOrderTraverse_Thr(H, vi);
	printf("\n");
	system("pause");
}