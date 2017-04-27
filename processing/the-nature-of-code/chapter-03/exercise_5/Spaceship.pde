class Spaceship {

  PVector position;
  PVector velocity;
  PVector acceleration;

  float damping;
  float topspeed;

  float heading;
  float headingStep;

  float r;

  boolean thrusting;

  Spaceship(float x, float y) {
    position = new PVector(x, y);
    velocity = new PVector();
    acceleration = new PVector();

    damping = 0.995;
    topspeed = 6;
    headingStep = 0.03;
    heading = 0;
    r = 16;
    thrusting = false;
  }

  void update() {
    velocity.add(acceleration);
    velocity.mult(damping);
    velocity.limit(topspeed);
    position.add(velocity);
    acceleration.mult(0);
  }

  void applyForce(PVector force) {
    acceleration.add(force.copy());
  }

  void ccw() {
    heading -= headingStep;
    if (heading < 0) {
      heading = 359;
    }
  }

  void cw() {
    heading += headingStep;
    if (heading > 360) {
      heading = 0;
    }
  }

  void thrust() {
    float angle = heading - PI/2;
    PVector force = new PVector(cos(angle), sin(angle));
    force.mult(0.1);
    applyForce(force);
    thrusting = true;
  }

  void wrapEdges() {
    float buffer = r*2;

    if (position.x > width + buffer) {
      position.x = -buffer;
    } else if (position.x < -buffer) {
      position.x = width + buffer;
    }

    if (position.y > height + buffer) {
      position.y = -buffer;
    } else if (position.y < -buffer) {
      position.y = height + buffer;
    }
  }

  void display() {
    stroke(0);
    strokeWeight(2);

    pushMatrix();

    translate(position.x, position.y+r);
    rotate(heading);

    fill(175);
    if (thrusting) {
      fill(255, 0, 0);
    }
    rect(-r/2, r, r/3, r/2);
    rect(r/2, r, r/3, r/2);

    fill(175);
    beginShape();
    vertex(-r, r);
    vertex(0, -r);
    vertex(r, r);
    endShape(CLOSE);

    rectMode(CENTER);

    popMatrix();

    thrusting = false;
  }
}
