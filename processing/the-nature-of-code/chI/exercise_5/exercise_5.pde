import java.util.*;

class Walker {
  float x;
  float y;
  float x_prev;
  float y_prev;
  Random generator;

  Walker() {
    x = width/2;
    y = height/2;
    generator = new Random();
  }

  void display() {
    stroke(0);
    line(x_prev, y_prev, x, y);
  }

  void step() {
    float num = (float) generator.nextGaussian();
    float sd = 2;
    float mean = 10;

    float r = random(1);
    float lenght = sd * num + mean;

    x_prev = x;
    y_prev = y;

    if (r < 0.25) {
      x += lenght;
    } else if (r < 0.5) {
      x -= lenght;
    } else if (r < 0.75) {
      y += lenght;
    } else {
      y -= lenght;
    }
  }
}

Walker w;

void setup() {
  size(640, 360);
  w = new Walker();
  background(255);
}

void draw() {
  w.step();
  w.display();
}