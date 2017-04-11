class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float mass;
  float G;

  Mover(float m, float x, float y) {
    mass = m;
    location = new PVector(x, y);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
    G = 0.4;
  }

  void applyForce(PVector force) {
    PVector f = PVector.div(force, mass);
    acceleration.add(f);
  }

  PVector repel(Mover m) {
    PVector force = PVector.sub(location, m.location);
    float distance = force.mag();
    distance = constrain(distance, 5.0, 25.0);
    force.normalize();

    float strength = (G * mass * m.mass) / (distance * distance);
    force.mult(-strength);
    return force;
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);
  }

  void display() {
    stroke(0);
    strokeWeight(2);
    fill(127, 200);
    ellipse(location.x, location.y, mass*16, mass*16);
  }

  void checkEdges() {
    if (location.x > width) {
      location.x = 0;
    } else if (location.x < 0) {
      location.x = width;
    }

    if (location.y > height) {
      velocity.y *= -1;
      location.y = height;
    }
  }
}