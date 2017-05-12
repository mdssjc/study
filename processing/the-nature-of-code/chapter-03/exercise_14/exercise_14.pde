Mover box;
float gravity;
float angle;

void setup() {
  size(640, 360);

  gravity = 0.4;
  angle = radians(10);

  float theta = angle;
  float x = cos(theta) * width;
  float y = sin(theta) * width;

  box = new Mover(4, x, height-y, angle);
}

void draw() {
  background(255);

  PVector forceNormal = new PVector(
    box.mass * gravity * -sin(angle), 
    box.mass * gravity *  sin(angle));
  box.applyForce(forceNormal);

  PVector forcePush = forceNormal.copy();
  forcePush.mult(-1);
  forcePush.mult(0.5);

  box.applyForce(forceNormal);
  box.applyForce(forcePush);

  if (box.location.x > box.mass) {
    box.update();
    box.checkEdges();
  }
  box.display();

  line(0, height, cos(angle) * width, height - sin(angle) * width);
}