class Bob {

  PVector position;
  float mass;

  Bob(float x, float y) {
    position = new PVector(x, y);
    mass = 12;
  }

  void update(float p) {
    position.y = p;
  }

  void display() { 
    stroke(0);
    strokeWeight(2);
    fill(175);

    ellipse(position.x, position.y, mass*2, mass*2);
  }
}