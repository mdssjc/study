class Repeller {

  float strength;
  PVector location;
  float r;

  Repeller(float x, float y) {
    location = new PVector(x, y);
    strength = 100;
    r = 10;
  }

  void display() {
    stroke(200);
    fill(255);
    ellipse(location.x, location.y, r*2, r*2);
  }

  PVector repel(Particle p) {
    PVector dir = PVector.sub(location, p.location);
    float d = dir.mag();
    dir.normalize();
    d = constrain(d, 5, 100);
    float force = -1 * strength / (d * d);
    dir.mult(force);
    return dir;
  }
}