float length;
int size;
int i;

void setup() {
  size(640, 360);
  length = height * 1/4;
  size = 20;
  i = 0;
}

void draw() {
  background(255);

  pushMatrix();

  translate(width / 2, height / 2); 
  rotate(radians(i % 360));
  i += 3;

  strokeWeight(2);
  fill(120);
  ellipse(0, length/2, size, size);
  line(0, length/2 - (size/2), 0, -length/2);
  ellipse(0, -length/2, size, size);

  popMatrix();
}