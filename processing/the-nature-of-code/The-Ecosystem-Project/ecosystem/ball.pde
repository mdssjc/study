class Ball {

  final int   COLOR = #3B58F5;
  final float STEP  = 0.1;

  PVector position;
  PVector velocity;
  PVector acceleration;
  float mass;

  Ball(float m, float x, float y) {
    mass = m;
    position = new PVector(x, y);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
  }

  void applyForce(PVector force) {
    PVector f = PVector.div(force, mass);
    acceleration.add(f);
  }

  void update() {
    velocity.add(acceleration);
    position.add(velocity);
    acceleration.mult(0);
  }

  void goLeft() {
    acceleration.x -= STEP;
  }

  void goRight() {
    acceleration.x += STEP;
  }

  void display() {
    stroke(0);
    strokeWeight(2);

    float wing_l = 0;
    float wing_r = 0;
    float body   = 0;

    if (velocity.y <= 0) {
      wing_l = radians(-20);
      wing_r = radians(40);
      body   = wing_l;
    } else {
      wing_l = 0;
      wing_r = 0;
      body   = 0;
    }

    pushMatrix();
    translate(position.x, position.y);

    rotate(wing_l);
    fill(#FFFFFF);
    ellipse(-mass/2, -10, mass, mass * 0.3);

    rotate(wing_r);
    fill(#FFFFFF);
    ellipse(mass/2, -10, mass, mass * 0.3);

    rotate(body);
    fill(COLOR);
    ellipse(0, 0, mass, mass);

    popMatrix();
  }

  void checkEdges() {
    if (position.x > width) {
      position.x = 0;
    } else if (position.x < 0) {
      position.x = width;
    }

    if (position.y > height) {
      velocity.y *= -0.95;
      position.y = height;
    }
  }
}