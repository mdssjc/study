Mover[] movers;
Attractor mouse;

void setup() {
  size(400, 400);

  movers = new Mover[20];
  mouse = new Attractor();

  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(random(0.1, 2), random(width), random(height));
  }
}

void draw() {
  background(255);

  PVector force;
  for (int i = 0; i < movers.length; i++) {
    force = mouse.attract(movers[i]);
    movers[i].applyForce(force);

    for (int j = 0; j < movers.length; j++) {
      if (i != j) {
        force = movers[j].repel(movers[i]);
        movers[i].applyForce(force);
      }
    }

    mouse.update();
    movers[i].update();
    movers[i].display();
  }
}