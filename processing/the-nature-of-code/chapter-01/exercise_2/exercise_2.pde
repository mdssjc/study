class Walker {
  PVector pos;
  PVector prev;

  Walker() {
    pos = new PVector(width/2, height/2);
  }

  void display() {
    stroke(0);
    strokeWeight(2);
    line(prev.x, prev.y, pos.x, pos.y);
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

    prev = new PVector(pos.x, pos.y);
    pos.add(new PVector(stepx, stepy));

    pos.x = constrain(pos.x, 0, width-1);
    pos.y = constrain(pos.y, 0, height-1);
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