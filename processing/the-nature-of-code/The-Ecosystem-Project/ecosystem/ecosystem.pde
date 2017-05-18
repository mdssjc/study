Ball ball;

void setup() {
  size(800, 600);
  background(255);

  ball = new Ball(50, random(0, width), random(0, height));
}

void draw() {
  background(255);

  PVector wind = new PVector(0.01, 0);
  PVector gravity = new PVector(0, 0.1 * ball.mass);

  ball.applyForce(wind);
  ball.applyForce(gravity);

  ball.update();
  ball.display();
  ball.checkEdges();
}

void keyPressed() {
  if (key == CODED) {
    if (keyCode == LEFT) {
      ball.goLeft();
    }
    if (keyCode== RIGHT) {
      ball.goRight();
    }
  }
}