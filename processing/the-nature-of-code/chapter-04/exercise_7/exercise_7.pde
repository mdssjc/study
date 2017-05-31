Particle p;
Confetti c;

void setup() {
  size(640, 360);
  p = new Particle(new PVector(width/2, 50));
  c = new Confetti(new PVector(width/3, 50));
}

void draw() {
  background(255);

  p.run();
  c.run();
}