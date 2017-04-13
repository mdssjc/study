Ball ball;

void setup() {
  size(800, 600);
  background(255);
  
  ball = new Ball(20, random(0, width), random(0, height));
}

void draw() {
  ball.display();
}