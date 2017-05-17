class Bob {

  PVector position;
  PVector velocity;
  PVector acceleration;
  float mass = 24;
  float damping = 0.98;

  Bob(float x, float y) {
    position = new PVector(x, y);
    velocity = new PVector();
    acceleration = new PVector();
  } 

  void update() { 
    velocity.add(acceleration);
    velocity.mult(damping);
    position.add(velocity);
    acceleration.mult(0);
  }

  void applyForce(PVector force) {
    PVector f = force.copy();
    f.div(mass);
    acceleration.add(f);
  }

  void display() { 
    stroke(0);
    strokeWeight(2);
    fill(175);
    ellipse(position.x, position.y, mass*2, mass*2);
  }
}