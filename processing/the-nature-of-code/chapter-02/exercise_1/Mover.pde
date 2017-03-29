class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;

  Mover() {
    location = new PVector(width/2, height);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0.01);
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);
  }

  void display() {
    stroke(0, 102, 204);
    fill(0, 128, 255);
    ellipse(location.x, location.y, 30, 50);
  }

  void applyForce(PVector force) {
    acceleration.add(force);
  }
}