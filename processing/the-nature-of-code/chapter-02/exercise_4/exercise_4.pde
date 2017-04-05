Mover[] movers = new Mover[20];

void setup() {
  size(640, 360);
  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(random(0.1, 5), random(0, width), 0);
  }
}

void draw() {
  background(255);

  PVector wind = new PVector(0.001, 0);
  PVector gravity = new PVector(0, 0.1);

  for (int i = 0; i < movers.length; i++) {
    movers[i].applyForce(wind);
    movers[i].applyForce(gravity);

    pockets(i);
    movers[i].update();
    movers[i].display();
    movers[i].checkEdges();
  }
}

void pockets(int i) {
  float r = random(0, 1);
  if (r < 0.20) {
    pocket1(i);
  } else if (r < 0.40) {
    pocket2(i);
  }
}

void pocket1(int i) {
  float y = movers[i].location.y;
  if (y >= (height * 0.40) && y <= (height * 0.60)) {
    applyFriction(i, random(0.01, 0.1), -1);
  }
}

void pocket2(int i) {
  PVector loc = movers[i].location;
  if (loc.x >= (width * 0.95) &&
    loc.y >= (height * 0.90) &&
    loc.y <= (height * 0.95)) {
    applyFriction(i, random(0.01, 0.25), 1);
  }
}

void applyFriction(int i, float c, int dir) {
  PVector friction = movers[i].velocity.get();
  friction.mult(dir);
  friction.normalize();
  friction.mult(c);

  movers[i].applyForce(friction);
}