#ifndef LCDMODULEWITHDHT11_H_
#define LCDMODULEWITHDHT11_H_



int dht11_dat[5] = { 0, 0, 0, 0, 0 };


void StaticMessage(int lcd, char start, char line, char *message){
	lcdPosition(lcd, start, line);
	lcdPuts(lcd, message);
}

void ScrollRight(int lcd, char *message, char *message2){
	for(char i = 0; i <10; i++){
		lcdClear(lcd);
		lcdPosition(lcd,i,0);
		lcdPuts(lcd, message);
		lcdPosition(lcd,i,1);
		lcdPuts(lcd, message2);
		delay(200);
	}
}


void ScrollLeft(int lcd, char *message, char *message2){
	for(char i = 0; i <10; i++){
		lcdClear(lcd);
		lcdPosition(lcd,9-i,0);
		lcdPuts(lcd, message);
		lcdPosition(lcd,9-i,1);
		lcdPuts(lcd, message2);
		delay(200);
	}
}

void LcdEnd(int lcd, char start, char line, char *message){
	lcdPosition(lcd,start,line);
	lcdPuts(lcd,message);
	delay(3000);
	lcdClear(lcd);
}


void read_dht11_dat(int lcd,struct tm *date)
{
    int laststate    = LOW;
    int counter        = 0;
    int j        = 0, i;
    float    f;

	dht11_dat[0] = dht11_dat[1] =dht11_dat[2] =dht11_dat[3] = dht11_dat[4] =0;
	pinMode( DHTPIN, OUTPUT );
	digitalWrite( DHTPIN, HIGH );
    delay( 50 );
    digitalWrite( DHTPIN, LOW );
    delay( 20 );
    digitalWrite( DHTPIN, HIGH );
    delayMicroseconds( 30 );
    pinMode( DHTPIN, INPUT );
	delayMicroseconds( 20 );

	for ( i = 0; i < MAXTIMINGS; i++ )
    {
        counter = 0;
        while ( digitalRead( DHTPIN ) == laststate )
        {
            counter++;

            delayMicroseconds( 1 );
            if ( counter == 255 )
            {
                break;
            }
        } //신호 길이 측정

        laststate = digitalRead( DHTPIN );

        if ( counter == 255 )
            break;

        if ( (i >= 3) && (i % 2 == 1) )
        {
            dht11_dat[j / 8] <<= 1;
            if ( counter > 50 )
                dht11_dat[j / 8] |= 1;
            j++;
        }
    }

	if ( (j >= 40) &&
         (dht11_dat[4] == ( (dht11_dat[0] + dht11_dat[1] + dht11_dat[2] + dht11_dat[3]) & 0xFF) ) )
    {
        f = dht11_dat[2] * 9. / 5. + 32;
        lcdPrintf(lcd, "H:%d.%d%% T:%d.%dC %d/%d %d:%d:%d",dht11_dat[0], dht11_dat[1], dht11_dat[2], dht11_dat[3], date->tm_mon + 1 , date->tm_mday , date->tm_hour , date->tm_min, date ->tm_sec );

	}else  {
        StaticMessage(lcd,0,0, "Data not good, skip\n" );
    }
}


#endif /* LCDMODULEWITHDHT11_H_ */
