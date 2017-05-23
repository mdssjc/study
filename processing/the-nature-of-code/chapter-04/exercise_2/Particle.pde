class Particle {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float angle;
  float aVelocity;    
  float aAcceleration;
  float lifespan;

  Particle(PVector l) {
    location = l.copy();
    acceleration = new PVector();
    velocity = new PVector();
    angle = 0;
    aVelocity = 0.0;
    aAcceleration = 0.005;
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
    acceleration.mult(0);

    aVelocity += aAcceleration;
    angle += aVelocity;
  }

  void applyForce(PVector force) {
    PVector f = force.copy();
    acceleration.add(f);
  }

  void display() {
    stroke(0, lifespan);
    fill(0, lifespan);

    pushMatrix();
    translate(location.x, location.y);
    rotate(angle);

    triangle(0, 20, 10, 0, 20, 20);

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