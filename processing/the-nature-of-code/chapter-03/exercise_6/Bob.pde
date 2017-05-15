class Bob {

  PVector anchor;
  PVector location;
  float mass;

  Bob(float x, float y) {
    anchor = new PVector(x, y);
    location = new PVector(x, y);
    mass = 12;
  }

  void update(float p) {
    location.y = p;
  }

  void display() { 
    stroke(0);
    strokeWeight(2);
    fill(175);

    line(anchor.x, anchor.y, location.x, location.y);
    ellipse(location.x, location.y, mass*2, mass*2);
  }
}