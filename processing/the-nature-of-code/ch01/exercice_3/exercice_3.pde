class Walker {
  int x;
  int y;

  Walker() {
    x = width/2;
    y = height/2;
  }

  void display() {
    stroke(0);
    point(x, y);
  }

  void step() {
    float r = random(1);

    if (r < 0.125) {
      x++;
    } else if (r < 0.25) {
      x--;
    } else if (r < 0.375) {
      y++;
    } else if (r < 0.50) {
      y--;
    } else {
      updateByMouse();
    }
  }

  void updateByMouse() {
    if (mouseX > x) {
      x++;
    } else {
      x--;
    }

    if (mouseY > y) {
      y++;
    } else {
      y--;
    }
  }
}

Walker w;
int[] randomCounts;

void setup() {
  size(640, 360);
  w = new Walker();
  background(255);
}

void draw() {
  w.step();
  w.display();
}