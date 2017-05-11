Mover box;
float gravity;
float angle;

void setup() {
  size(640, 360);

  gravity = 0.4;
  angle = radians(60);

  float theta = angle;
  float x = cos(theta) * width;
  float y = sin(theta) * width;

  box = new Mover(4, x, height-y, angle);
}

void draw() {
  background(255);

  float r = (box.location.x / cos(angle)) / (cos(angle) * width);
  if (r <= 0) {
    r = 0;
  }

  PVector force = new PVector(
    gravity * -cos(angle) * r, 
    gravity *  sin(angle) * r);
  box.applyForce(force);

  PVector friction = box.velocity.copy();
  friction.mult(-1);
  friction.normalize();
  friction.mult(1 - r);
  box.applyForce(friction);

  box.update();
  box.display();
  box.checkEdges();

  line(0, height, cos(angle) * width, height - sin(angle) * width);
}