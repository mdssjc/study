ParticleSystem ps;

void setup() {
  size(640, 360);
  ps = new ParticleSystem(new PVector(300, 100));
}

void draw() {
  background(255);
  ps.addParticle();
  ps.run();
}