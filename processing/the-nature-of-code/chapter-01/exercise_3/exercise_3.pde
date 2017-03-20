class PVector {

  float x;
  float y;
  float z;

  PVector(float x_, float y_, float z_) {
    x = x_;
    y = y_;
    z = z_;
  }

  void add(PVector v) {
    x = x + v.x;
    y = y + v.y;
    z = z + v.z;
  }
}

PVector location;
PVector velocity;

void setup() {
  size(640, 360, P3D);
  lights();
  location = new PVector(100, 100, 0);
  velocity = new PVector(2.5, 5, 2.5);
}

void draw() {
  background(255);

  location.add(velocity);

  if ((location.x > width) || (location.x < 0)) {
    velocity.x = velocity.x * -1;
  }
  if ((location.y > height) || (location.y < 0)) {
    velocity.y = velocity.y * -1;
  }
  if ((location.z > 300) || (location.z < -1000)) {
    velocity.z = velocity.z * -1;
  }

  pushMatrix();
  translate(location.x, location.y, location.z);
  noFill();
  stroke(0);
  sphere(20);
  popMatrix();
}