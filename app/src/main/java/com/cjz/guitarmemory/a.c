#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define PIN_MAX 12
#define PIN_MIN 0
#define STRING_MAX 6
#define STRING_MIN 1

/*TODO 某弦某品是什么音--答案 (弦，品)
(x,y)转为z，(x+y)+xy
打印0-12品多少个CDEFGAB
C (2,1)(5,3)(3,5)(6,8)(1,8)(4,10)和：3,8,14,9
D (4,0)(2,3)(5,5)(3,7)(1,10)(6,10)(4,12)和：4,5,10,11,16
E (1,0)(6,0)(4,2)(2,5)(5,7)(3,9)(1,12)(6,12)和：1,6,7,12,13,18
F (1,1)(6,1)(4,3)(2,6)(5,8)(3,10)和：2,7,8,13
G (3,0)(1,3)(6,3)(4,5)(2,8)(5,10)(3,12)和：3,4,9,10,15
A (5,0)(3,2)(1,5)(6,5)(4,7)(2,10)(5,12)和：5,6,11,12,17
B (2,0)(5,2)(3,4)(1,7)(6,7)(4,9)(2,12)和：2,7,8,13,14
other 带升降号的音，自己猜
*/

int main()
{

 	char key[7][13]={0};
 	key[2][1]=key[5][3]=key[3][5]=key[6][8]=key[1][8]=key[4][10]='C';
 	key[4][0]=key[2][3]=key[5][5]=key[3][7]=key[1][10]=key[6][10]=key[4][12]='D';
 	key[1][0]=key[6][0]=key[4][2]=key[2][5]=key[5][7]=key[3][9]=key[1][12]=key[6][12]='E';
 	key[1][1]=key[6][1]=key[4][3]=key[2][6]=key[5][8]=key[3][10]='F';
 	key[3][0]=key[1][3]=key[6][3]=key[4][5]=key[2][8]=key[5][10]=key[3][12]='G';
 	key[5][0]=key[3][2]=key[1][5]=key[6][5]=key[4][7]=key[2][10]=key[5][12]='A';
 	key[2][0]=key[5][2]=key[3][4]=key[1][7]=key[6][7]=key[4][9]=key[2][12]='B';

	int res_xian, res_pin;
	srand(time(NULL));/*初始化随机数种子*/

	printf("按下ESC之外的键显示答案，再按显示下一个测试，按ESC退出\n\n");
	while(1){
//		srand(time(NULL));/*初始化随机数种子*/
		printf("判断相应位置的音：");
		res_xian = rand()%(STRING_MAX+1-STRING_MIN)+STRING_MIN; /*生成一个[MIN,MAX]区间内的整数*/
		printf("%d弦 ",res_xian);
		res_pin = rand()%(PIN_MAX+1 - PIN_MIN)+PIN_MIN;
		printf("%d品 \n",res_pin);
		//	printf("%d, ",rand());
		if(_getch()==27){
			printf("quit....\n");
			break;
		}
		if(key[res_xian][res_pin]==0)
		    printf("答案：带升降号的音，自己猜\n");
		else printf("答案：%c\n",key[res_xian][res_pin]);
		printf("----------------------------------------\n");
	}

 	return 0;
}

