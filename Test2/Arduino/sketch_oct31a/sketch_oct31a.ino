int led1 = 2;
int led2 = 3;
int led3 = 4;

void setup() {
  // put your setup code here, to run once:
  
  Serial.begin(9600);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);

  Serial.println('b');

}

void loop() {
  // put your main code here, to run repeatedly:
  
  int serial_data = Serial.read();

  switch(serial_data){
    case (108):
    digitalWrite(led1, HIGH);
    digitalWrite(led2, HIGH);
    digitalWrite(led3, HIGH);
    Serial.println('l');
    break;
    case (100):
    digitalWrite(led1, LOW);
    digitalWrite(led2, LOW);
    digitalWrite(led3, LOW);
    Serial.println('d');
    break;
    
  }
  
}