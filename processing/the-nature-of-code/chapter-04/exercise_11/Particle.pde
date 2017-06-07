class Particle {

  PVector location;
  PVector velocity;
  PVector acceleration;

  float lifespan;
  PImage img;

  Particle(PVector l) {
    acceleration = new PVector(0, 00);
    float vx = randomGaussian() * 0.3;
    float vy = randomGaussian() * 0.3 - 1.0;
    velocity = new PVector(vx, vy);
    location = l.copy();

    lifespan = 255.0;
    img = loadImage("data/fire.png");
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