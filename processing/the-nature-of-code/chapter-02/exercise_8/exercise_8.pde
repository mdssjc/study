Mover[] movers;
Attractor[] attractors;

void setup() {
  size(640, 360);

  movers = new Mover[10];
  attractors = new Attractor[3];

  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(random(0.1, 2), random(width), random(height));
  }

  for (int i = 0; i < attractors.length; i++) {
    attractors[i] = new Attractor(random(2, 50), random(width), random(height), random(1) >= 0.5);
  }
}

void draw() {
  background(255);

  for (int i = 0; i < attractors.length; i++) {
    attractors[i].display();
  }

  for (int i = 0; i < movers.length; i++) {
    for (int j = 0; j < attractors.length; j++) {
      PVector force = attractors[j].attract(movers[i]);
      movers[i].applyForce(force);
    }

    movers[i].update();
    movers[i].display();
  }
}