class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float angle;
  float mass;

  Mover(float m, float x, float y, float a) {
    mass = m * 16;
    angle = a;
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
    strokeWeight(2);
    fill(127, 200);

    pushMatrix();
    translate(location.x, location.y);
    rotate(-angle);
    rect(-mass, -mass, mass, mass);
    popMatrix();
  }

  void checkEdges() {
    float r = sqrt(sq(location.x) + sq(height - location.y));
    float x = cos(angle) * r;
    float y = height - sin(angle) * r;

    strokeWeight(10);
    point(x, y);
    strokeWeight(2);

    if (location.y >= y) {
      location.y = y;
    }
  }
}