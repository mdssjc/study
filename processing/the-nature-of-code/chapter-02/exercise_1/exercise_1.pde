Mover mover;
PVector wind;
float xoff = 0.0;

void setup() {
  size(640, 360);
  mover = new Mover();
}

void draw() {
  background(255);
  
  wind = new PVector(map(noise(xoff), 0, 1, -0.005, 0.005), 0);
  mover.applyForce(wind);
  mover.applyForce(new PVector(0, -0.001));

  mover.update();
  mover.display();

  xoff += 0.01;
}