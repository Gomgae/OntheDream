# 포함  < wiringPi.h >
# include  < lcd.h >

// 					LCD 핀 1> GND
// 					LCD 핀 2> VCC 3.3V
// 					LCD 핀 3> GND
# define  rs  29  // LDC 핀 4> BCM. 21, wPi. 29, 피 .40
// 					LCD 핀 5> GND
# 1 정의  EN  28  // LCD 핀 6> GND
// 					LCD 핀 7> x
// 					LCD 핀 8> x
// 					LCD 핀 9> x
// 					LCD 핀 10> x
# define  d4  27  // 	LCD 핀 11> BCM, 16, wPi. 27 세, 육체적 36 세
# define  d5  26  // 	LCD 핀 12> BCM. 12, wPi. 26 물리적. 32
# 정의  d6  31  // 	LCD 핀 13> BCM. 31, 육체적. 28
# define  d7  11  // 	LCD 핀 14> BCM. 7, wPi. 11, 육체적. 26 세
// 					LCD 핀 15> VCC 3.3V
// 					LCD 핀 16> GND

void  StaticMessage ( int lcd, char start, char 행, char * 메시지) {
	lcdPosition (lcd, start, line);
	lcdPuts (lcd, message);
}

void  ScrollRight ( int lcd, char * message, char * message2) {
	for ( char i = 0 ; i < 10 ; i ++) {
		lcdClear (lcd);
		lcdPosition (lcd, i, 0 );
		lcdPuts (lcd, message);
		lcdPosition (lcd, i, 1 );
		lcdPuts (lcd, message2);
		지연 ( 100 );
	}
}

void  ScrollLeft ( int lcd, char * message, char * message2) {
	for ( char i = 0 ; i < 10 ; i ++) {
		lcdClear (lcd);
		lcdPosition (lcd, 9 -i, 0 );
		lcdPuts (lcd, message);
		lcdPosition (lcd, 9 -i, 1 );
		lcdPuts (lcd, message2);
		지연 ( 100 );
	}
}

void  LcdEnd ( int lcd, char start, char 행, char * 메시지) {
	lcdPosition (lcd, start, line);
	lcdPuts (lcd, message);
	지연 ( 3000 );
	lcdClear (lcd);
}

int  main ( void ) {
	if ( wiringPiSetup () == - 1 ) { return  1 ;}
	int lcd = lcdInit ( 2 , 16 , 4 , rs, en, d4, d5, d6, d7, 0 , 0 , 0 , 0 );
	
	StaticMessage (lcd, 0 , 0 , " Hello World! " );
	StaticMessage (lcd, 0 , 1 , " Connected! " );
	지연 ( 3000 );
	ScrollRight (lcd, " Scroll " , " right " );
	지연 ( 1000 );
	lcdClear (lcd);
	ScrollLeft (lcd, " Scroll " , " left " );
	지연 ( 1000 );
	lcdClear (lcd);
	LcdEnd (lcd, 6 , 0 , " 안녕! " );
	 0을 반환 ;
	}
