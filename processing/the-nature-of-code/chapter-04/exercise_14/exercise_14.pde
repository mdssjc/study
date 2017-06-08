ParticleSystem ps;

void setup() {
  size(640, 360, P2D);

  ps = new ParticleSystem(new PVector(width/2, height));
}

void draw() {
  //blendMode(ADD);
  //blendMode(SUBTRACT);
  //blendMode(LIGHTEST);
  //blendMode(DARKEST);
  blendMode(DIFFERENCE);
  //blendMode(EXCLUSION);
  //blendMode(MULTIPLY);
  background(0);

  ps.addParticle();
  ps.run();
}