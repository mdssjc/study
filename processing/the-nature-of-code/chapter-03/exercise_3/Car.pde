class Car {
  PVector position;
  PVector velocity;
  PVector acceleration;
  float angle;
  float angleStep;
  float topspeed;

  Car(float x, float y) {
    position = new PVector(x, y);
    velocity = new PVector();
    acceleration = new PVector();
    angle = 0;
    angleStep = 4;
    topspeed = 4;
  } 

  void update() { 
    velocity.add(acceleration);
    velocity.limit(topspeed);
    position.add(velocity);
    acceleration.mult(0);
  }

  void applyForce() {
    PVector dir = PVector.fromAngle(radians(angle));
    dir.normalize();
    dir.mult(0.5);
    acceleration = dir;
  }

  void turnLeft() {
    angle += angleStep;
    if (angle > 360) {
      angle = 0;
    }
    applyForce();
  }

  void turnRight() {
    angle -= angleStep;
    if (angle < 0) {
      angle = 359;
    }
    applyForce();
  }

  void display() {
    stroke(0);
    strokeWeight(2);
    fill(127);

    pushMatrix();

    rectMode(CENTER);
    translate(position.x, position.y);
    rotate(velocity.heading());
    rect(0, 0, 30, 10);

    popMatrix();
  }

  void checkEdges() {
    if (position.x > width) {
      position.x = 0;
    } else if (position.x < 0) {
      position.x = width;
    }

    if (position.y > height) {
      position.y = 0;
    } else if (position.y < 0) {
      position.y = height;
    }
  }
}