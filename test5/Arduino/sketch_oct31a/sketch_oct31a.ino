#define max_buffer 15
char buffer_rx[max_buffer+1];
boolean chegou_comando = false;
boolean escrita = false;
boolean leitura = false;
void setup() {
  
  Serial.begin(9600);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  }
  //> 01 02 00 12 00 50 * 
void serialEvent(){
static unsigned char ch;
static int index_buf=0;

   ch = Serial.read();                         //Pega o caracter no registrador da UART.
   buffer_rx[index_buf] = ch;           //Guarda o caracter no buffer.

   if( buffer_rx[index_buf] == '*' ){   //Se é o fim da string de comando.
   
         buffer_rx[index_buf+1] = '\0'; //Finaliza a string.
         index_buf = 0;
         chegou_comando = true;         //Avisa que chegou uma string de comando.     
   }else{
         index_buf++;
         if(buffer_rx[3] == '0' && buffer_rx[4] == '2'){
              escrita = true; 
         }
         if(buffer_rx[3] == '0' && buffer_rx[4] == '1'){
              leitura = true; 
         }
   }

   if( (buffer_rx[0] != '>' ) || (index_buf >= max_buffer) ){
   
      index_buf = 0;
   }
    
}
void loop() {
    delay(100);
    for(int i = 0; i < max_buffer; i++){
       Serial.println(buffer_rx[i]);
    }
    if(leitura == true){

      digitalWrite(2, HIGH);
      
    }
    if(escrita == true){

      digitalWrite(3, HIGH);
      
    }
}
  
