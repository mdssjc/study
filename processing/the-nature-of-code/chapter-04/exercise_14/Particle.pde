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
    tint(255, 0, 0);   // Red
    image(img, location.x, location.y-60);
    tint(255, 127, 0); // Orange
    image(img, location.x, location.y-50);
    tint(255, 255, 0); // Yellow
    image(img, location.x, location.y-40);
    tint(0, 255, 0);   // Green
    image(img, location.x, location.y-30);
    tint(0, 0, 255);   // Blue
    image(img, location.x, location.y-20);
    tint(75, 0, 130);  // Indigo
    image(img, location.x, location.y-10);
    tint(139, 0, 255); // Violet
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