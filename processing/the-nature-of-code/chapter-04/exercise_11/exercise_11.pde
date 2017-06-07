ParticleSystem ps;

void setup() {
  size(640, 360);

  ps = new ParticleSystem(new PVector(width/2, height-10));
}

void draw() {
  background(0);

  ps.addParticle();
  ps.run();
}