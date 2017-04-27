Spaceship ship;

void setup() {
  size(640, 360);
  ship = new Spaceship(width/2, height/2);
}

void draw() {
  background(255);

  ship.update();
  ship.wrapEdges();
  ship.display();
}

void keyPressed() {
  if (key == CODED && keyCode == LEFT) {
    ship.ccw();
  }
  if (key == CODED && keyCode == RIGHT) {
    ship.cw();
  }
  if (key == 'z' || key == 'Z') {
    ship.thrust();
  }
}
