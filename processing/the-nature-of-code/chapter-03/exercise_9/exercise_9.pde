float yoff;

void setup() {
  size(400, 200);
  yoff = 0.0;
}

void draw() {
  background(255);

  float xoff = 0;

  for (int x = 0; x <= width; x += 24) {
    float y = map(noise(xoff, yoff), 0, 1, 0, height);

    stroke(0);
    fill(0, 50);
    ellipse(x, y, 48, 48);

    xoff += 0.05;
  }
  yoff += 0.01;
}