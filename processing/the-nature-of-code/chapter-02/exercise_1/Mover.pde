class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;

  Mover() {
    location = new PVector(width/2, height);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0.01);
  }

  void update() {
    velocity.add(acceleration);
    location.add(velocity);
    acceleration.mult(0);
  }

  void display() {
    stroke(0, 102, 204);
    fill(0, 128, 255);
    ellipse(location.x, location.y, 30, 50);
  }

  void applyForce(PVector force) {
    acceleration.add(force);
  }

  void checkEdges() {  
    if (location.x > (width + 15)) {
      location.x = (width + 15);
    } else if (location.x < 15) {
      location.x = 15;
    }

    if (location.y > (height - 25)) {
      location.y = (height - 25);
    } else if (location.y < 25) {
      location.y = 25;
    }
  }
}