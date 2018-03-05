#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h>
int main(void)
{
	int i, j;
	int x = 3;
	int y = 5;
	char input;
	int isFire = 1;
	int score = 0;
	int nx;	//
	int isKilled;
	char ch = 'y';
	while(ch == 'y')
	{
		isKilled = 0;
		while (isKilled == 0) {
			nx = rand() % 10 + 4;
			system("cls");	//
			if (isKilled == 0)
			{
				for (j = 0; j < nx; j++)
					printf(" ");
				printf("+\n");
			}
			if (isFire == 0)		//
			{
				for (i = 0; i < x; i++)
					printf("\n");
			}
			else
			{
				for (i = 0; i < x; i++)
				{
					for (j = 0; j < y; j++)
						printf(" ");
					printf("  |\n");

				}
				if (y + 2 == nx) {
					isKilled = 1;
					score++;
				}
				isFire = 0;
			}
			for (j = 0; j < y; j++)
				printf(" ");
			printf("  *\n");
			for (j = 0; j < y; j++)
				printf(" ");
			printf("*****\n");
			for (j = 0; j < y; j++)
				printf(" ");
			printf(" * *\n");

			if (kbhit())
			{
				input = getch();
				if (input == 'a')
					y--;
				if (input == 'd')
					y++;
				if (input == 'w')
					x--;
				if (input == 's')
					x++;
				if (input == ' ')
					isFire = 1;
			}
	}
	printf("Do you want to continue?\n");
	ch = getch();
	}
	printf("Your score is %d\n", score);
	system("pause");
} 