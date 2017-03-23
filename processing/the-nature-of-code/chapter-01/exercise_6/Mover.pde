class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  float topspeed;
  float t;

  Mover() {
    location = new PVector(width/2, height/2);
    velocity = new PVector(0, 0);
    acceleration = new PVector(-0.001, 0.01);
    topspeed = 10;
    t = 0.0;
  }

  void update() {
    acceleration = PVector.random2D();
    acceleration.mult(map(noise(t), 0, 1, 0, random(2)));

    velocity.add(acceleration);
    velocity.limit(topspeed);
    location.add(velocity);

    t += 0.01;
  }

  void display() {
    stroke(0);
    fill(175);
    ellipse(location.x, location.y, 16, 16);
  }

  void checkEdges() {
    if (location.x > width) {
      location.x = 0;
    } else if (location.x < 0) {
      location.x = width;
    }

    if (location.y > height) {
      location.y = 0;
    } else if (location.y < 0) {
      location.y = height;
    }
  }
}