import java.util.*;

class Walker {
  int x-next;
  int y-next;
  int x-prev;
  int y-prev;
  Random generator;

  Walker() {
    x-next = width/2;
    y-next = height/2;
    generator = new Random();
  }

  void display() {
    stroke(0);
    line(x-prev, y-prev, x-next, y-next);
  }

  void step() {
    float num = (float) generator.nextGaussian();
    float sd = 2;
    float mean = 5;

    float r = random(1);
    float lenght = sd * num + mean;

    x-prev = x-next;
    y-prev = y-next;

    if (r < 0.25) {
      x-next += lenght;
    } else if (r < 0.5) {
      x-next -= lenght;
    } else if (r < 0.75) {
      y-next += lenght;
    } else {
      y-next -= lenght;
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