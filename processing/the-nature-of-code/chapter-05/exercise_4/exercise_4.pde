import shiffman.box2d.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;

ArrayList<Polygon> polygons;
Box2DProcessing box2d;
Surface surface;

void setup() {
  size(640, 360);
  polygons = new ArrayList<Polygon>();
  box2d = new Box2DProcessing(this);
  box2d.createWorld();
  surface = new Surface();
}

void draw() {
  background(255);

  if (mousePressed) {
    Polygon p = new Polygon();
    polygons.add(p);
  }

  for (Polygon p : polygons) {
    p.display();
  }

  box2d.step();
  surface.display();
}