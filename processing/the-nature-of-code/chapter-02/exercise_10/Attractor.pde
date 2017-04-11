class Attractor {

  float mass;
  PVector location;
  float G;

  Attractor() {
    mass = 10;
    location = new PVector(mouseX, mouseY);
    G = 2;
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

  void update() {
    location = new PVector(mouseX, mouseY);
  }
}