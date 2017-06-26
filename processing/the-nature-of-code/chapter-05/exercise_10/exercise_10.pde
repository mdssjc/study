import shiffman.box2d.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;

Box2DProcessing box2d;
Mover[] movers;
Attractor[] attractors;

void setup() {
  size(640, 360);
  box2d = new Box2DProcessing(this);
  box2d.createWorld();
  box2d.setGravity(0, 0);

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

  box2d.step();

  for (int i = 0; i < attractors.length; i++) {
    attractors[i].display();
  }

  for (int i = 0; i < movers.length; i++) {
    for (int j = 0; j < attractors.length; j++) {
      Vec2 force = attractors[j].attract(movers[i]);
      movers[i].applyForce(force);
    }

    movers[i].update();
    movers[i].display();
  }
}