float increment = 0.01;

void setup() {
  size(640, 360);
  noLoop();
}

void draw() {
  background(0);

  noiseDetail(8, 0.65f);

  loadPixels();

  float xoff = 0.0;
  for (int x = 0; x < width; x++) {
    float yoff = 0.0;
    for (int y = 0; y < height; y++) {
      float bright = map(noise(xoff, yoff), 0, 1, 0, 255);
      pixels[x+y*width] = color(bright);
      yoff += increment;
    }
    xoff += increment;
  }

  updatePixels();
}