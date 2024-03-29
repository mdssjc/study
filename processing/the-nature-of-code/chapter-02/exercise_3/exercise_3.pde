Mover[] movers;

void setup() {
  size(640, 360);

  movers = new Mover[100];

  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(random(0.1, 5), 0, 0);
  }
}

void draw() {
  background(255);

  PVector wind = new PVector(0.01, 0);
  PVector gravity = new PVector(0, 0.1);

  for (int i = 0; i < movers.length; i++) {
    movers[i].applyForce(wind);
    movers[i].applyForce(gravity);
    movers[i].update();
    movers[i].display();
    movers[i].checkEdges();
  }
}