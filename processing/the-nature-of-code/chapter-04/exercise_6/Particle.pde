class Particle {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float lifespan;

  Particle(PVector l) {
    location = l.copy();
    acceleration = new PVector(0, 0.01);
    velocity = PVector.random2D();
    velocity.mult(0.5);
    lifespan = 255.0;
  }

  void run() {
    update();
    display();
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    lifespan -= 1.0;
  }

  void display() {
    stroke(0, lifespan);
    fill(0, lifespan);

    pushMatrix();
    translate(location.x, location.y);

    rect(0, 0, 10, 10);

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