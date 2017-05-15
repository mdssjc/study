Bob bob;

void setup() {
  size(640, 360);

  bob = new Bob(width/2, 20);
}

void draw() {
  background(255);

  float period = 120;
  float x = sin(TWO_PI * frameCount / period);
  float pos = map(x, -1, 1, 20, 200);

  bob.update(pos);
  bob.display();
}