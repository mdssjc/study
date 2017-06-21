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
Surface surface;
Bridge bridge;

void setup() {
  size(640, 360);
  box2d = new Box2DProcessing(this);
  box2d.createWorld();
  box2d.setGravity(0, -10);
  particles = new ArrayList<Particle>();
  //surface = new Surface();
  bridge = new Bridge();
}

void draw() {
  background(255);

  if (mousePressed) {
    float sz = random(2, 6);
    particles.add(new Particle(mouseX, mouseY, sz, false));
  }

  box2d.step();
  //surface.display();
  bridge.display();

  for (Particle p : particles) {
    p.display();
  }

  for (int i = particles.size()-1; i >= 0; i--) {
    Particle p = particles.get(i);
    if (p.done()) {
      particles.remove(i);
    }
  }
}