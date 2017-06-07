class Particle {

  PVector location;
  PVector velocity;
  PVector acceleration;

  PImage img;
  float lifespan;

  Particle(PVector l, PImage i) {
    acceleration = new PVector(0, 0);
    float vx = randomGaussian() * 0.3;
    float vy = randomGaussian() * 0.3 - 1.0;
    velocity = new PVector(vx, vy);
    location = l.copy();

    img = i;
    lifespan = 255.0;
  }

  void run() {
    update();
    render();
  }

  void applyForce(PVector force) {
    acceleration.add(force.copy());
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);

    lifespan -= 2.0;
  }

  void render() {
    tint(255, lifespan);
    image(img, location.x, location.y);
  }

  boolean isDead() {
    if (lifespan < 0.0) {
      return true;
    } else {
      return false;
    }
  }
}