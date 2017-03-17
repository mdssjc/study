class Walker {
  float x;
  float y;
  float x_prev;
  float y_prev;
  float tx;
  float ty;

  Walker() {
    x = width/2;
    y = height/2;
    tx = 0;
    ty = 10000;
  }

  void display() {
    stroke(0);
    strokeWeight(2);
    line(x_prev, y_prev, x, y);
  }

  void step() {
    x_prev = x;
    y_prev = y;
    x = map(noise(tx), 0, 1, 0, width);
    y = map(noise(ty), 0, 1, 0, height);

    tx += 0.01;
    ty += 0.01;

    x = constrain(x, 0, width-1);
    y = constrain(y, 0, height-1);
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