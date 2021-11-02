int leds[3] = {2,3,4};
bool ledsSW[sizeof(leds)/2] = {false,false,false};
void setup() {
  // put your setup code here, to run once:
  
  Serial.begin(9600);
  for(int i = 0; i < sizeof(leds)/2; ++i){
    pinMode(leds[i], OUTPUT);
  }
}

void loop() {
  // put your main code here, to run repeatedly:
  int serial_data = Serial.read();
  for(int i = 0; i < sizeof(leds)/2; ++i){
      if(serial_data == 50+i && ledsSW[i] == false){
        digitalWrite(leds[i], HIGH);   
        Serial.println(i+2);
        ledsSW[i] = true;
      }else if(serial_data == 50+i && ledsSW[i] == true){
        digitalWrite(leds[i], LOW);
        Serial.println(i+2);
        ledsSW[i] = false;
      }
    
  }
  
}
