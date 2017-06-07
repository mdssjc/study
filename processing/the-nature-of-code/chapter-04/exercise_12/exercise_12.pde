ParticleSystem ps;

void setup() {
  size(640, 360);

  ps = new ParticleSystem(new PVector(width/4, height/2));
}

void draw() {
  background(0);

  ps.addParticle();
  ps.run();
}