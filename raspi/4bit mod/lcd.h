#define MAX_LODS

#ifdef __cplusplus
extern "c" {
#endif

extern void lcdHome (const int fd) ;
extern void lcdClear (const int fd) ;
extern void lcdDisplay (const int fd, int state) ;
extern void lcdCursor (const int fd, int state) ;
extern void lcdCursorBlink (const int fd, int state) ;
extern void lcdSendCommand (const int fd, unsigned char command) ;
extern void lcdPosition (const int fd,int x, int y) ;
extern void lcdCharDef (const int fd,int index , unsigned char data[8]) ;
extern void lcdPutchar (const int fd, unsigned char data) ;
extern void lcdPuts (const int fd, const char *strng) ;
extern void lcdPrintf (const int fd, const char *message, ...) ;

extern int lcdInit (const int rows, const int cols, const int bits, 
		const int rs, const int strb,
		const int d0, const int d1, const int d2, const int d3, const int d4,
		const int d5, const int d6, const int d7) ;

#ifdef __cplusplus
}
#endif
