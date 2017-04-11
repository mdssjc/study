class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float mass;
  ArrayList<PVector> trail;
  int limit;

  Mover(float m, float x, float y) {
    mass = m;
    location = new PVector(x, y);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
    trail = new ArrayList();
    limit = 200;
  }

  void applyForce(PVector force) {
    PVector f = PVector.div(force, mass);
    acceleration.add(f);
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);

    if (trail.size() > limit) {
      trail.remove(0);
    }
    trail.add(new PVector(location.x, location.y));
  }

  void display() {
    stroke(0);
    strokeWeight(2);
    fill(127, 200);
    ellipse(location.x, location.y, mass*16, mass*16);

    noStroke();
    fill(127, 10);
    for (int i = 0; i < trail.size(); i++) {
      ellipse(trail.get(i).x, trail.get(i).y, mass*16, mass*16);
    }
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