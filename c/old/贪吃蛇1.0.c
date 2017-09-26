// Ã∞≥‘…ﬂ
// @version 1.0
// @auther 1: Climber_PG auther2: flysall

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

#define SNAKE_MAX_LENGTH 20
#define SNAKE_HEAD '@'
#define SNAKE_BODY '*'
#define BLANK_CALL ''
#define SNAKEFOOD '$'
#define WALL_CELL '*'

void clear_map(void);		//clear the map
void update_snake(void);	//update the map
void put_money(void);		//put a food randomized on a black cell
void snakeMove(int, int);	//snake stepping : dy = -1(up), 1(down); dx = -1(left), 1(right), 0(no move)
void output(void);			//out cells of grid
void gameover(void);		//outs when game is over

//initiate the map and snake
char map[12][12] = {
	"************",
	"*****@     *",
	"*			*",
	"*			*",
	"*	        *",
	"*		    *",
	"*		    *",
	"*	        *",
	"*	        *",
	"*  	    *",
	"*  	    *",
	"************"
};

//define variables for snake, notice of variable in C
int snakeX[SNAKE_MAX_LENGTH] = { 1, 2, 3, 4, 5 };		//snakeX[i] is xposition of snake in map
int snakeY[SNAKE_MAX_LENGTH] = { 1, 1, 1, 1, 1 };		//snakeY[i] is yposition of snake in map
int snakeLength = 5;		//the length of the snake
int score = 0, food_x = 0, food_y = 0;

int main()
{
	char ch;
	int flag = 1;
	put_money();
	output();
	while (flag) {
		ch = getch();
		switch (ch) {
		case 'a':
			snakeMove(-1, 0);
			system("CLS");
			output();
			break;
		case 'w':snakeMove(0, -1);
			system("CLS");
			output();
			break;
		case 's':snakeMove(0, 1);
			system("CLS");
			output();
			break;
		case 'd':
			snakeMove(1, 0);
			system("CLS");
			output();
			break;
		default:
			break;
		}
	}
	return 0;
}

//clear the map
void clear_map(void)
{
	int i, j;
	for (i = 1; i < 11; i++)
		for (j = 1; j < 11; j++)
			map[i][j] = ' ';
	return;
}

//update the map
void update_snake(void)
{
	int i;
	map[snakeY[snakeLength - 1]][snakeX[snakeLength - 1]] = '@';
	for (i = 0; i < snakeLength-1; i++)
		map[snakeY[i]][snakeX[i]] = '*';
	return;
}

//put a food randomized on a black cell
void put_money(void)
{
	update_snake();
	for (;;)
	{
		srand(time(NULL));
		food_x = rand() % 10 + 1;
		food_y = rand() % 10 + 1;
		if (map[food_x][food_y] == ' ')
			break;
	}
	map[food_x][food_y] = '$';		//put the food into the map
	return;
}
void snakeMove(int x, int y)
{
	int i;
	int check_x = snakeX[snakeLength - 1] - snakeX[snakeLength - 2];
	int check_y = snakeY[snakeLength - 1] - snakeY[snakeLength - 2];
	if (x != 0 && check_x == -x)
		return;			//snake can't go back
	if (y != 0 && check_y == -y)
		return;
	clear_map();
	map[food_x][food_y] = '$';
	int head_x = snakeX[snakeLength - 1] + x;
	int head_y = snakeY[snakeLength - 1] + y;
	if (map[head_y][head_x] == map[food_x][food_y])
	{
		snakeLength++;
		score++;
		snakeX[snakeLength - 1] = head_x;
		snakeY[snakeLength - 1] = head_y;
		if (snakeLength < SNAKE_MAX_LENGTH - 1)
			put_money();
	}
	else
	{
		for (i = 1; i < snakeLength; i++)
		{
			snakeX[i - 1] = snakeX[i];
			snakeY[i - 1] = snakeY[i];
		}
		snakeX[snakeLength - 1] += x;
		snakeY[snakeLength - 1] += y;
	}
	gameover();
	update_snake();
	return;
}

void output(void)
{
	int i, j;
	for (i = 0; i < 12; i++)
	{
		for (j = 0; j < 12; j++)
			printf("%c", map[i][j]);
		printf("\n");
	}
	return;
}
void gameover(void)
{
	int i, flag = 0;
	for (i = 0; i < snakeLength - 1; i++)
	{
		if (snakeX[snakeLength - 1] == snakeX[i] && snakeY[snakeLength - 1] == snakeY[i])		//the head bump into body
			flag = 1;
	}
	if (flag || snakeX[snakeLength - 1] < 1 || snakeX[snakeLength - 1]>10 || snakeY[snakeLength - 1] < 1 || snakeY[snakeLength - 1] > 10)
	{
		snakeLength = 5;
		clear_map();
		//initialize the coordinates of snake
		for (i = 0; i < snakeLength; i++)
		{
			snakeX[i] = i + 1;
			snakeY[i] = 1;
		}
		put_money();
		printf("Gameover!\nYour score is %d!\nPress any key to continue.\n", score);
		score = 0;
		getch();
	}
	return;
}