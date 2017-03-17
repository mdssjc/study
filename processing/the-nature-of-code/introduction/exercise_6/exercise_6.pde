class Walker {
  float x;
  float y;
  float x_prev;
  float y_prev;

  Walker() {
    x = width/2;
    y = height/2;
  }

  void display() {
    stroke(0);
    strokeWeight(2);
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

    float stepx = random(-stepsize, stepsize);
    float stepy = random(-stepsize, stepsize);

    x_prev = x;
    y_prev = y;
    x += stepx;
    y += stepy;

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