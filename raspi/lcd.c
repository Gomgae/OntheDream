#include <wiringPi.h>
#include <lcd.h>

//					LCD pin 1 > GND
//					LCD pin 2 > VCC 3.3v
//					LCD pin 3 > GND
#define rs 29 // LDC pin 4 > BCM. 21, wPi. 29, physical.40
//					LCD pin 5 > GND
#define en 28 // LCD pin 6 > GND
//					LCD pin 7 > x
//					LCD pin 8 > x
//					LCD pin 9 > x
//					LCD pin 10 > x
#define d4 27 //	LCD pin 11 > BCM, 16, wPi. 27, physical, 36
#define d5 26 //	LCD pin 12 > BCM. 12, wPi. 26 physical. 32
#define d6 31 //	LCD pin 13> BCM. 31, physical. 28
#define d7 11 //	LCD pin 14 > BCM. 7, wPi. 11, physical. 26
//					LCD pin 15 > VCC 3.3v
//					LCD pin 16 > GND

void StaticMessage(int lcd, char start, char line, char *message){
	lcdPosition(lcd, start, line);
	lcdPuts(lcd, message);
}

void ScrollRight(int lcd, char *message, char *message2){
	for(char i=0; i<10; i++) {
		lcdClear(lcd);
		lcdPosition(lcd,i,0);
		lcdPuts(lcd,message);
		lcdPosition(lcd,i,1);
		lcdPuts(lcd,message2);
		delay(100);
	}
}

void ScrollLeft(int lcd, char *message, char *message2){
	for(char i=0;i<10;i++){
		lcdClear(lcd);
		lcdPosition(lcd,9-i,0);
		lcdPuts(lcd,message);
		lcdPosition(lcd,9-i,1);
		lcdPuts(lcd,message2);
		delay(100);
	}
}

void LcdEnd(int lcd, char start, char line, char *message){
	lcdPosition(lcd,start,line);
	lcdPuts(lcd,message);
	delay(3000);
	lcdClear(lcd);
}

int main(void){
	if(wiringPiSetup()==-1){ return 1;}
	int lcd = lcdInit(2,16,4,rs,en,d4,d5,d6,d7,0,0,0,0);
	
	StaticMessage(lcd,0,0,"Hello World!");
	StaticMessage(lcd,0,1,"Connected!");
	delay(3000);
	ScrollRight(lcd,"Scroll","right");
	delay(1000);
	lcdClear(lcd);
	ScrollLeft(lcd,"Scroll","left");
	delay(1000);
	lcdClear(lcd);
	LcdEnd(lcd,6,0,"Bye!");
	return 0;
	}
