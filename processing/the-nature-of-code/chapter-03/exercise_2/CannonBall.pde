class CannonBall { 
  PVector position;
  PVector velocity;
  PVector acceleration;
  float r = 8;
  float topspeed = 10;

  CannonBall(float x, float y) {
    position = new PVector(x, y);
    velocity = new PVector();
    acceleration = new PVector();
  } 

  void update() { 
    velocity.add(acceleration);
    velocity.limit(topspeed);
    position.add(velocity);
    acceleration.mult(0);
  }

  void applyForce(PVector force) {
    acceleration.add(force);
  }

  void display() { 
    stroke(0);
    strokeWeight(2);

    pushMatrix();

    translate(position.x, position.y);
    ellipse(0, 0, r*2, r*2);

    popMatrix();
  }
}