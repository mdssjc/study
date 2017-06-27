import shiffman.box2d.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.joints.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.contacts.*;

Box2DProcessing box2d;
ArrayList<Particle> particles;
ArrayList<Box> boxes;
Boundary wall;

void setup() {
  size(640, 360);
  box2d = new Box2DProcessing(this);
  box2d.createWorld();
  box2d.listenForCollisions();

  particles = new ArrayList<Particle>();
  boxes = new ArrayList<Box>();
  wall = new Boundary(width/2, height-5, width, 10);
}

void draw() {
  background(255);

  box2d.step();

  if (random(1) < 0.1) {
    float sz = random(4, 8);
    particles.add(new Particle(random(width), 20, sz));
  }

  if (random(1) < 0.1) {
    boxes.add(new Box(random(width), 20));
  }

  for (int i = particles.size()-1; i >= 0; i--) {
    Particle p = particles.get(i);
    p.display();
    if (p.done()) {
      particles.remove(i);
    }
  }

  for (int i = boxes.size()-1; i >= 0; i--) {
    Box b = boxes.get(i);
    b.display();
    if (b.done()) {
      boxes.remove(i);
    }
  }

  wall.display();
}

void beginContact(Contact cp) {
  Fixture f1 = cp.getFixtureA();
  Fixture f2 = cp.getFixtureB();

  Body b1 = f1.getBody();
  Body b2 = f2.getBody();

  Collision c1 = (Collision) b1.getUserData();
  Collision c2 = (Collision) b2.getUserData();

  if (!(c1 instanceof Boundary || c1 instanceof Boundary)) {
    c1.change();
    c2.change();
  }
}

void endContact(Contact cp) {
}