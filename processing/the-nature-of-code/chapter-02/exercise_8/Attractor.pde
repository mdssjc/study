class Attractor {

  float mass;
  PVector location;
  float G;
  boolean visible;

  Attractor(float m, float x, float y, boolean v) {
    mass = m;
    location = new PVector(x, y);
    G = 0.4;
    visible = v;
  }

  PVector attract(Mover m) {
    PVector force = PVector.sub(location, m.location);
    float distance = force.mag();
    distance = constrain(distance, 5.0, 25.0);
    force.normalize();

    float strength = (G * mass * m.mass) / (distance * distance);
    force.mult(strength);
    return force;
  }

  void display() {
    if (visible) {
      stroke(0);
      fill(175, 200);
    } else {
      stroke(0, 10);
      noFill();
    }
    ellipse(location.x, location.y, mass*2, mass*2);
  }
}