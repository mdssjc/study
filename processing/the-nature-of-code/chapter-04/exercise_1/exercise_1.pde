Particle p;

void setup() {
  size(640, 360);
  p = new Particle(new PVector(width/2, 50));
}

void draw() {
  background(255);

  p.run();
  p.applyForce(new PVector(random(-2, 2), 0.1));

  if (p.isDead()) {
    println("Particle dead!");
  }
}