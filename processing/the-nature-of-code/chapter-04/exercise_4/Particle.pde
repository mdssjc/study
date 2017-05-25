class Particle {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float lifespan;

  Particle(PVector l, PVector a) {
    location = l.copy();
    velocity = PVector.random2D();
    acceleration = a.copy();
    lifespan = 255.0;
  }

  void run() {
    update();
    display();
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    lifespan -= 2.0;
  }

  void display() {
    stroke(0, lifespan);
    fill(0, lifespan);

    pushMatrix();
    translate(location.x, location.y);

    point(0, 0);

    popMatrix();
  }

  boolean isDead() {
    if (lifespan < 0.0) {
      return true;
    } else {
      return false;
    }
  }
}