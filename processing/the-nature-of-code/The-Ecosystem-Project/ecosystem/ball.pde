class Ball {

  final int COLOR = #3B58F5;

  PVector location;
  PVector velocity;
  PVector acceleration;
  float mass;

  Ball(float m, float x, float y) {
    mass = m;
    location = new PVector(x, y);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
  }

  void display() {
    stroke(0);
    strokeWeight(0);
    fill(COLOR);

    ellipse(location.x, location.y, mass, mass);
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