class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float mass;

  Mover() {
    mass = 1;
    location = new PVector(width/2, height);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0.01);
  }

  Mover(float m, float x, float y) {
    mass = m;
    location = new PVector(x, y);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
  }

  void applyForce(PVector force) {
    PVector f = PVector.div(force, mass);
    acceleration.add(f);
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);
  }

  void display() {
    stroke(0);
    fill(175);
    ellipse(location.x, location.y, mass*16, mass*16);
  }

  void checkEdges() {
    PVector f = new PVector(0, 0);

    if (location.x < (width * 0.1)) {
      f.add(map(location.x, 0, (width * 0.3), 0.3, 0.1), 0);
    } else if (location.x > (width * 0.9)) {
      f.add(map(location.x, width, (width * 0.7), -0.3, -0.1), 0);
    }

    if (location.y < (height * 0.1)) {
      f.add(0, map(location.y, 0, (height * 0.1), 0.3, 0.1));
    } else if (location.y > (height * 0.9)) {
      f.add(0, map(location.y, height, (height * 0.9), -0.3, -0.1));
    }

    applyForce(f);
  }
}