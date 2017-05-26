ParticleSystem ps;

void setup() {
  size(640, 360);
  ps = new ParticleSystem(new PVector(100, 50));
}

void draw() {
  background(255);
  ps.run();
}

void mousePressed() {
  ps.shatter();
}