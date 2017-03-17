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
    line(x_prev, y_prev, x, y);
  }

  float montecarlo() {
    while (true) {
      float r1 = random(1);
      float probability = r1;
      float r2 = random(1);

      if (r2 < probability) {
        return r1;
      }
    }
  }

  void step() {
    float stepsize = montecarlo() * 10;

    float stepx = map(noise(tx), 0, 1, -stepsize, stepsize);
    float stepy = map(noise(ty), 0, 1, -stepsize, stepsize);

    x_prev = x;
    y_prev = y;
    x += stepx;
    y += stepy;

    if (x > width) {
      x = width;
    } 
    if (x < 0) {
      x = 0;
    }

    if (y > height) {
      y = height;
    } 
    if (y < 0) {
      y = 0;
    }

    tx += 0.01;
    ty += 0.01;
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