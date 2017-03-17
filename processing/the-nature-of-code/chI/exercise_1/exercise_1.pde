class Walker {
  int x;
  int y;

  Walker() {
    x = width/2;
    y = height/2;
  }

  void display() {
    stroke(0);
    strokeWeight(2);
    point(x, y);
  }

  void step() {
    int stepx = int(random(4))-1;
    int stepy = int(random(4))-1;

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