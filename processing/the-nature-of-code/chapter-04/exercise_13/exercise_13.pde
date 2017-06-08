ParticleSystem ps;

void setup() {
  size(640, 360, P2D);

  ps = new ParticleSystem(new PVector(width/2, height));
}

void draw() {
  blendMode(ADD);
  background(0);

  ps.addParticle();
  ps.run();
}