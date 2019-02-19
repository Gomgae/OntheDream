#include <wiringPi.h>
#include <lcd.h>
#include <time.h>
#include <stdlib.h>
#include <stdint.h>
#define MAXTIMINGS    82
#define DHTPIN        7  //wPi pin. physical num 7
#include "lcdModuleWithDHT11.h"

#define rs 29
#define en 28
#define d4 27
#define d5 26
#define d6 31
#define d7 11

int main (void){
	if(wiringPiSetup() == -1){return 1;}
	int lcd = lcdInit(2, 16, 4, rs, en, d4, d5, d6, d7, 0,0,0,0);

	while(1){
		struct tm *date;
		const time_t t = time(NULL);
		date = localtime(&t);

		read_dht11_dat(lcd,date);

		delay(2000);
		lcdClear(lcd);
	}


}
