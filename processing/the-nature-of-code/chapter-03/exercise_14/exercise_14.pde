Mover box;
PVector gravity;
float angle;

void setup() {
  size(640, 360);

  gravity = new PVector(0, 0.4);
  angle = radians(30);

  float theta = angle;
  float x = cos(theta) * width;
  float y = sin(theta) * width;

  box = new Mover(4, x, height-y, angle);
}

void draw() {
  background(255);

  //box.applyForce(friction);
  box.applyForce(gravity);
  box.update();
  box.display();
  box.checkEdges();

  line(0, height, cos(angle) * width, height - sin(angle) * width);
}