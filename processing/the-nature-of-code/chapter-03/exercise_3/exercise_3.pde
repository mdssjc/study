Car car;

void setup() {
  size(640, 360);
  car = new Car(width/2, height/2);
}

void draw() {
  background(255); 

  car.update();
  car.checkEdges();
  car.display();
}

void keyPressed() {
  if (key == CODED && keyCode == RIGHT) {
    car.turnLeft();
  }
  if (key == CODED && keyCode == LEFT) {
    car.turnRight();
  }
}